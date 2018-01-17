/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.correspondence;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTypeBase;

public class ProtocolCorrespondenceType extends ProtocolCorrespondenceTypeBase {


    private static final long serialVersionUID = 581785796901521423L;

    public static final String APPROVAL_LETTER = "1";
    public static final String WITHDRAWAL_NOTICE = "16";
    public static final String GRANT_EXEMPTION_NOTICE = "17";
    public static final String CLOSURE_NOTICE = "26";
    public static final String ABANDON_NOTICE = "28";
    public static final String NOTICE_OF_DEFERRAL = "3";
    public static final String SRR_LETTER = "4";
    public static final String SMR_LETTER = "6";
    public static final String EXPEDITED_APPROVAL_LETTER = "5";
    public static final String SUSPENSION_NOTICE = "7";
    public static final String TERMINATION_NOTICE = "8";
    
    @SuppressWarnings("unused")
    private transient CorrespondenceTypeModuleIdConstants module;

    /**
     * 
     * This method returns the module enum specified by this {@code ProtocolCorrespondenceType}.
     * @return Matching {@code CorrespondenceTypeModuleIdConstants} specified by the moduleId of this
     * correspondence type, or CorrespondenceTypeModuleIdConstants.SYSTEM if no matching co
     */
    public CorrespondenceTypeModuleIdConstants getModule() {
        String moduleId = getModuleId();
        for(CorrespondenceTypeModuleIdConstants module : CorrespondenceTypeModuleIdConstants.values()) {
            if(StringUtils.equals(module.getCode(),moduleId)) {
                return module;
            }
        }
        return CorrespondenceTypeModuleIdConstants.SYSTEM;
    }

    public void setModule(CorrespondenceTypeModuleIdConstants module) {
        this.module = module;
    }
}
