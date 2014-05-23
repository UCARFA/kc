package org.kuali.coeus.propdev.impl.s2s;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.coeus.propdev.impl.s2s.connect.S2sCommunicationException;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.lookup.LookupForm;
import org.kuali.rice.krad.lookup.LookupableImpl;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
   todo in xml from s2sOpportunityLookupableHelperService :
   format urls as href
   conditionally display return link
   create link

   GlobalVariables.getMessageMap().putInfo(KRADConstants.GLOBAL_INFO, Constants.GRANTS_GOV_LINK);
 */

public class S2sOpportunityLookupable extends LookupableImpl {

    private static final Log LOG = LogFactory.getLog(S2sOpportunityLookupable.class);

    private S2sSubmissionService s2sSubmissionService;

    @Override
    public List<?> performSearch(LookupForm form, Map<String, String> searchCriteria, boolean unbounded) {

        final String providerCode = searchCriteria.get(Constants.PROVIDER_CODE);
        final String cfdaNumber = searchCriteria.get(Constants.CFDA_NUMBER);
        final String opportunityId = searchCriteria.get(Constants.OPPORTUNITY_ID);
        if (StringUtils.isBlank(providerCode)) {
            GlobalVariables.getMessageMap().putError(Constants.PROVIDER_CODE, KeyConstants.ERROR_S2S_PROVIDER_INVALID);
            return Collections.emptyList();
        }

        List<S2sOpportunity> s2sOpportunity = new ArrayList<S2sOpportunity>();
        if (StringUtils.isNotBlank(cfdaNumber) || StringUtils.isNotBlank(opportunityId)) {
            try {
                s2sOpportunity = getS2sSubmissionService().searchOpportunity(providerCode, cfdaNumber, opportunityId, "");
            }catch (S2sCommunicationException e) {
                LOG.error(e.getMessage(), e);
                GlobalVariables.getMessageMap().putError(Constants.NO_FIELD, e.getErrorKey(),e.getMessage());
                return Collections.emptyList();
            }
            if (s2sOpportunity != null && !s2sOpportunity.isEmpty()) {
                return s2sOpportunity;
            } else if (StringUtils.isNotBlank(cfdaNumber) && StringUtils.isNotBlank(opportunityId)) {
                try{
                    s2sOpportunity = getS2sSubmissionService().searchOpportunity(providerCode, cfdaNumber, "", "");
                }catch (S2sCommunicationException e) {
                    LOG.error(e.getMessage(), e);
                    GlobalVariables.getMessageMap().putError(Constants.NO_FIELD, e.getErrorKey(),e.getMessage());
                    return Collections.emptyList();
                }
                if (s2sOpportunity != null) {
                    return s2sOpportunity;
                } else {
                    if (StringUtils.isNotBlank(cfdaNumber)) {
                        GlobalVariables.getMessageMap().putError(Constants.CFDA_NUMBER, KeyConstants.ERROR_IF_CFDANUMBER_IS_INVALID);
                    }
                    if (StringUtils.isNotBlank(opportunityId)) {
                        GlobalVariables.getMessageMap().putError(Constants.OPPORTUNITY_ID,
                                KeyConstants.ERROR_IF_OPPORTUNITY_ID_IS_INVALID);
                    }
                }
                return Collections.emptyList();
            }
            return Collections.emptyList();
        }
        else {
            GlobalVariables.getMessageMap().putError(Constants.NO_FIELD, KeyConstants.ERROR_IF_CFDANUMBER_AND_OPPORTUNITY_ID_IS_NULL);
            return s2sOpportunity;
        }
    }

    public S2sSubmissionService getS2sSubmissionService() {
        if (s2sSubmissionService == null) {
            s2sSubmissionService = KcServiceLocator.getService(S2sSubmissionService.class);
        }

        return s2sSubmissionService;
    }
}
