/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.print;

import java.util.Map;

import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.framework.compliance.core.ComplianceConstants;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;

public abstract class BatchCorrespondenceXmlStreamBase extends CorrespondenceXmlStreamBase {
	private RenewalReminderStreamBase renewalReminderStream;
	private CorrespondenceXmlStreamBase correspondenceXmlStream;
    private ParameterService parameterService;
	
    @Override
    public Map<String, XmlObject> generateXmlStream(KcPersistableBusinessObjectBase printableBusinessObject, Map<String, Object> reportParameters) {
        String protocolCorrespTypeCode = (String)reportParameters.get(ComplianceConstants.PROTO_CORRESP_TYPE_CODE);
        String renewalReminderCorrespTypes = getRenewalReminderCorrespondenceTypesParamValues();
        if (renewalReminderCorrespTypes.contains(protocolCorrespTypeCode)) {
        	return getRenewalReminderStream().generateXmlStream(printableBusinessObject, reportParameters);
        }else {
        	return getCorrespondenceXmlStream().generateXmlStream(printableBusinessObject, reportParameters);
        }
    }
	
    public abstract String getRenewalReminderCorrespondenceTypesParamValues();
    
	public RenewalReminderStreamBase getRenewalReminderStream() {
		return renewalReminderStream;
	}
	
	public void setRenewalReminderStream(RenewalReminderStreamBase renewalReminderStream) {
		this.renewalReminderStream = renewalReminderStream;
	}
	
	public CorrespondenceXmlStreamBase getCorrespondenceXmlStream() {
		return correspondenceXmlStream;
	}

	public void setCorrespondenceXmlStream(CorrespondenceXmlStreamBase correspondenceXmlStream) {
		this.correspondenceXmlStream = correspondenceXmlStream;
	}

	public ParameterService getParameterService() {
		return parameterService;
	}

	public void setParameterService(ParameterService parameterService) {
		this.parameterService = parameterService;
	}

}
