package org.kuali.coeus.propdev.impl.s2s;

import org.kuali.coeus.s2sgen.api.generate.FormMappingInfo;
import org.kuali.coeus.s2sgen.api.generate.FormMappingService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S2sFormValuesFinder extends UifKeyValuesFinderBase {

    private transient FormMappingService formMappingService;

    @Override
    public List<KeyValue> getKeyValues() {
        return Stream.concat(Stream.of(ValuesFinderUtils.getSelectOption()), getFormMappingService().getBindings()
                .values()
                .stream()
                .map(FormMappingInfo::getFormName)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .map(name -> new ConcreteKeyValue(name, name)))
                .collect(Collectors.toList());
    }

    public FormMappingService getFormMappingService() {
        if (formMappingService == null) {
            formMappingService = KcServiceLocator.getService(FormMappingService.class);
        }

        return formMappingService;
    }

    public void setFormMappingService(FormMappingService formMappingService) {
        this.formMappingService = formMappingService;
    }
}
