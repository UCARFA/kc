/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.creditsplit;


import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.type.InvestigatorCreditType;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocumentForm;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentViewHelperServiceImpl;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.rice.kew.api.WorkflowDocument;
import org.kuali.rice.krad.uif.component.BindingInfo;
import org.kuali.rice.krad.uif.component.Component;
import org.kuali.rice.krad.uif.container.CollectionGroupBase;
import org.kuali.rice.krad.uif.field.DataFieldBase;
import org.kuali.rice.krad.uif.lifecycle.ViewLifecycleRestriction;
import org.kuali.rice.krad.uif.util.*;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CreditSplitCustomColumnsCollection extends CollectionGroupBase {

    private DataFieldBase columnFieldPrototype;
    private BindingInfo columnBindingInfo;
    private Class<?> columnObjectClass;
    private String columnLabelPropertyName;

    @Override
    public void performInitialization(Object model) {

        ProposalDevelopmentDocumentForm pdForm = (ProposalDevelopmentDocumentForm) model;
        ((ProposalDevelopmentViewHelperServiceImpl) pdForm.getViewHelperService()).setInvestigatorCreditTypes(pdForm);
        List<ProposalPerson> investigators = ((ProposalDevelopmentDocumentForm) model).getDevelopmentProposal().getPersonsSelectedForCreditSplit();
        if (CollectionUtils.isNotEmpty(investigators)) {
        List<InvestigatorCreditType> columnCollection = ObjectPropertyUtils.getPropertyValue(model,
                getColumnBindingInfo().getBindingPath());


        List<Component> columns = new ArrayList<>();
        for (Component component : this.getItems()) {
            if (component.isRender() || component.isHidden()) {
                columns.add(component);
            }
        }

        WorkflowDocument workflowDocument = pdForm.getProposalDevelopmentDocument().getDocumentHeader().getWorkflowDocument();
        boolean isSubmitted = !workflowDocument.isInitiated() && !workflowDocument.isSaved();
        int index = 0;
        for (Object column : filterColumns(columnCollection, investigators, isSubmitted)) {
            DataFieldBase columnField = ComponentUtils.copy(columnFieldPrototype);
            String columnLabel = StringUtils.isEmpty(columnLabelPropertyName)?"description":columnLabelPropertyName;

            try {
                columnField.getFieldLabel().setLabelText(PropertyUtils.getNestedProperty(column,columnLabel).toString());
                columnField.getBindingInfo().setBindingName("creditSplits[" + index + "].credit");
                columnField.setPropertyName("creditSplits.credit");
                columnField.setOrder(100 + index);
                columns.add(columnField);
            } catch (IllegalAccessException|InvocationTargetException|NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        index++;
        }
        this.setItems(columns);
        }
        super.performInitialization(model);
    }

    protected List<InvestigatorCreditType> filterColumns(List<InvestigatorCreditType> columnCollection, List<ProposalPerson> investigators, boolean isSubmitted) {
        if (!isSubmitted) {
            return columnCollection;
        }

        return columnCollection.stream()
                .filter(column -> investigators.stream()
                        .anyMatch(investigator -> investigator.getCreditSplits().stream()
                                .anyMatch(proposalPersonCreditSplit ->  {
            return proposalPersonCreditSplit.getInvCreditTypeCode().equals(column.getCode());
        }))).collect(Collectors.toList());

    }

    @ViewLifecycleRestriction
    public DataFieldBase getColumnFieldPrototype() {
        return columnFieldPrototype;
    }

    public void setColumnFieldPrototype(DataFieldBase columnFieldPrototype) {
        this.columnFieldPrototype = columnFieldPrototype;
    }

    public BindingInfo getColumnBindingInfo() {
        return columnBindingInfo;
    }

    public void setColumnBindingInfo(BindingInfo columnBindingInfo) {
        this.columnBindingInfo = columnBindingInfo;
    }

    public Class<?> getColumnObjectClass() {
        return columnObjectClass;
    }

    public void setColumnObjectClass(Class<?> columnObjectClass) {
        this.columnObjectClass = columnObjectClass;
    }

    public String getColumnLabelPropertyName() {
        return columnLabelPropertyName;
    }

    public void setColumnLabelPropertyName(String columnLabelPropertyName) {
        this.columnLabelPropertyName = columnLabelPropertyName;
    }
}
