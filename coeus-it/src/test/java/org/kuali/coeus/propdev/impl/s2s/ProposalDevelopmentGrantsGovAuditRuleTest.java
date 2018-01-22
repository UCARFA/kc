/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.propdev.impl.s2s;

import gov.nih.era.svs.types.ValidationMessage;
import org.junit.Assert;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.propdev.impl.s2s.nih.NihValidationMapping;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.util.ArrayList;
import java.util.List;

public class ProposalDevelopmentGrantsGovAuditRuleTest extends KcIntegrationTestBase {

    public static final String WARNINGS_KEY = "pageId.sectionId.Warnings.s2s";
    public static final String ERROR_KEY = "pageId.sectionId.Error.s2s";
    public static final String DEFAULT_WARNINGS_KEY = "S2S Opportunity Search.Opportunity.Warnings.s2s";
    ProposalDevelopmentGrantsGovAuditRule rule;
    public static final String ZUKO_SAYS = "My father says Azula was born lucky. He says I was lucky to be born.";
    public static final String BOOMI = "Boomi is a mad genius.";
    private static final String ERROR_CODE = "E";

    @Before
    public void setUp() {

    }

    @Test
    public void convertToAuditErrorsTestEmptyCustomMessage() {
        rule = new ProposalDevelopmentGrantsGovAuditRule() {
            @Override
            protected List<NihValidationMapping> getNihValidationMappings(ValidationMessage msg) {
                List<NihValidationMapping> mappings = new ArrayList<>();
                NihValidationMapping mapping1 = new NihValidationMapping();
                mapping1.setRuleNumber("000.28");
                mapping1.setSectionId("sectionId");
                mapping1.setPageId("pageId");
                mapping1.setCustomMessage("");
                mapping1.setAppendToOriginal(Boolean.TRUE);
                mappings.add(mapping1);

                return mappings;

            }
        };

        ValidationMessage msg = new ValidationMessage();
        msg.setValidationRuleNumber("000.28");
        msg.setValidationMessageId(100);
        msg.setValidationMessageText(ZUKO_SAYS);
        msg.setValidationSeverityCode(ERROR_CODE);
        msg.setFormName("SF424");
        msg.setValidationMessageId(1);

        List<ValidationMessage> errors = new ArrayList<>();
        errors.add(msg);

        List<ValidationMessage> warnings = new ArrayList<>();
        rule.convertToAuditErrors(errors, warnings);
        Assert.assertFalse(rule.getGlobalVariableService().getAuditErrorMap().isEmpty());
        Assert.assertTrue(rule.getGlobalVariableService().getAuditErrorMap().get(WARNINGS_KEY) == null);
        Assert.assertTrue(rule.getGlobalVariableService().getAuditErrorMap().get(ERROR_KEY).getSize() == 1);

        Assert.assertTrue(StringUtils.equalsIgnoreCase(((org.kuali.rice.krad.util.AuditError) rule.getGlobalVariableService().getAuditErrorMap().
                get(ERROR_KEY).getAuditErrorList().get(0)).getParams()[0], "SF424 - 000.28 - 1 - My father says Azula was born lucky. He says I was lucky to be born."));
        rule.getGlobalVariableService().getAuditErrorMap().clear();
    }

