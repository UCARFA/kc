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
package org.kuali.coeus.propdev.impl.attachment;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.propdev.api.attachment.NarrativeContract;
import org.kuali.coeus.propdev.api.attachment.NarrativeService;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.s2sgen.api.core.InfastructureConstants;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.krad.data.DataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("narrativeService")
public class NarrativeServiceImpl implements NarrativeService {

    public static final int ADDITIONAL_KEYPERSONS_ATTACHMENT = 11;
    public static final int ADDITIONAL_EQUIPMENT_ATTACHMENT = 12;

    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;

    @Autowired
    @Qualifier("legacyNarrativeService")
    private LegacyNarrativeService legacyNarrativeService;

    @Override
    public void deleteAutoGeneratedNarratives(List<? extends NarrativeContract> narratives) {
        deleteIf(narratives, new Predicate() {
            @Override
            public boolean v(NarrativeContract n) {
                return isAutoGeneratedNarrative(n);
            }
        });
    }

    @Override
    public boolean isAutoGeneratedNarrative(NarrativeContract narrative) {
        if (narrative == null) {
            throw new IllegalArgumentException("narrative is null");
        }

        final String typeCode = narrative.getNarrativeType().getCode();

        return typeCode != null
                && (Integer.parseInt(typeCode) == ADDITIONAL_KEYPERSONS_ATTACHMENT ||
                Integer.parseInt(typeCode) == ADDITIONAL_EQUIPMENT_ATTACHMENT);
    }

    @Override
    public void deleteSystemGeneratedNarratives(List<? extends NarrativeContract> narratives) {
        deleteIf(narratives, new Predicate() {
            @Override
            public boolean v(NarrativeContract n) {
                return isSystemGeneratedNarrative(n);
            }
        });
    }

    public void deleteIf(List<? extends NarrativeContract> narratives, Predicate p) {
        if (narratives == null) {
            throw new IllegalArgumentException("narratives is null");
        }

        for (final NarrativeContract narrative : narratives) {
            if (p.v(narrative)) {
                //seems wasteful to call dataObjectService in a loop.
                //On the other hand, it is simple code
                dataObjectService.deleteMatching(Narrative.class,
                        QueryByCriteria.Builder.andAttributes(new HashMap<String, Object>() {{
                            put("developmentProposal.proposalNumber", narrative.getProposalNumber());
                            put("moduleNumber", narrative.getModuleNumber());
                        }}).build());
            }
        }
    }

    private static interface Predicate {
        boolean v(NarrativeContract n);
    }

    @Override
    public boolean isSystemGeneratedNarrative(NarrativeContract narrative) {
        if (narrative == null) {
            throw new IllegalArgumentException("narrative is null");
        }

        return narrative.getNarrativeType().isSystemGenerated();
    }

    @Override
    public NarrativeContract createSystemGeneratedNarrative(String proposalNumber, String narrativeTypeCode, byte[] attachmentData, String attachmentName, String comments) {

        if (StringUtils.isBlank(proposalNumber)) {
            throw new IllegalArgumentException("proposalNumber is blank");
        }

        if (StringUtils.isBlank(narrativeTypeCode)) {
            throw new IllegalArgumentException("narrativeTypeCode is blank");
        }

        if (attachmentData == null) {
            throw new IllegalArgumentException("attachmentData is null");
        }

        if (attachmentData.length == 0) {
            throw new IllegalArgumentException("attachmentData.length is 0");
        }

        if (StringUtils.isBlank(attachmentName)) {
            throw new IllegalArgumentException("attachmentName is blank");
        }

        if (StringUtils.isBlank(comments)) {
            throw new IllegalArgumentException("comments is blank");
        }

        DevelopmentProposal developmentProposal = getDataObjectService().find(DevelopmentProposal.class,proposalNumber);
        
        final NarrativeType narrativeType = new NarrativeType();
        narrativeType.setDescription(comments);
        narrativeType.setSystemGenerated(true);
        narrativeType.setCode(narrativeTypeCode);

        final NarrativeAttachment narrativeAttachment = new NarrativeAttachment();
        narrativeAttachment.setType(InfastructureConstants.CONTENT_TYPE_OCTET_STREAM);
        narrativeAttachment.setData(attachmentData);
        narrativeAttachment.setName(attachmentName);

        final Narrative narrative = new Narrative();
        narrative.setModuleStatusCode("C");
        narrative.setNarrativeStatus(getDataObjectService().find(NarrativeStatus.class, narrative.getModuleStatusCode()));
        narrative.setNarrativeTypeCode(narrativeTypeCode);
        narrative.setComments(comments);
        narrative.setModuleTitle(comments);
        narrative.setName(attachmentName);
        narrative.setNarrativeAttachment(narrativeAttachment);
        narrative.setNarrativeType(narrativeType);
        narrative.setModuleSequenceNumber(getLegacyNarrativeService().getNextModuleSequenceNumber(developmentProposal.getProposalDocument()));
        narrative.setModuleNumber(getLegacyNarrativeService().getNextModuleNumber(developmentProposal.getProposalDocument()));
        narrative.setDevelopmentProposal(developmentProposal);
        developmentProposal.getNarratives().add(narrative);

        return narrative;
    }

    public DataObjectService getDataObjectService() {
        return dataObjectService;
    }

    public void setDataObjectService(DataObjectService dataObjectService) {
        this.dataObjectService = dataObjectService;
    }

    public LegacyNarrativeService getLegacyNarrativeService() {
        return legacyNarrativeService;
    }

    public void setLegacyNarrativeService(LegacyNarrativeService legacyNarrativeService) {
        this.legacyNarrativeService = legacyNarrativeService;
    }
}
