/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.dataovveride;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.rolodex.Rolodex;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocumentForm;
import org.kuali.coeus.propdev.impl.dataovveride.common.AbstractDataOverrideInputField;
import org.kuali.rice.krad.uif.util.ComponentFactory;


public class DataOverrideInputField extends AbstractDataOverrideInputField {
    private static final String MAILING_ADDRESS_COLUMN = "MAILING_ADDRESS_ID";

    @Override
    public String getEntryName() {
        return "DevelopmentProposal";
    }

    @Override
    public void performInitialization(Object model){
        if(!isInCollection()) {
            this.setDictionaryAttributeName(((ProposalDevelopmentDocumentForm)model).getNewProposalChangedData().getAttributeName());
            if(this.getDictionaryAttributeName() == null) {
                this.setDictionaryAttributeName("title");
            }
        }
        this.setDictionaryObjectEntry(DevelopmentProposal.class.getName());

        if (StringUtils.equals(((ProposalDevelopmentDocumentForm)model).getNewProposalChangedData().getColumnName(),MAILING_ADDRESS_COLUMN)) {
            this.setControl(ComponentFactory.getTextControl());

            this.setQuickfinder(ComponentFactory.getQuickFinder());
            this.getQuickfinder().setReturnByScript(true);
            this.getQuickfinder().setDataObjectClassName(Rolodex.class.getName());
            this.getQuickfinder().getFieldConversions().put("rolodexId","newProposalChangedData.changedValue");
        }
        super.performInitialization(model);
    }
}