    @Test
    public void convertToAuditErrorsTestWithCustomMessageAppend() {
        rule = new ProposalDevelopmentGrantsGovAuditRule() {
            @Override
            protected List<NihValidationMapping> getNihValidationMappings(ValidationMessage msg) {
                List<NihValidationMapping> mappings = new ArrayList<>();
                NihValidationMapping mapping1 = new NihValidationMapping();
                mapping1.setRuleNumber("000.28");
                mapping1.setSectionId("sectionId");
                mapping1.setPageId("pageId");
                mapping1.setCustomMessage(BOOMI);
                mapping1.setAppendToOriginal(Boolean.TRUE);
                mappings.add(mapping1);
                return mappings;

            }
        };

        ValidationMessage msg = new ValidationMessage();
        msg.setValidationRuleNumber("000.28");
        msg.setValidationMessageId(100);
        msg.setValidationMessageText(ZUKO_SAYS);
        msg.setValidationSeverityCode(ERROR_CODE);
        msg.setFormName("SF424");
        msg.setValidationMessageId(1);

        List<ValidationMessage> errors = new ArrayList<>();
        errors.add(msg);

        List<ValidationMessage> warnings = new ArrayList<>();
        rule.convertToAuditErrors(errors, warnings);
        Assert.assertFalse(rule.getGlobalVariableService().getAuditErrorMap().isEmpty());
        Assert.assertTrue(rule.getGlobalVariableService().getAuditErrorMap().get(WARNINGS_KEY) == null);
        Assert.assertTrue(rule.getGlobalVariableService().getAuditErrorMap().get(ERROR_KEY).getSize() == 1);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(((org.kuali.rice.krad.util.AuditError)rule.getGlobalVariableService().getAuditErrorMap().
                get(ERROR_KEY).getAuditErrorList().get(0)).getParams()[0], "SF424 - 000.28 - 1 - " + ZUKO_SAYS + StringUtils.SPACE + BOOMI));
        rule.getGlobalVariableService().getAuditErrorMap().clear();
    }

    @Test
    public void convertToAuditErrorsTestWithCustomMessageDoNotAppend() {
        rule = new ProposalDevelopmentGrantsGovAuditRule() {
            @Override
            protected List<NihValidationMapping> getNihValidationMappings(ValidationMessage msg) {
                List<NihValidationMapping> mappings = new ArrayList<>();
                NihValidationMapping mapping1 = new NihValidationMapping();
                mapping1.setRuleNumber("000.1.1.0");
                mapping1.setSectionId("sectionId");
                mapping1.setPageId("pageId");
                mapping1.setCustomMessage(BOOMI);
                mapping1.setAppendToOriginal(Boolean.FALSE);
                mappings.add(mapping1);
                return mappings;

            }
        };

        List<ValidationMessage> errors = new ArrayList<>();

        ValidationMessage warn1 = new ValidationMessage();
        warn1.setValidationRuleNumber("000.1.1.0");
        warn1.setValidationMessageId(300);
        warn1.setValidationMessageText(ZUKO_SAYS);
        warn1.setValidationSeverityCode("W");
        warn1.setValidationMessageId(3);
        warn1.setFormName("SF424");

        List<ValidationMessage> warnings = new ArrayList<>();
        warnings.add(warn1);
        rule.convertToAuditErrors(errors, warnings);
        Assert.assertFalse(rule.getGlobalVariableService().getAuditErrorMap().isEmpty());
        Assert.assertTrue(rule.getGlobalVariableService().getAuditErrorMap().get(WARNINGS_KEY).getSize() == 1);
        Assert.assertTrue(rule.getGlobalVariableService().getAuditErrorMap().get(ERROR_KEY) == null);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(((org.kuali.rice.krad.util.AuditError)rule.getGlobalVariableService().getAuditErrorMap().
                get(WARNINGS_KEY).getAuditErrorList().get(0)).getParams()[0], "SF424 - 000.1.1.0 - 3 - " + BOOMI));
        Assert.assertTrue(StringUtils.equalsIgnoreCase(((org.kuali.rice.krad.util.AuditError)rule.getGlobalVariableService().getAuditErrorMap().
                get(WARNINGS_KEY).getAuditErrorList().get(0)).getLink(), "pageId.sectionId"));
        rule.getGlobalVariableService().getAuditErrorMap().clear();
    }

    @Test
    public void convertToAuditErrorsTestWithCustomMessageDoNotAppendUpgradeToError() {
        rule = new ProposalDevelopmentGrantsGovAuditRule() {
            @Override
            protected List<NihValidationMapping> getNihValidationMappings(ValidationMessage msg) {
                List<NihValidationMapping> mappings = new ArrayList<>();
                NihValidationMapping mapping1 = new NihValidationMapping();
                mapping1.setRuleNumber("000.1.1.0");
                mapping1.setSectionId("sectionId");
                mapping1.setPageId("pageId");
                mapping1.setCustomMessage(BOOMI);
                mapping1.setAppendToOriginal(Boolean.FALSE);
                mapping1.setForceError(Boolean.TRUE);
                mappings.add(mapping1);
                return mappings;

            }
        };

        List<ValidationMessage> errors = new ArrayList<>();

        ValidationMessage warn1 = new ValidationMessage();
        warn1.setValidationRuleNumber("000.1.1.0");
        warn1.setValidationMessageId(300);
        warn1.setValidationMessageText(ZUKO_SAYS);
        warn1.setValidationSeverityCode("W");
        warn1.setValidationMessageId(3);
        warn1.setFormName("SF424");

        List<ValidationMessage> warnings = new ArrayList<>();
        warnings.add(warn1);
        rule.convertToAuditErrors(errors, warnings);
        Assert.assertFalse(rule.getGlobalVariableService().getAuditErrorMap().isEmpty());
        Assert.assertTrue(rule.getGlobalVariableService().getAuditErrorMap().get(ERROR_KEY).getSize() == 1);
        Assert.assertTrue(rule.getGlobalVariableService().getAuditErrorMap().get(WARNINGS_KEY) == null);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(((org.kuali.rice.krad.util.AuditError)rule.getGlobalVariableService().getAuditErrorMap().
                get(ERROR_KEY).getAuditErrorList().get(0)).getParams()[0], "SF424 - 000.1.1.0 - 3 - " + BOOMI));
        Assert.assertTrue(StringUtils.equalsIgnoreCase(((org.kuali.rice.krad.util.AuditError)rule.getGlobalVariableService().getAuditErrorMap().
                get(ERROR_KEY).getAuditErrorList().get(0)).getLink(), "pageId.sectionId"));
        rule.getGlobalVariableService().getAuditErrorMap().clear();
    }

    @Test
    public void convertToAuditErrorsTestWithCustomMessageDoNotAppendEmptyPageId() {
        rule = new ProposalDevelopmentGrantsGovAuditRule() {
            @Override
            protected List<NihValidationMapping> getNihValidationMappings(ValidationMessage msg) {
                List<NihValidationMapping> mappings = new ArrayList<>();
                NihValidationMapping mapping1 = new NihValidationMapping();
                mapping1.setRuleNumber("000.1.1.0");
                mapping1.setSectionId("sectionId");
                mapping1.setPageId("");
                mapping1.setCustomMessage(BOOMI);
                mapping1.setAppendToOriginal(Boolean.FALSE);
                mappings.add(mapping1);
                return mappings;

            }
        };

        List<ValidationMessage> errors = new ArrayList<>();

        ValidationMessage warn1 = new ValidationMessage();
        warn1.setValidationRuleNumber("000.1.1.0");
        warn1.setValidationMessageId(300);
        warn1.setValidationMessageText(ZUKO_SAYS);
        warn1.setValidationSeverityCode("W");
        warn1.setValidationMessageId(3);
        warn1.setFormName("SF424");

        List<ValidationMessage> warnings = new ArrayList<>();
        warnings.add(warn1);
        rule.convertToAuditErrors(errors, warnings);
        Assert.assertFalse(rule.getGlobalVariableService().getAuditErrorMap().isEmpty());
        Assert.assertTrue(rule.getGlobalVariableService().getAuditErrorMap().get(DEFAULT_WARNINGS_KEY).getSize() == 1);
        Assert.assertTrue(rule.getGlobalVariableService().getAuditErrorMap().get(ERROR_KEY) == null);
        Assert.assertTrue(StringUtils.equalsIgnoreCase(((org.kuali.rice.krad.util.AuditError)rule.getGlobalVariableService().getAuditErrorMap().
                get(DEFAULT_WARNINGS_KEY).getAuditErrorList().get(0)).getParams()[0], "SF424 - 000.1.1.0 - 3 - " + BOOMI));
        Assert.assertTrue(StringUtils.equalsIgnoreCase(((org.kuali.rice.krad.util.AuditError)rule.getGlobalVariableService().getAuditErrorMap().
                get(DEFAULT_WARNINGS_KEY).getAuditErrorList().get(0)).getLink(), StringUtils.EMPTY));
        rule.getGlobalVariableService().getAuditErrorMap().clear();
    }

}
