/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.personmasschange.web.struts.form;

import org.kuali.coeus.sys.framework.model.KcTransactionalDocumentFormBase;
import org.kuali.kra.personmasschange.document.PersonMassChangeDocument;
import org.kuali.rice.krad.util.KRADConstants;

import java.util.Map;

public class PersonMassChangeForm extends KcTransactionalDocumentFormBase {

    private static final long serialVersionUID = 6324968980895876372L;
    
    private PersonMassChangeHomeHelper personMassChangeHomeHelper;
    private PersonMassChangeViewHelper personMassChangeViewHelper;
    
    public PersonMassChangeForm() {
        initialize();
    }
    
    public void initialize() {
        setPersonMassChangeHomeHelper(new PersonMassChangeHomeHelper(this));
        setPersonMassChangeViewHelper(new PersonMassChangeViewHelper(this));
    }

    public PersonMassChangeHomeHelper getPersonMassChangeHomeHelper() {
        return personMassChangeHomeHelper;
    }

    public void setPersonMassChangeHomeHelper(PersonMassChangeHomeHelper personMassChangeHomeHelper) {
        this.personMassChangeHomeHelper = personMassChangeHomeHelper;
    }

    public PersonMassChangeViewHelper getPersonMassChangeViewHelper() {
        return personMassChangeViewHelper;
    }

    public void setPersonMassChangeViewHelper(PersonMassChangeViewHelper personMassChangeViewHelper) {
        this.personMassChangeViewHelper = personMassChangeViewHelper;
    }

    @Override
    protected String getDefaultDocumentTypeName() {
        return "PersonMassChangeDocument";
    }
    
    @Override
    protected String getLockRegion() {
        return "PERSONMASSCHANGE";
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected void setSaveDocumentControl(Map editMode) {
        getDocumentActions().put(KRADConstants.KUALI_ACTION_CAN_SAVE, KRADConstants.KUALI_DEFAULT_TRUE_VALUE);
    }
    
    public PersonMassChangeDocument getPersonMassChangeDocument() {
        return (PersonMassChangeDocument) super.getDocument();
    }

}
