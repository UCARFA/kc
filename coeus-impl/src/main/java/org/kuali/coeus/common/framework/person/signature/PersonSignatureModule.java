/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.signature;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class PersonSignatureModule extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = -3728654769919846123L;

    private Long personSignatureModuleId;
    private Long personSignatureId;
    private String moduleCode;
    private boolean defaultSignature;
    private boolean signatureActive;
    private PersonSignature personSignature;
    private CoeusModule coeusModule;
    
    public Long getPersonSignatureModuleId() {
        return personSignatureModuleId;
    }
    public void setPersonSignatureModuleId(Long personSignatureModuleId) {
        this.personSignatureModuleId = personSignatureModuleId;
    }
    public Long getPersonSignatureId() {
        return personSignatureId;
    }
    public void setPersonSignatureId(Long personSignatureId) {
        this.personSignatureId = personSignatureId;
    }
    public String getModuleCode() {
        return moduleCode;
    }
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }
    public boolean isDefaultSignature() {
        return defaultSignature;
    }
    public void setDefaultSignature(boolean defaultSignature) {
        this.defaultSignature = defaultSignature;
    }
    public boolean isSignatureActive() {
        return signatureActive;
    }
    public void setSignatureActive(boolean signatureActive) {
        this.signatureActive = signatureActive;
    }
    public PersonSignature getPersonSignature() {
        return personSignature;
    }
    public void setPersonSignature(PersonSignature personSignature) {
        this.personSignature = personSignature;
    }
    public CoeusModule getCoeusModule() {
        return coeusModule;
    }
    public void setCoeusModule(CoeusModule coeusModule) {
        this.coeusModule = coeusModule;
    }
    
}
