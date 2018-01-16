/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.correspondence;

import org.kuali.kra.protocol.correspondence.BatchCorrespondenceBase;
import org.kuali.kra.protocol.correspondence.BatchCorrespondenceDetailBase;
import org.kuali.kra.protocol.correspondence.BatchCorrespondenceDetailFormBase;

public class IacucBatchCorrespondenceDetailForm extends BatchCorrespondenceDetailFormBase {


    private static final long serialVersionUID = 5275137818040289329L;

    @Override
    protected BatchCorrespondenceBase getNewBatchCorrespondenceInstanceHook() {
        return new IacucBatchCorrespondence();
    }

    @Override
    protected BatchCorrespondenceDetailBase getNewBatchCorrespondenceDetailInstanceHook() {
        return new IacucBatchCorrespondenceDetail();
    }

}
