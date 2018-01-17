/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.krms;

import org.kuali.coeus.common.framework.krms.KrmsRulesContext;

/**
 * 
 * This interface is for the bo class of the rulecontext class has.
 * for example : Protocol, developmentproposal
 */
public interface KcKrmsContextBo {
    /**
     * 
     * This method to get the RuleContext, which is this bo's document class, of this bo class.
     * @return
     */
    KrmsRulesContext getKrmsRulesContext();
}
