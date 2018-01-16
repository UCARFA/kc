/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.jqueryajax;

import org.kuali.rice.kns.web.struts.form.KualiDocumentFormBase;

/**
 * 
 * This class is the form class for jquery ajax call.
 */
public class JqueryAjaxForm extends  KualiDocumentFormBase {

    private static final long serialVersionUID = 7044288457270792953L;
    private String code;
    private String returnVal;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReturnVal() {
        return returnVal;
    }

    public void setReturnVal(String returnVal) {
        this.returnVal = returnVal;
    }

}
