/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
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
import org.junit.Test;
import org.kuali.coeus.propdev.impl.s2s.nih.NihValidationMapping;
import org.kuali.kra.infrastructure.Constants;

import java.util.ArrayList;
import java.util.List;

public class ProposalDevelopmentGrantsGovAuditRuleTest {


    public static final String ZUKO_SAYS = "My father says Azula was born lucky. He says I was lucky to be born.";
    public static final String BOOMI = "Boomi is a mad genius.";

    @Test
    public void testGetAuditError() {
        // 0 matches
        ProposalDevelopmentGrantsGovAuditRule rule = new ProposalDevelopmentGrantsGovAuditRule();
        ValidationMessage msg = new ValidationMessage();
        msg.setValidationRuleNumber("000.28");
        msg.setValidationMessageId(100);
        msg.setValidationMessageText(ZUKO_SAYS);
        List<NihValidationMapping> matches = new ArrayList<>();
        org.kuali.rice.krad.util.AuditError error = rule.createAuditErrorBasedOnMapping(msg, matches);
        Assert.assertTrue(error.getParams()[0].contains(ZUKO_SAYS));
        Assert.assertTrue(StringUtils.equalsIgnoreCase(error.getErrorKey(), Constants.S2S_PAGE_ID));
        Assert.assertTrue(StringUtils.equalsAnyIgnoreCase(error.getMessageKey(), Constants.GRANTS_GOV_GENERIC_ERROR_KEY));
        Assert.assertTrue(StringUtils.equalsAnyIgnoreCase(error.getLink(), StringUtils.EMPTY));

        // non 0 matches non empty custom message append to original
        msg = new ValidationMessage();
        msg.setValidationRuleNumber("000.28");
        msg.setValidationMessageId(100);
        msg.setValidationMessageText(ZUKO_SAYS);
        matches = new ArrayList<>();
        NihValidationMapping nih = new NihValidationMapping();
        nih.setCustomMessage(BOOMI);
        nih.setAppendToOriginal(true);
        matches.add(nih);
        error = rule.createAuditErrorBasedOnMapping(msg, matches);
        Assert.assertTrue(error.getParams()[0].contains(ZUKO_SAYS));
        Assert.assertTrue(error.getParams()[0].contains(BOOMI));

        // non 0 matches non empty custom message do not append to original
        msg = new ValidationMessage();
        msg.setValidationRuleNumber("000.28");
        msg.setValidationMessageId(100);
        msg.setValidationMessageText(ZUKO_SAYS);
        matches = new ArrayList<>();
        nih = new NihValidationMapping();
        nih.setCustomMessage(BOOMI);
        nih.setAppendToOriginal(false);
        matches.add(nih);
        error = rule.createAuditErrorBasedOnMapping(msg, matches);
        Assert.assertFalse(error.getParams()[0].contains(ZUKO_SAYS));
        Assert.assertTrue(error.getParams()[0].contains(BOOMI));

        // non 0 matches empty custom message
        msg = new ValidationMessage();
        msg.setValidationRuleNumber("000.28");
        msg.setValidationMessageId(100);
        msg.setValidationMessageText(ZUKO_SAYS);
        matches = new ArrayList<>();
        nih = new NihValidationMapping();
        nih.setAppendToOriginal(false);
        matches.add(nih);
        error = rule.createAuditErrorBasedOnMapping(msg, matches);
        Assert.assertTrue(error.getParams()[0].contains(ZUKO_SAYS));
        Assert.assertFalse(error.getParams()[0].contains(BOOMI));
        Assert.assertTrue(error.getErrorKey().contains(Constants.S2S_PAGE_ID));

        // non 0 matches empty custom message non empty page id
        msg = new ValidationMessage();
        msg.setValidationRuleNumber("000.28");
        msg.setValidationMessageId(100);
        msg.setValidationMessageText(ZUKO_SAYS);
        matches = new ArrayList<>();
        nih = new NihValidationMapping();
        nih.setAppendToOriginal(false);
        nih.setPageId(Constants.AWARD_ID);
        matches.add(nih);
        error = rule.createAuditErrorBasedOnMapping(msg, matches);
        Assert.assertTrue(error.getParams()[0].contains(ZUKO_SAYS));
        Assert.assertFalse(error.getParams()[0].contains(BOOMI));
        Assert.assertTrue(error.getErrorKey().contains(Constants.AWARD_ID));
    }

    @Test
    public void testGetAuditLink() {
        ProposalDevelopmentGrantsGovAuditRule rule = new ProposalDevelopmentGrantsGovAuditRule();

        NihValidationMapping nih = new NihValidationMapping();
        nih.setAppendToOriginal(false);
        String link = rule.getAuditLink(nih);
        Assert.assertTrue(StringUtils.equalsAnyIgnoreCase(link, StringUtils.EMPTY));

        nih = new NihValidationMapping();
        nih.setPageId(Constants.S2S_PAGE_ID);
        link = rule.getAuditLink(nih);
        Assert.assertTrue(StringUtils.equalsAnyIgnoreCase(link, Constants.S2S_PAGE_ID));

        nih = new NihValidationMapping();
        nih.setPageId(Constants.S2S_PAGE_ID);
        nih.setSectionId(Constants.S2S_OPPORTUNITY_SECTION_ID);
        link = rule.getAuditLink(nih);
        Assert.assertTrue(StringUtils.equalsAnyIgnoreCase(link, Constants.S2S_PAGE_ID + "." + Constants.S2S_OPPORTUNITY_SECTION_ID));
    }
}
