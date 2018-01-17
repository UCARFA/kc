/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.org.kuali.rice.krad.uif.element;


import org.kuali.coeus.sys.framework.controller.KcFileService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.krad.uif.control.FileControl;

public class KcFileControl extends FileControl {

    @Override
    public void performInitialization(Object model) {
        long maxUploadSize = KcServiceLocator.getService(KcFileService.class).getMaxUploadSizeParameter();
        this.setOnChangeScript("Kc.Global.validateAttachmentFile(this," + maxUploadSize + ");");
        super.performInitialization(model);
    }
}
