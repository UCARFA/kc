/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.personmasschange.service.impl;

import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.negotiations.bo.Negotiation;
import org.kuali.kra.personmasschange.bo.PersonMassChange;
import org.kuali.kra.personmasschange.service.NegotiationPersonMassChangeService;
import org.kuali.rice.krad.bo.PersistableBusinessObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the service for performing a Person Mass Change on Negotiations.
 * 
 * Person roles that might be replaced are: Negotiator.
 */
@Component("negotiationPersonMassChangeService")
public class NegotiationPersonMassChangeServiceImpl extends MassPersonChangeServiceBase implements NegotiationPersonMassChangeService {
    
    private static final String NEGOTIATION = "negotiation";
    private static final String NEGOTIATION_WARNINGS = "negotiationWarnings";

    @Override
    public List<Negotiation> getNegotiationChangeCandidates(PersonMassChange personMassChange) {
        List<Negotiation> negotiationChangeCandidates = new ArrayList<Negotiation>();
        
        List<Negotiation> negotiations = new ArrayList<Negotiation>();
        if (personMassChange.getNegotiationPersonMassChange().requiresChange()) {
            negotiations.addAll(getNegotiations(personMassChange));
        }

        for (Negotiation negotiation : negotiations) {
            if (isNegotiationChangeCandidate(personMassChange, negotiation)) {
                negotiationChangeCandidates.add(negotiation);
            }
        }
        
        for (Negotiation negotiationChangeCandidate : negotiationChangeCandidates) {
            if (!negotiationChangeCandidate.getDocument().getPessimisticLocks().isEmpty()) {
                reportSoftError(negotiationChangeCandidate);
            }
        }
        
        return negotiationChangeCandidates;
    }
    
    private List<Negotiation> getNegotiations(PersonMassChange personMassChange) {
        return new ArrayList<Negotiation>(getBusinessObjectService().findAll(Negotiation.class));
    }
    
    private boolean isNegotiationChangeCandidate(PersonMassChange personMassChange, Negotiation negotiation) {
        boolean isNegotiationChangeCandidate = false;

        if (personMassChange.getNegotiationPersonMassChange().isNegotiator()) {
            isNegotiationChangeCandidate |= isNegotiatorChangeCandidate(personMassChange, negotiation);
        }
        
        return isNegotiationChangeCandidate;
    }
    
    private boolean isNegotiatorChangeCandidate(PersonMassChange personMassChange, Negotiation negotiation) {
        return isPersonIdMassChange(personMassChange, negotiation.getNegotiatorPersonId());
    }

    @Override
    public void performPersonMassChange(PersonMassChange personMassChange, List<Negotiation> negotiationChangeCandidates) {
        for (Negotiation negotiationChangeCandidate : negotiationChangeCandidates) {
            if (negotiationChangeCandidate.getDocument().getPessimisticLocks().isEmpty()) {
                performNegotiatorPersonMassChange(personMassChange, negotiationChangeCandidate);
            }
        }
    }
    
    private void performNegotiatorPersonMassChange(PersonMassChange personMassChange, Negotiation negotiation) {
        if (personMassChange.getNegotiationPersonMassChange().isNegotiator()) {
            KcPerson kcPerson = getKcPersonService().getKcPersonByPersonId(personMassChange.getReplacerPersonId());
            negotiation.setNegotiatorPersonId(kcPerson.getPersonId());
            negotiation.setNegotiatorName(kcPerson.getFullName());
            
            getBusinessObjectService().save(negotiation);
        }
    }
        
    private void reportSoftError(Negotiation negotiation) {
        Long negotiationId = negotiation.getNegotiationId();
        errorReporter.reportSoftError(PMC_LOCKED_FIELD, KeyConstants.ERROR_PERSON_MASS_CHANGE_DOCUMENT_LOCKED, NEGOTIATION, String.valueOf(negotiationId));
    }

    @Override
    protected String getDocumentId(PersistableBusinessObject parent) {
        return ((Negotiation) parent).getNegotiationId().toString();
    }

    @Override
    protected String getDocumentName() {
        return NEGOTIATION;
    }

    @Override
    protected String getWarningKey() {
        return NEGOTIATION_WARNINGS;
    }

}
