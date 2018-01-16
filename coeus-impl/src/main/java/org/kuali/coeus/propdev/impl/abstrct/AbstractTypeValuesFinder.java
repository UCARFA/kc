/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.abstrct;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocumentForm;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;
import org.kuali.rice.krad.uif.field.InputField;
import org.kuali.rice.krad.uif.view.ViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Finds the available set of supported Abstract Types.  See
 * the method <code>getKeyValues()</code> for a full description.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
@Component("abstractTypeValuesFinder")
public class AbstractTypeValuesFinder extends UifKeyValuesFinderBase {

    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @Override
    public List<KeyValue> getKeyValues(ViewModel model, InputField field){
        ProposalDevelopmentDocumentForm form = (ProposalDevelopmentDocumentForm) model;
        String selectedAbstractType = getFieldValue(model,field);
        Collection<AbstractType> abstractTypes = getDataObjectService().findAll(AbstractType.class).getResults();
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        for (AbstractType abstractType : abstractTypes) {
            if (!hasAbstract(form.getProposalDevelopmentDocument(), abstractType) || StringUtils.equals(abstractType.getCode(),selectedAbstractType)) {
                keyValues.add(new ConcreteKeyValue(abstractType.getCode(), abstractType.getDescription()));
            }
        }
        return keyValues;
    }

    private boolean hasAbstract(ProposalDevelopmentDocument doc, AbstractType abstractType) {
        if (doc != null) {
            List<ProposalAbstract> proposalAbstracts = doc.getDevelopmentProposal().getProposalAbstracts();
            for (ProposalAbstract proposalAbstract : proposalAbstracts) {
                if (proposalAbstract.getAbstractTypeCode().equals(abstractType.getCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    private String getFieldValue(ViewModel model, InputField field) {
        if (!StringUtils.startsWith(field.getBindingInfo().getBindingPath(),"new")) {
            try {
                return (String) PropertyUtils.getNestedProperty(model,field.getBindingInfo().getBindingPath());
            } catch (Exception e) {
                throw new RuntimeException("could not retrieve abstract type from the input field", e);
            }
        }
        return StringUtils.EMPTY;
    }

    public DataObjectService getDataObjectService() {
        if (dataObjectService == null) {
            dataObjectService = KcServiceLocator.getService(DataObjectService.class);
        }
        return dataObjectService;
    }

    public void setDataObjectService(DataObjectService dataObjectService) {
        this.dataObjectService = dataObjectService;
    }
}
