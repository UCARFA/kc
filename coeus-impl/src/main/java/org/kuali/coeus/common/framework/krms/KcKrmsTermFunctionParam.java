/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.krms;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class KcKrmsTermFunctionParam extends KcPersistableBusinessObjectBase implements Comparable<KcKrmsTermFunctionParam> {


    private static final long serialVersionUID = 5500796091484340802L;
    private Long kcKrmsTermFunctionParamId;
    private Long kcKrmsTermFunctionId;
    private String paramName;
    private String paramType;
    private Integer paramOrder;

    public Long getKcKrmsTermFunctionParamId() {
        return kcKrmsTermFunctionParamId;
    }

    public void setKcKrmsTermFunctionParamId(Long kcKrmsTermFunctionParamId) {
        this.kcKrmsTermFunctionParamId = kcKrmsTermFunctionParamId;
    }

    public Long getKcKrmsTermFunctionId() {
        return kcKrmsTermFunctionId;
    }

    public void setKcKrmsTermFunctionId(Long kcKrmsTermFunctionId) {
        this.kcKrmsTermFunctionId = kcKrmsTermFunctionId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public Integer getParamOrder() {
        return paramOrder;
    }

    public void setParamOrder(Integer paramOrder) {
        this.paramOrder = paramOrder;
    }

    @Override
    public int compareTo(KcKrmsTermFunctionParam termToCompare) {
        return getParamOrder().compareTo(termToCompare.getParamOrder());
    }
}
