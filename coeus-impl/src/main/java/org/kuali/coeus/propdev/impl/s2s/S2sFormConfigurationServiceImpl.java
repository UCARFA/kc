package org.kuali.coeus.propdev.impl.s2s;


import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.propdev.api.s2s.S2sFormConfigurationContract;
import org.kuali.coeus.propdev.api.s2s.S2sFormConfigurationService;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.krad.data.DataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("s2sFormConfigurationService")
public class S2sFormConfigurationServiceImpl implements S2sFormConfigurationService {

    private static final String FORM_NAME = "formName";
    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @Override
    public S2sFormConfigurationContract findS2sFormConfigurationByFormName(String formName) {
        if (StringUtils.isBlank(formName)) {
            throw new IllegalArgumentException("formName is blank");
        }

        return dataObjectService.findUnique(S2sFormConfiguration.class, QueryByCriteria.Builder.forAttribute(FORM_NAME, formName).build());
    }

    @Override
    public List<? extends S2sFormConfigurationContract> findAllS2sFormConfigurations() {
        return ListUtils.emptyIfNull(dataObjectService.findAll(S2sFormConfiguration.class).getResults());
    }

    public DataObjectService getDataObjectService() {
        return dataObjectService;
    }

    public void setDataObjectService(DataObjectService dataObjectService) {
        this.dataObjectService = dataObjectService;
    }
}
