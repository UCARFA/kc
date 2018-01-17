/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.customdata;

import org.kuali.coeus.common.framework.custom.CustomDataHelperBase;
import org.kuali.coeus.common.framework.custom.attr.CustomAttributeDocument;
import org.kuali.kra.negotiations.bo.Negotiation;
import org.kuali.kra.negotiations.document.NegotiationDocument;
import org.kuali.kra.negotiations.web.struts.form.NegotiationForm;

import java.util.List;
import java.util.Map;

/**
 *   CustomDataHelper class
 */
public class CustomDataHelper extends CustomDataHelperBase<NegotiationCustomData> {


    private static final long serialVersionUID = -716264183914346452L;

    private NegotiationForm negotiationForm;    
    
    /**
     * Constructs a CustomDataHelper.
     * @param from the awardForm
     */
    public CustomDataHelper(NegotiationForm negotiationForm) {
        this.negotiationForm = negotiationForm;
    }
    
    
    
    /*
     * Get the Negotiation.
     */
    private Negotiation getNegotiation() {
        NegotiationDocument document = negotiationForm.getNegotiationDocument();
        if (document == null || document.getNegotiation() == null) {
            throw new IllegalArgumentException("invalid (null) NegotiationDocument in NegotiationForm");
        }
        return document.getNegotiation();
    }
    
    @Override
    public boolean canModifyCustomData() {

        return false;
    }
    
    @Override
    protected NegotiationCustomData getNewCustomData() {
        return new NegotiationCustomData();
    }

    @Override
    public List<NegotiationCustomData> getCustomDataList() {
        return getNegotiation().getNegotiationCustomDataList();
    }

    @Override
    public Map<String, CustomAttributeDocument> getCustomAttributeDocuments() {
        return negotiationForm.getNegotiationDocument().getCustomAttributeDocuments();
    }
   
    @Override
    public boolean documentNotRouted() {
       return true;
    }
}
