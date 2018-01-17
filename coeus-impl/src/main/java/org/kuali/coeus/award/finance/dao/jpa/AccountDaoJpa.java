/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.finance.dao.jpa;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.award.finance.AwardAccount;
import org.kuali.coeus.award.finance.AwardPosts;
import org.kuali.coeus.award.finance.dao.AccountDao;
import org.kuali.kra.award.home.Award;
import org.kuali.rice.core.api.criteria.*;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

@Repository("accountDao")
public class AccountDaoJpa implements AccountDao {

    public static final String ACCOUNT_NUMBER = "accountNumber";
    public static final String AWARD_ID = "awardId";
    public static final String ALL_ACCOUNTS_QUERY = "select a from AwardAccount a ORDER BY a.id ASC";

    public static final String ACTIVE = "active";
    public static final String UPDATE_TIMESTAMP = "updateTimestamp";
    public static final String AWARD_FAMILY = "awardFamily";

    @Autowired
    @Qualifier("businessObjectService")
    private BusinessObjectService businessObjectService;

    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @Autowired
    @Qualifier("kcEntityManager")
    private EntityManager entityManager;

    @Override
    public List<AwardAccount> getAccounts(Integer startIndex, Integer size) {
        Query query = getEntityManager().createQuery(ALL_ACCOUNTS_QUERY, AwardAccount.class);
        if (startIndex != null && size != null) {
            query.setFirstResult(startIndex);
            query.setMaxResults(size);
        }
        List<AwardAccount> accounts = (List<AwardAccount>)query.getResultList();
        return ListUtils.emptyIfNull(accounts);
    }

    @Override
    public AwardAccount getAccount(String accountNumber) {
        AwardAccount account = getDataObjectService().findUnique(AwardAccount.class,
                QueryByCriteria.Builder.forAttribute(ACCOUNT_NUMBER, accountNumber).build());
        return account;
    }

    @Override
    public AwardAccount saveAccount(AwardAccount account) {
        account = getDataObjectService().save(account);
        return account;
    }

    @Override
    public List<AwardPosts> getActiveAwardPosts(String accountNumber) {
        Map<String, Object> keys = new HashMap<>();
        if (accountNumber != null) {
            keys.put(ACCOUNT_NUMBER, accountNumber);
        }
        keys.put(ACTIVE, Boolean.TRUE);
        return getDataObjectService().findMatching(AwardPosts.class, QueryByCriteria.Builder.andAttributes(keys).build()).getResults();
    }

    @Override
    public List<AwardPosts> getAllAwardPostsInHierarchy(String accountNumber, String awardNumber) {
        String awardFamily = awardNumber.substring(0, StringUtils.indexOf(awardNumber, "-"));
        Map<String, Object> keys = new HashMap<>();
        if (accountNumber != null) {
            keys.put(ACCOUNT_NUMBER, accountNumber);
        }
        keys.put(AWARD_FAMILY, awardFamily);
        List<OrderByField> orderByFields = new ArrayList<>();
        orderByFields.add(OrderByField.Builder.create(UPDATE_TIMESTAMP, OrderDirection.DESCENDING).build());
        return getDataObjectService().findMatching(AwardPosts.class, QueryByCriteria.Builder.andAttributes(keys).
                setOrderByFields(orderByFields).build()).getResults();
    }

    @Override
    public AwardPosts getAwardPostsById(Long postId) {
            return getDataObjectService().find(AwardPosts.class, postId);
    }

    @Override
    public Award getAward(Long awardId) {
        return  getBusinessObjectService().findByPrimaryKey(Award.class, Collections.singletonMap(AWARD_ID, awardId));
    }

    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    public DataObjectService getDataObjectService() {
        return dataObjectService;
    }

    public void setDataObjectService(DataObjectService dataObjectService) {
        this.dataObjectService = dataObjectService;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



}
