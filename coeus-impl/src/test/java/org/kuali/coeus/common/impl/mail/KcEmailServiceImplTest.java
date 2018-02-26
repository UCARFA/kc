/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.impl.mail;

import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.core.api.config.property.ConfigContext;
import org.kuali.rice.core.impl.config.property.JAXBConfigImpl;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.mockito.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.util.ReflectionTestUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.kuali.coeus.common.impl.mail.KcEmailServiceImpl.*;
import static org.mockito.Mockito.*;

@PrepareForTest(ConfigContext.class)
@RunWith(PowerMockRunner.class)
public class KcEmailServiceImplTest {

    private static final String ADMIN_MAIL_TO = "admin@kc.app";
    private static final String MAIL_FROM = "notification@kc.app";
    private static final String MAIL_TO = "recipient@kc.app";
    private static final String MAIL_SUBJECT = "This is a KC-related email!";
    private static final String MAIL_BODY = "Kuali Coeus wants to tell you something!!";
    private static final String TEST_MAIL_BODY = "TEST MODE<br/>";

    private static final String PRODUCTION_ENVIRONMENT = "prd";
    private static final String TEST_ENVIRONMENT = "tst";

    @Spy
    private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    @Mock
    private ParameterService parameterService;

    @InjectMocks
    private KcEmailServiceImpl kcEmailService;

