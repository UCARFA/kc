/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.medusa;

import org.kuali.rice.kns.web.struts.form.KualiDocumentFormBase;


public class MedusaForm extends KualiDocumentFormBase {

    private MedusaBean medusaBean;
    
    public MedusaForm() {
        medusaBean = new MedusaBean();
    }

    public MedusaBean getMedusaBean() {
        return medusaBean;
    }

    public void setMedusaBean(MedusaBean medusaBean) {
        this.medusaBean = medusaBean;
    }
}
