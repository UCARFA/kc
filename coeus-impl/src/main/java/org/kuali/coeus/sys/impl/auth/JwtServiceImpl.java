/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.sys.impl.auth;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.keys.HmacKey;
import org.jose4j.lang.JoseException;
import org.kuali.coeus.sys.framework.auth.AuthConstants;
import org.kuali.coeus.sys.framework.auth.JwtService;
import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Service("jwtService")
public class JwtServiceImpl implements JwtService {

    private static final String SHARED_SECRET = "auth.filter.service2service.secret";
    private static final String SERVICE_2_SERVICE_ENABLED = "auth.filter.service2service.enabled";
    private static final String SINGLE_USE = "auth.filter.service2service.singleUse";
    private static final String UUID_CLAIM = "uuid";
    private static final String AUTHORIZATION_PREFIX = "Bearer ";

    @Autowired
    @Qualifier("kualiConfigurationService")
    private ConfigurationService configurationService;

    private JwtConsumer jwtConsumer;
    private Cache<String, String> usedTokens;

    @Override
    public boolean verifyToken(String authToken) {
        if (!isService2serviceEnabled()) {
            return false;
        }

        String jwtString = getJwtString(authToken);

        if (StringUtils.isEmpty(jwtString)) {
            return false;
        }

        try {

            JwtClaims jwtClaims =  getJwtConsumer().processToClaims(jwtString);
            if (isSingleUse()) {
                return validateSingleUse(jwtClaims);
            }
            return true;
        } catch(InvalidJwtException e) {
            return false;
        }
    }

    @Override
    public String createToken()  {
        if (isService2serviceEnabled()) {
            try {
                return createJsonWebSignature().getCompactSerialization();
            } catch(JoseException e) {
                throw new RuntimeException(e);
            }
        }
        return getSystemAuthToken();

    }

    protected boolean validateSingleUse(JwtClaims jwtClaims) {
        String uuid = jwtClaims.getClaimValue(UUID_CLAIM).toString();
        if (getUsedTokens().getIfPresent(uuid) == null) {
            getUsedTokens().put(uuid, uuid);
            return true;
        }
        return false;
    }

    protected JsonWebSignature createJsonWebSignature() {
        JsonWebSignature jws =  new JsonWebSignature();
        jws.setKey(new HmacKey(getServiceSecret().getBytes()));
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.HMAC_SHA256);
        jws.setDoKeyValidation(false);
        jws.setPayload(createClaims().toJson());
        return jws;
    }

    protected JwtClaims createClaims() {
        JwtClaims jwtClaims = new JwtClaims();
        jwtClaims.setExpirationTimeMinutesInTheFuture(1);
        jwtClaims.setIssuedAtToNow();
        jwtClaims.setClaim(UUID_CLAIM, UUID.randomUUID());
        return jwtClaims;
    }

    protected String getJwtString(String authTokenValue) {
        if (!StringUtils.startsWith(authTokenValue, AUTHORIZATION_PREFIX)) {
            return null;
        } else {
            String[] parts = authTokenValue.split(" ");
            if (parts.length < 2) {
                return null;
            }
            return parts[1];
        }
    }

    protected boolean isService2serviceEnabled() {
        return getConfigurationService().getPropertyValueAsBoolean(SERVICE_2_SERVICE_ENABLED);
    }

    protected String getServiceSecret() {
        return getConfigurationService().getPropertyValueAsString(SHARED_SECRET);
    }

    protected boolean isSingleUse() {
        return getConfigurationService().getPropertyValueAsBoolean(SINGLE_USE);
    }

    protected String getSystemAuthToken() {
        return getConfigurationService().getPropertyValueAsString(AuthConstants.AUTH_SYSTEM_TOKEN_PARAM);
    }

    public ConfigurationService getConfigurationService() {
        return configurationService;
    }

    public void setConfigurationService(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    public JwtConsumer getJwtConsumer() {
        if (jwtConsumer == null) {
            jwtConsumer = new JwtConsumerBuilder()
                    .setVerificationKey(new HmacKey(getServiceSecret().getBytes()))
                    .setRelaxVerificationKeyValidation()
                    .build();
        }
        return jwtConsumer;
    }

    public Cache<String, String> getUsedTokens() {
        if (usedTokens == null) {
            usedTokens = CacheBuilder
                .newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build();
        }
        return usedTokens;
    }
}
