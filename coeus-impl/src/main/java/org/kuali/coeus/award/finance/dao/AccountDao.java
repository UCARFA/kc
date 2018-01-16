/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.finance.dao;

import org.kuali.coeus.award.finance.AwardAccount;
import org.kuali.coeus.award.finance.AwardPosts;
import org.kuali.kra.award.home.Award;

import java.util.List;

public interface AccountDao {

    public List<AwardAccount> getAccounts(Integer startIndex, Integer size);

    public AwardAccount getAccount(String accountNumber);

    public AwardAccount saveAccount(AwardAccount account);

    public Award getAward(Long awardId);

    List<AwardPosts> getActiveAwardPosts(String accountNumber);

    AwardPosts getAwardPostsById(Long postId);

    List<AwardPosts> getAllAwardPostsInHierarchy(String accountNumber, String awardNumber);

    }
