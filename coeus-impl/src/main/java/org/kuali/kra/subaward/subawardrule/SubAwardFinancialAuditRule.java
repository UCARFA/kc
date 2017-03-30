/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.kra.subaward.subawardrule;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.subaward.bo.SubAwardAmountInfo;
import org.kuali.kra.subaward.document.SubAwardDocument;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.util.AuditCluster;
import org.kuali.rice.krad.util.AuditError;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.DocumentAuditRule;

import java.util.ArrayList;
import java.util.List;

/**
 * This class processes audit rules (warnings)
 *  for the Report Information related
 * data of the SubAwardDocument.
 */
public class SubAwardFinancialAuditRule extends
        KcTransactionalDocumentRuleBase implements DocumentAuditRule {

    private static final String SUBAWARD_FINANCIAL_AUDIT_WARNINGS
    = "subawardFinancialdAuditWarnings";
    private List<AuditError> auditWarnings;
    private ParameterService parameterService;


    /**
     *
     * Constructs a SubAwardFinancialAuditRule.java.
     *  Added so unit test would not
     * need to call processRunAuditBusinessRules
     * and therefore declare a document.
     */
    public SubAwardFinancialAuditRule() {
        auditWarnings = new ArrayList<AuditError>();
    }


    public boolean processRunAuditBusinessRules(Document document) {
        boolean valid = true;
        auditWarnings = new ArrayList<>();

        valid &= checkForObligatedAmountZero(document);
        valid &= checkForAnticipatedAmountZero(document);

        reportAndCreateFinancialAuditCluster();

        return valid;

    }

    @SuppressWarnings("unchecked")
    protected void reportAndCreateFinancialAuditCluster() {
        if (auditWarnings.size() > 0) {
            AuditCluster existingErrors = GlobalVariables.getAuditErrorMap().get(SUBAWARD_FINANCIAL_AUDIT_WARNINGS);
            if (existingErrors == null) {
                GlobalVariables.getAuditErrorMap().put(SUBAWARD_FINANCIAL_AUDIT_WARNINGS, new AuditCluster(Constants.SUBAWARD_FINANCIAL_PANEL_NAME,
                                                        auditWarnings, Constants.AUDIT_WARNINGS));
            } else {
                existingErrors.getAuditErrorList().addAll(auditWarnings);
            }
        }
    }

    protected boolean checkForObligatedAmountZero(Document document) {
        SubAwardDocument subAwardDocument = (SubAwardDocument) document;
        ScaleTwoDecimal obligatedAmount = ScaleTwoDecimal.ZERO;
        boolean isCostSplitEnabled = isCostSplitEnabled();
        for (SubAwardAmountInfo subAwardAmountInfo : subAwardDocument.getSubAward().getAllSubAwardAmountInfos()) {
            if (!isCostSplitEnabled) {
                obligatedAmount = subAwardAmountInfo.getObligatedChange() != null ? obligatedAmount.add(subAwardAmountInfo.getObligatedChange()) : obligatedAmount;
            } else {
                obligatedAmount = subAwardAmountInfo.getObligatedChangeDirect() != null ? obligatedAmount.add(subAwardAmountInfo.getObligatedChangeDirect()) : obligatedAmount;
                obligatedAmount = subAwardAmountInfo.getObligatedChangeIndirect() != null ? obligatedAmount.add(subAwardAmountInfo.getObligatedChangeIndirect()) : obligatedAmount;
            }
        }
        if (obligatedAmount.isZero()) {
            subAwardDocument.getSubAward().setDefaultOpen(false);
            auditWarnings.add(new AuditError(Constants.SUBAWARD_FINANCIAL_OBLIGATED_AMOUNT, KeyConstants.ERROR_AMOUNT_INFO_OBLIGATED_AMOUNT_ZERO,
                                                Constants.MAPPING_FINANCIAL_PAGE + "." + Constants.SUBAWARD_FINANCIAL_PANEL));
            return false;
        }

        return true;

    }

    public boolean isCostSplitEnabled() {
        return getParameterService().getParameterValueAsBoolean(Constants.MODULE_NAMESPACE_SUBAWARD, Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE, Constants.ENABLE_SUBAWARD_DC_IDC);
    }

    protected ParameterService getParameterService() {
        if (parameterService == null) {
            parameterService = KcServiceLocator.getService(ParameterService.class);
        }
        return parameterService;
    }

    protected boolean checkForAnticipatedAmountZero(Document document) {
        ScaleTwoDecimal anticipatedAmount = ScaleTwoDecimal.ZERO;
        SubAwardDocument subAwardDocument = (SubAwardDocument) document;
        boolean isCostSplitEnabled = isCostSplitEnabled();
        for (SubAwardAmountInfo subAwardAmountInfo : subAwardDocument.getSubAward().getAllSubAwardAmountInfos()) {
            if (!isCostSplitEnabled) {
                anticipatedAmount = subAwardAmountInfo.getAnticipatedChange() != null ? anticipatedAmount.add(subAwardAmountInfo.getAnticipatedChange()) : anticipatedAmount;
            } else {
                anticipatedAmount = subAwardAmountInfo.getAnticipatedChangeDirect() != null ? anticipatedAmount.add(subAwardAmountInfo.getAnticipatedChangeDirect()) : anticipatedAmount;
                anticipatedAmount = subAwardAmountInfo.getAnticipatedChangeIndirect() != null ? anticipatedAmount.add(subAwardAmountInfo.getAnticipatedChangeIndirect()) : anticipatedAmount;
            }
        }
        if (anticipatedAmount.isZero()) {
            subAwardDocument.getSubAward().setDefaultOpen(false);
            auditWarnings.add(new AuditError(Constants.SUBAWARD_FINANCIAL_ANTICIPATED_AMOUNT, KeyConstants.ERROR_AMOUNT_INFO_ANTICIPATED_AMOUNT_ZERO,
                                                Constants.MAPPING_FINANCIAL_PAGE + "." + Constants.SUBAWARD_FINANCIAL_PANEL));
            return false;
        }

        return true;
    }
}
