/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import java.util.List;

import org.kuali.coeus.common.framework.person.PropAwardPersonRoleValuesFinder;
import org.kuali.kra.award.AwardForm;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kns.util.KNSGlobalVariables;
import org.kuali.rice.krad.uif.field.InputField;
import org.kuali.rice.krad.uif.view.ViewModel;

public class AwardPersonProjectRolesValuesFinder extends PropAwardPersonRoleValuesFinder {

	@Override
	protected String getSponsorCodeFromModel(ViewModel model) {
		return ((AwardForm) model).getAwardDocument().getAward().getSponsorCode();
	}
	
    @Override
    public List<KeyValue> getKeyValues(){
    	AwardForm form = (AwardForm) KNSGlobalVariables.getKualiForm();
		return getKeyValues(form.getAwardDocument().getAward().getSponsorCode());
    }

    @Override
    protected boolean piAlreadyExists(ViewModel model, InputField field) {
        return false;
    }
	
}
