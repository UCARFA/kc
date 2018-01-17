/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.coi.DisclosureReporterUnit;

import java.util.List;

public class AddDisclosureReporterUnitEvent  extends KcDocumentEventBaseExtension {
    
    private String propertyName;
    private DisclosureReporterUnit disclosureReporterUnit;
    private List<? extends DisclosureReporterUnit> disclosureReporterUnits;
    /**
     * Constructs a ProtocolAddReviewAttachmentEvent.
     * 
     * @param document The document to validate
     * @param propertyName The error path property prefix
     * @param reviewAttachment The added Reviewer Attachment
     */
    public AddDisclosureReporterUnitEvent(String propertyName, DisclosureReporterUnit disclosureReporterUnit, List<? extends DisclosureReporterUnit> disclosureReporterUnits) {
        super("Add reporter unit", "", null);
        this.propertyName = propertyName;
        this.disclosureReporterUnit = disclosureReporterUnit;
        this.disclosureReporterUnits = disclosureReporterUnits;
        
    }
        
    public String getPropertyName() {
        return propertyName;
    }
    
 
    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new AddDisclosureReporterUnitRule();
    }

    public DisclosureReporterUnit getDisclosureReporterUnit() {
        return disclosureReporterUnit;
    }

    public void setDisclosureReporterUnit(DisclosureReporterUnit disclosureReporterUnit) {
        this.disclosureReporterUnit = disclosureReporterUnit;
    }

    public List<? extends DisclosureReporterUnit> getDisclosureReporterUnits() {
        return disclosureReporterUnits;
    }

    public void setDisclosureReporterUnits(List<? extends DisclosureReporterUnit> disclosureReporterUnits) {
        this.disclosureReporterUnits = disclosureReporterUnits;
    }



}
