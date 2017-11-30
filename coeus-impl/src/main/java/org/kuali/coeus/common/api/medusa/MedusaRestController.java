/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2017 Kuali, Inc.
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
package org.kuali.coeus.common.api.medusa;

import com.codiform.moo.curry.Translate;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.api.medusa.dto.*;
import org.kuali.coeus.common.framework.medusa.MedusaNode;
import org.kuali.coeus.common.framework.medusa.MedusaService;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardAmountInfo;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.negotiations.bo.Negotiation;
import org.kuali.kra.subaward.bo.SubAward;
import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
public class MedusaRestController {

    public static final String MODULE_ID_PARAM = "moduleId";
    public static final String MODULE_PARAM = "module";
    public static final String PREFERRED_MODULE_PARAM = "preferredModule";

    @Autowired
    @Qualifier("kualiConfigurationService")
    private ConfigurationService configurationService;

    @Autowired
    @Lazy
    @Qualifier("medusaService")
    private MedusaService medusaService;

    @Autowired
    @Qualifier("jspViewResolver")
    private ViewResolver jspViewResolver;

    @GetMapping("/api/v1/medusa/tree")
    @ResponseBody
    public List<MedusaChildDto> getMedusaTree(@RequestParam(MODULE_PARAM) String module, @RequestParam(MODULE_ID_PARAM) Long docNumber,
                                              @RequestParam(value = PREFERRED_MODULE_PARAM, required = false) String preferredModule) {
        List<MedusaNode> branches = Constants.AWARD_MODULE.equals(preferredModule) ? medusaService.getMedusaByAward(module, docNumber) : medusaService.getMedusaByProposal(module, docNumber);
        return branches.stream().map(this::translateMedusaBranch).collect(Collectors.toList());
    }

    @GetMapping("/api/v1/medusa/node")
    @ResponseBody
    public Object getMedusaNode(@RequestParam(MODULE_PARAM) String module, @RequestParam(MODULE_ID_PARAM) Long docNumber) {
        MedusaNode node = medusaService.getMedusaNode(module, docNumber);
        return translateMedusaBoToDto(node);
    }

    private MedusaChildDto translateMedusaBranch(MedusaNode node) {
        MedusaChildDto translatedNode = translateMedusaNode(node);
        if (CollectionUtils.isNotEmpty(node.getChildNodes())) {
            node.getChildNodes().forEach(childNode -> translatedNode.addChild(translateMedusaBranch((MedusaNode) childNode)));
        }
        return translatedNode;
    }

    private MedusaChildDto translateMedusaNode(MedusaNode node) {
        MedusaChildDto translatedNode = new MedusaChildDto();
        translatedNode.setModuleCode(node.getType());
        if (StringUtils.equals(node.getType(), Constants.AWARD_MODULE)) {
            Award award = (Award) node.getBo();
            translatedNode.setModuleId(award.getAwardId());
        } else if (StringUtils.equals(node.getType(), Constants.INSTITUTIONAL_PROPOSAL_MODULE)) {
            InstitutionalProposal ip = (InstitutionalProposal) node.getBo();
            translatedNode.setModuleId(ip.getProposalId());
        } else if (StringUtils.equals(node.getType(), Constants.DEVELOPMENT_PROPOSAL_MODULE)) {
            DevelopmentProposal proposal = (DevelopmentProposal) node.getBo();
            translatedNode.setModuleId(Long.valueOf(proposal.getProposalNumber()));
        } else if (StringUtils.equals(node.getType(), Constants.NEGOTIATION_MODULE)) {
            Negotiation negotiation = (Negotiation) node.getBo();
            translatedNode.setModuleId(negotiation.getNegotiationId());
        } else if (StringUtils.equals(node.getType(), Constants.SUBAWARD_MODULE)) {
            SubAward subAward = (SubAward) node.getBo();
            translatedNode.setModuleId(Long.valueOf(subAward.getSubAwardCode()));
        } else if (StringUtils.equals(node.getType(), Constants.IRB_MODULE)) {
            Protocol protocol = (Protocol) node.getBo();
            translatedNode.setModuleId(protocol.getProtocolId());
        } else if (StringUtils.equals(node.getType(), Constants.IACUC_MODULE)) {
            IacucProtocol protocol = (IacucProtocol) node.getBo();
            translatedNode.setModuleId(protocol.getProtocolId());
        }
        translatedNode.setDescription(node.getNodeLabel());
        translatedNode.setDetailedDescription(node.getDocumentDescription());
        return translatedNode;
    }

    private Object translateMedusaBoToDto(MedusaNode node) {
        if (node == null || node.getBo() == null || node.getType() == null) {
            return null;
        }
        if (StringUtils.equals(node.getType(), Constants.AWARD_MODULE)) {
            MedusaAwardDto awardDto = Translate.to(MedusaAwardDto.class).from(node.getBo());
            if (node.getExtraInfo() != null && node.getExtraInfo() instanceof AwardAmountInfo) {
                awardDto.setAwardAmountInfo(Translate.to(MedusaAwardAmountDto.class).from(node.getExtraInfo()));
            }
            return awardDto;
        } else if (StringUtils.equals(node.getType(), Constants.INSTITUTIONAL_PROPOSAL_MODULE)) {
            return Translate.to(MedusaInstitutionalProposalDto.class).from(node.getBo());
        } else if (StringUtils.equals(node.getType(), Constants.DEVELOPMENT_PROPOSAL_MODULE)) {
            return Translate.to(MedusaDevelopmentProposalDto.class).from(node.getBo());
        } else if (StringUtils.equals(node.getType(), Constants.NEGOTIATION_MODULE)) {
            return Translate.to(MedusaNegotiationDto.class).from(node.getBo());
        } else if (StringUtils.equals(node.getType(), Constants.SUBAWARD_MODULE)) {
            return Translate.to(MedusaSubAwardDto.class).from(node.getBo());
        } else if (StringUtils.equals(node.getType(), Constants.IRB_MODULE)) {
            return Translate.to(MedusaIrbProtocolDto.class).from(node.getBo());
        } else if (StringUtils.equals(node.getType(), Constants.IACUC_MODULE)) {
            return Translate.to(MedusaIacucProtocolDto.class).from(node.getBo());
        }
        return null;
    }

    @GetMapping("/medusa")
    public ModelAndView getMedusaPage(@RequestParam(MODULE_PARAM) String module, @RequestParam(MODULE_ID_PARAM) Long moduleId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("appContext", configurationService.getPropertyValueAsString(Constants.APP_CONTEXT_NAME));
        modelAndView.addObject("frontendTimestamp", configurationService.getPropertyValueAsString(Constants.FRONTEND_TIMESTAMP));
        modelAndView.addObject("riceVersion", configurationService.getPropertyValueAsString(Constants.RICE_VERSION));
        modelAndView.addObject("module", module);
        modelAndView.addObject("moduleId", moduleId);
        modelAndView.setView(jspViewResolver.resolveViewName("medusa/medusaReact", Locale.US));
        return modelAndView;
    }

}
