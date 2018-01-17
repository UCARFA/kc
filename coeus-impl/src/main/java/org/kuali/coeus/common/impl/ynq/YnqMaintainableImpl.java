/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.ynq;

import org.apache.commons.collections4.CollectionUtils;
import org.kuali.coeus.common.framework.ynq.Ynq;
import org.kuali.coeus.common.framework.ynq.YnqExplanation;
import org.kuali.coeus.common.framework.ynq.YnqExplanationType;
import org.kuali.coeus.common.framework.ynq.YnqService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.maintenance.KraMaintainableImpl;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.kns.maintenance.Maintainable;
import org.kuali.rice.kns.web.ui.Section;

import java.util.List;

public class YnqMaintainableImpl extends KraMaintainableImpl {
    private static final long serialVersionUID = -8242765028364970138L;

    /**
     * This is a hook for initializing the BO from the maintenance framework.
     * It initializes the {@link Explanation}s collection.
     *
     * @param generateDefaultValues true for initialization
     */
    @Override
    public void setGenerateDefaultValues(String docTypeName) {
        initExplanation();
        super.setGenerateDefaultValues(docTypeName);
    }

    /**
     * This is just trying to populate existing ynq that has no explanation
     * @see org.kuali.core.maintenance.KualiMaintainableImpl#getCoreSections(org.kuali.core.maintenance.Maintainable)
     */
    @Override
    public List<Section> getCoreSections(MaintenanceDocument document, Maintainable oldMaintainable) {
        Ynq ynq = ((Ynq)getBusinessObject());
        if (CollectionUtils.isEmpty(ynq.getYnqExplanations())) {
            initExplanation();
        }
        return super.getCoreSections(document, oldMaintainable);
    }

    /**
     * Gets the {@link Ynq}
     * 
     * @return
     */
    public Ynq getYnq() {
        return (Ynq) getBusinessObject();
    }

    /**
     * Method to initialize YNQ with Explanation types.
     *
     */
    private void initExplanation() {
        List<YnqExplanation> ynqExplanations = getYnq().getYnqExplanations();
        if (!ynqExplanations.isEmpty()) {
            throw new AssertionError();
        }
        
        List<YnqExplanationType> ynqExplanationTypes = getYnqExplanationTypes();
        for (YnqExplanationType type : ynqExplanationTypes) {
            YnqExplanation ynqExplanation = new YnqExplanation();
            ynqExplanation.setExplanationType(type.getExplanationType());
            ynqExplanation.setYnqExplanationType(type); 
            ynqExplanations.add(ynqExplanation);
        }
    }

    private List<YnqExplanationType> getYnqExplanationTypes() {
         List<YnqExplanationType> ynqExplanationTypes = (KcServiceLocator.getService(YnqService.class).getYnqExplanationTypes());
         return ynqExplanationTypes;
     }

}