    private JAXBConfigImpl config;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        config = mock(JAXBConfigImpl.class);
        when(config.getProductionEnvironmentCode()).thenReturn(PRODUCTION_ENVIRONMENT);
        when(config.isProductionEnvironment()).thenCallRealMethod();
        PowerMockito.mockStatic(ConfigContext.class);
        when(ConfigContext.getCurrentContextConfig()).thenReturn(config);
        doNothing().when(mailSender).send(any(MimeMessage.class));
        ReflectionTestUtils.setField(kcEmailService, "executorService", MoreExecutors.newDirectExecutorService());
    }

    @Test
    public void testEmailsNotSentInAnyEnvironmentWhenDisabled() {
        mockParameterValue(EMAIL_NOTIFICATIONS_ENABLED_PARAM, false);

        when(config.getEnvironment()).thenReturn(PRODUCTION_ENVIRONMENT);
        sendEmail(MAIL_FROM, MAIL_TO);
        verify(mailSender, never()).send(any(MimeMessage.class));

        when(config.getEnvironment()).thenReturn(TEST_ENVIRONMENT);
        sendEmail(MAIL_FROM, MAIL_TO);
        verify(mailSender, never()).send(any(MimeMessage.class));
    }

    @Test
    public void testEmailsSentInProdWhenEnabled() {
        when(config.getEnvironment()).thenReturn(PRODUCTION_ENVIRONMENT);
        mockParameterValue(EMAIL_NOTIFICATIONS_ENABLED_PARAM, true);

        sendEmail(MAIL_FROM, MAIL_TO);
        verify(mailSender).send(argThat(new MimeMessageMatcher(MAIL_SUBJECT, MAIL_BODY, MAIL_TO)));
    }

    @Test
    public void testEmailingDefaultRecipientInProd() {
        when(config.getEnvironment()).thenReturn(PRODUCTION_ENVIRONMENT);
        mockParameterValue(EMAIL_NOTIFICATIONS_ENABLED_PARAM, true);

        sendEmail(MAIL_FROM);
        verify(mailSender, never()).send(any(MimeMessage.class));

        mockParameterValue(KC_DEFAULT_EMAIL_RECIPIENT_PARAM, ADMIN_MAIL_TO);
        sendEmail(MAIL_FROM);
        verify(mailSender).send(argThat(new MimeMessageMatcher(MAIL_SUBJECT, MAIL_BODY, ADMIN_MAIL_TO)));
    }

    @Test
    public void testEmailsSentToTestAddressInTestWhenEnabled() {
        when(config.getEnvironment()).thenReturn(TEST_ENVIRONMENT);
        mockParameterValue(EMAIL_NOTIFICATIONS_ENABLED_PARAM, true);
        mockParameterValue(EMAIL_NOTIFICATIONS_TEST_ENABLED_PARAM, true);

        sendEmail(MAIL_FROM, MAIL_TO);
        verify(mailSender, never()).send(any(MimeMessage.class));

        mockParameterValue(EMAIL_NOTIFICATION_TEST_ADDRESS_PARAM, ADMIN_MAIL_TO);
        sendEmail(MAIL_FROM, MAIL_TO);
        verify(mailSender).send(argThat(new MimeMessageMatcher(MAIL_SUBJECT, TEST_MAIL_BODY, ADMIN_MAIL_TO)));
    }

    @Test
    public void testNoEmailsSentToTestAddressInTestWhenDisabled() {
        when(config.getEnvironment()).thenReturn(TEST_ENVIRONMENT);
        mockParameterValue(EMAIL_NOTIFICATIONS_ENABLED_PARAM, true);
        mockParameterValue(EMAIL_NOTIFICATIONS_TEST_ENABLED_PARAM, false);
        mockParameterValue(EMAIL_NOTIFICATION_TEST_ADDRESS_PARAM, ADMIN_MAIL_TO);

        sendEmail(MAIL_FROM, MAIL_TO);
        verify(mailSender, never()).send(any(MimeMessage.class));
    }


    @Test
    public void testEmailingDefaultRecipientInTest() {
        when(config.getEnvironment()).thenReturn(TEST_ENVIRONMENT);
        mockParameterValue(EMAIL_NOTIFICATIONS_ENABLED_PARAM, true);
        mockParameterValue(EMAIL_NOTIFICATIONS_TEST_ENABLED_PARAM, true);

        sendEmail(MAIL_FROM);
        verify(mailSender, never()).send(any(MimeMessage.class));

        mockParameterValue(KC_DEFAULT_EMAIL_RECIPIENT_PARAM, ADMIN_MAIL_TO);
        sendEmail(MAIL_FROM);
        verify(mailSender, never()).send(any(MimeMessage.class));

        mockParameterValue(EMAIL_NOTIFICATION_TEST_ADDRESS_PARAM, ADMIN_MAIL_TO);
        sendEmail(MAIL_FROM);
        verify(mailSender).send(argThat(new MimeMessageMatcher(MAIL_SUBJECT, MAIL_BODY, ADMIN_MAIL_TO)));
    }

    private void sendEmail(String from, String... to) {
        kcEmailService.sendEmail(from, new HashSet<>(Arrays.asList(to)), MAIL_SUBJECT, Collections.emptySet(),
                Collections.emptySet(), MAIL_BODY, false);
    }

    private void mockParameterValue(String parameterName, boolean parameterValue) {
        when(parameterService.getParameterValueAsBoolean(eq(Constants.KC_GENERIC_PARAMETER_NAMESPACE),
                eq(Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE), eq(parameterName), anyBoolean())).thenReturn(parameterValue);
    }

    private void mockParameterValue(String parameterName, String parameterValue) {
        when(parameterService.getParameterValueAsString(eq(Constants.KC_GENERIC_PARAMETER_NAMESPACE),
                eq(Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE), eq(parameterName))).thenReturn(parameterValue);
    }

    private static class MimeMessageMatcher implements ArgumentMatcher<MimeMessage> {

        private static final String RECIPIENTS_HEADER = "To";

        private final String subject;
        private final String body;
        private final String recipients;

        MimeMessageMatcher(String subject, String body, String recipients) {
            this.subject = subject;
            this.body = body;
            this.recipients = recipients;
        }

        @Override
        public boolean matches(MimeMessage message) {
            try {
                return subject.equals(message.getSubject()) &&
                        bodyTextContains(message.getContent()) &&
                        recipients.equals(message.getHeader(RECIPIENTS_HEADER)[0]);
            } catch (IOException | MessagingException e) {
                return false;
            }
        }

        private boolean bodyTextContains(Object messageContent) throws IOException, MessagingException {
            while (messageContent instanceof MimeMultipart) {
                messageContent = ((MimeMultipart) messageContent).getBodyPart(0).getContent();
            }
            return messageContent.toString().contains(body);
        }
    }

}
