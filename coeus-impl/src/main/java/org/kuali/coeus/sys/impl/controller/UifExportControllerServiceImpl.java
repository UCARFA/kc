/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.controller;

import org.kuali.coeus.sys.framework.controller.UifExportControllerService;
import org.kuali.rice.krad.web.controller.UifExportController;
import org.springframework.stereotype.Component;

/** this service must @Override methods and call super in order to elevate a method to public to satisfy the interface. */
@Component("uifExportControllerService")
public class UifExportControllerServiceImpl extends UifExportController implements UifExportControllerService {

}
