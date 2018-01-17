/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.controller;

import org.kuali.rice.krad.web.form.UifFormBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** public and protected methods from Rice's UifExportController */
public interface UifExportControllerService {

    //public methods

    public String tableCsvRetrieval(UifFormBase form, HttpServletRequest request,
                                    HttpServletResponse response);

    public String tableXlsRetrieval(UifFormBase form, HttpServletRequest request,
                                    HttpServletResponse response);

    public String tableXmlRetrieval(UifFormBase form, HttpServletRequest request,
                                    HttpServletResponse response);
}
