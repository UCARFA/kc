/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionQualifierTypeBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionTypeBase;
import org.kuali.kra.protocol.actions.submit.ValidProtoSubTypeQualMaintenanceDocumentRuleBase;


 /**
  * 
  * This class is the maintenance document rule for valid submission/type qualifier table.
  */
 public class ValidProtoSubTypeQualMaintenanceDocumentRule extends ValidProtoSubTypeQualMaintenanceDocumentRuleBase {

         @Override
         protected Class<? extends ProtocolSubmissionTypeBase> getProtocolSubmissionTypeBOClassHook() {
             return ProtocolSubmissionType.class;
         }

         @Override
         protected Class<? extends ProtocolSubmissionQualifierTypeBase> getProtocolSubmissionQualifierTypeBOClassHook() {
             return ProtocolSubmissionQualifierType.class;
         }
         
         @Override
         protected  Class<? extends ValidProtoSubTypeQual> getValidProtoSubTypeQualBOClassHook() {
             return org.kuali.kra.irb.actions.submit.ValidProtoSubTypeQual.class;
         }

} 
 
