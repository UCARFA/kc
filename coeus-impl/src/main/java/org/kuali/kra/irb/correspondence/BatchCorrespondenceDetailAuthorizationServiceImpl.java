/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.correspondence;

import org.kuali.kra.protocol.correspondence.BatchCorrespondenceDetailAuthorizationServiceImplBase;

/**
 * 
 * This class provides a call to validate whether user has certain permission.
 */
public class BatchCorrespondenceDetailAuthorizationServiceImpl extends BatchCorrespondenceDetailAuthorizationServiceImplBase implements BatchCorrespondenceDetailAuthorizationService {

    @Override
    protected String getNameSpaceHook() {
        return "KC-PROTOCOL";
    }

}
