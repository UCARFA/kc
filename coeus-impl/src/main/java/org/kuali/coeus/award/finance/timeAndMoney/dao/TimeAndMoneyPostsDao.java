/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.award.finance.timeAndMoney.dao;


import org.kuali.coeus.award.finance.timeAndMoney.TimeAndMoneyPosts;

import java.util.List;

public interface TimeAndMoneyPostsDao {

    TimeAndMoneyPosts getTimeAndMoneyPostsByDocumentNumber(String documentNumber);

    List<TimeAndMoneyPosts> getActiveTimeAndMoneyPostsForAwardHierarchy(String awardNumber);

    TimeAndMoneyPosts getTimeAndMoneyPost(Long id);

    List<TimeAndMoneyPosts> getActiveTimeAndMoneyPosts();
}