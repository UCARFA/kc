/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.krms;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import java.util.List;


public class KcKrmsTermFunction extends KcPersistableBusinessObjectBase {
    

    private static final long serialVersionUID = 229744717657419313L;
    private Long kcKrmsTermFunctionId;
    private String krmsTermName;
    private String description;
    private String returnType;
    private String functionType;
    private List<KcKrmsTermFunctionParam> termFunctionParams;
    public Long getKcKrmsTermFunctionId() {
        return kcKrmsTermFunctionId;
    }
    public void setKcKrmsTermFunctionId(Long kcKrmsTermFunctionId) {
        this.kcKrmsTermFunctionId = kcKrmsTermFunctionId;
    }
    public String getKrmsTermName() {
        return krmsTermName;
    }
    public void setKrmsTermSpecId(String krmsTermName) {
        this.krmsTermName = krmsTermName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getReturnType() {
        return returnType;
    }
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
    public String getFunctionType() {
        return functionType;
    }
    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }
    public List<KcKrmsTermFunctionParam> getTermFunctionParams() {
        return termFunctionParams;
    }
    public void setTermFunctionParams(List<KcKrmsTermFunctionParam> termFunctionParams) {
        this.termFunctionParams = termFunctionParams;
    }
    
}
