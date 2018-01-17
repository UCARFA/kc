/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.subawardrule.events;

import org.kuali.kra.subaward.bo.SubAwardAttachments;
import org.kuali.kra.subaward.document.SubAwardDocument;
import org.kuali.kra.subaward.subawardrule.AddSubAwardAttachmentRule;
import org.kuali.rice.krad.rules.rule.BusinessRule;

public class AddSubAwardAttachmentEvent extends SubAwardAttachmentEventBase {
    
    public AddSubAwardAttachmentEvent(String description, String errorPathPrefix, SubAwardDocument document, SubAwardAttachments attachment) {
        super(description, errorPathPrefix, document, attachment);
    }
    
   public AddSubAwardAttachmentEvent(String description, String errorPathPrefix, SubAwardDocument document) {
        super(description, errorPathPrefix, document);
        // TODO Auto-generated constructor stub
    }
   /**
    * @see org.kuali.rice.krad.rules.rule.event.DocumentEvent#getRuleInterfaceClass()
    */
   @Override
   public Class getRuleInterfaceClass() {
       return AddSubAwardAttachmentRule.class;
   }

   /**
    * @see org.kuali.rice.krad.rules.rule.event.DocumentEvent#invokeRuleMethod(org.kuali.rice.krad.rules.rule.BusinessRule)
    */
   @Override
   public boolean invokeRuleMethod(BusinessRule rule) {
       return ((AddSubAwardAttachmentRule) rule).processsAddSubawardAttachmentRule(this);
   }

}
