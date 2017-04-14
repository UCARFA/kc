/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
