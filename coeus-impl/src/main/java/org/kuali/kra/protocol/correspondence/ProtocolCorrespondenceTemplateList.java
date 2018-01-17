/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.correspondence;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is a work around to access values of a sub list with EL.
 * e.g. the EL "replaceCorrespondenceTemplates[${status.index}].[${status2.index}].templateFile
 * does not work to access List&lt;List&lt;ProtocolCorrespondenceTemplateBase&gt;&gt; replaceCorrespondenceTemplates.
 * To solve this we added this intermediate class and use the following EL statement:
 * "replaceCorrespondenceTemplates[${status.index}].list[${status2.index}].templateFile"
 */
public class ProtocolCorrespondenceTemplateList {

	private List<ProtocolCorrespondenceTemplateBase> list;
	
	public ProtocolCorrespondenceTemplateList() {
		list = new ArrayList<ProtocolCorrespondenceTemplateBase>();
	}

	public List<ProtocolCorrespondenceTemplateBase> getList() {
		return list;
	}

	public void setList(List<ProtocolCorrespondenceTemplateBase> list) {
		this.list = list;
	}
}
