/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.lookup;

import org.apache.commons.lang3.StringUtils;
import org.apache.ojb.broker.query.Criteria;
import org.apache.ojb.broker.query.QueryFactory;
import org.apache.ojb.broker.query.ReportQueryByCriteria;
import org.kuali.coeus.common.framework.version.VersionStatus;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardConstants;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.proposallog.ProposalLog;
import org.kuali.kra.negotiations.bo.Negotiation;
import org.kuali.kra.negotiations.bo.NegotiationAssociationType;
import org.kuali.kra.negotiations.bo.NegotiationUnassociatedDetail;
import org.kuali.kra.negotiations.service.NegotiationService;
import org.kuali.kra.subaward.bo.SubAward;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.krad.bo.BusinessObject;
import org.kuali.rice.krad.dao.impl.LookupDaoOjb;
import org.kuali.rice.krad.lookup.CollectionIncomplete;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.KRADConstants;
import org.springframework.dao.DataIntegrityViolationException;
import org.springmodules.orm.ojb.OjbOperationException;

import java.util.*;

/**
 * Negotiation Dao to assist with lookups. This implements looking up associated document information
 * as well as just negotiation info.
 */
public class NegotiationDaoOjb extends LookupDaoOjb implements NegotiationDao {

	private static final String ASSOC_PREFIX = "associatedNegotiable";
    private static final String NEGOTIATION_TYPE_ATTR = "negotiationAssociationTypeId";
    private static final String ASSOCIATED_DOC_ID_ATTR = "associatedDocumentId";
    private static final String INVALID_COLUMN_NAME = "NaN";
    private static final String PROPOSAL_NUMBER = "proposalNumber";
    private static final String NEGOTIATION_AGE = "negotiationAge";

    private static Map<String, String> awardTransform;
    private static Map<String, String> proposalTransform;
    private static Map<String, String> proposalLogTransform;
    private static Map<String, String> unassociatedTransform;
    private static Map<String, String> subAwardTransform;
    
    private NegotiationService negotiationService;
    
    static {
        awardTransform = new HashMap<>();
        awardTransform.put("sponsorName", "sponsor.sponsorName");
        awardTransform.put("piName", "projectPersons.fullName");
        //proposal type code doesn't exist on the award so make sure we don't find awards when
        //search for proposal type
        awardTransform.put("negotiableProposalTypeCode", INVALID_COLUMN_NAME);
        awardTransform.put("leadUnitNumber", "unitNumber");
        awardTransform.put("leadUnitName", "leadUnit.unitName");
        awardTransform.put("subAwardRequisitionerId", INVALID_COLUMN_NAME);
                
        proposalTransform = new HashMap<>();
        proposalTransform.put("sponsorName", "sponsor.sponsorName");
        proposalTransform.put("piName", "projectPersons.fullName");
        proposalTransform.put("leadUnitNumber", "unitNumber");
        proposalTransform.put("leadUnitName", "leadUnit.unitName");
        proposalTransform.put("negotiableProposalTypeCode", "proposalTypeCode");
        proposalTransform.put("subAwardRequisitionerId", INVALID_COLUMN_NAME);
        
        proposalLogTransform = new HashMap<>();
        proposalLogTransform.put("sponsorName", "sponsor.sponsorName");
        proposalLogTransform.put("leadUnitNumber", "leadUnit");
        proposalLogTransform.put("leadUnitName", "unit.unitName");
        proposalLogTransform.put("negotiableProposalTypeCode", "proposalTypeCode");
        proposalLogTransform.put("subAwardRequisitionerId", INVALID_COLUMN_NAME);

        unassociatedTransform = new HashMap<>();
        unassociatedTransform.put("sponsorName", "sponsor.sponsorName");
        unassociatedTransform.put("piName", "piName");
        //proposal type code doesn't exist here either so make sure we don't find then when
        //searching for proposal type
        unassociatedTransform.put("negotiableProposalTypeCode", INVALID_COLUMN_NAME);
        unassociatedTransform.put("leadUnitName", "leadUnit.unitName");
        unassociatedTransform.put("subAwardRequisitionerId", INVALID_COLUMN_NAME);
        
        subAwardTransform = new HashMap<>();
        subAwardTransform.put("sponsorName", INVALID_COLUMN_NAME);
        subAwardTransform.put("sponsorCode", INVALID_COLUMN_NAME);
        subAwardTransform.put("piName", INVALID_COLUMN_NAME);
        subAwardTransform.put("negotiableProposalTypeCode", INVALID_COLUMN_NAME);
        subAwardTransform.put("leadUnitNumber", "unitNumber");
        subAwardTransform.put("leadUnitName", "leadUnit.unitName");
        subAwardTransform.put("subAwardRequisitionerId", "requisitionerId");
    }

    @Override
    public Collection<Negotiation> getNegotiationResults(Map<String, String> fieldValues) {
        Map<String, String> associationDetails = new HashMap<>();
        Iterator<Map.Entry<String, String>> iter = fieldValues.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            if (StringUtils.startsWith(entry.getKey(), ASSOC_PREFIX)) {
                iter.remove();
                if (!StringUtils.isEmpty(entry.getValue())) {
                    associationDetails.put(entry.getKey().replaceFirst(ASSOC_PREFIX + ".", ""), entry.getValue());
                }
            }
        }
        
        Collection<Negotiation> result = new ArrayList<>();
        if (!associationDetails.isEmpty()) {
            addListToList(result, getNegotiationsLinkedToAward(fieldValues, associationDetails));
            addListToList(result, getNegotiationsLinkedToProposal(fieldValues, associationDetails));
            addListToList(result, getNegotiationsLinkedToProposalLog(fieldValues, associationDetails));
            addListToList(result, getNegotiationsUnassociated(fieldValues, associationDetails));
            addListToList(result, getNegotiationsLinkedToSubAward(fieldValues, associationDetails));
        } else {
            result = findCollectionBySearchHelper(Negotiation.class, fieldValues, false, false);
        }
        final String negotiationAge = fieldValues.get(NEGOTIATION_AGE);
        if (result != null && !result.isEmpty() && StringUtils.isNotBlank(negotiationAge)) {
            try {
                result = filterByNegotiationAge(negotiationAge, result);
            } catch (NumberFormatException e) {
                GlobalVariables.getMessageMap().putError(KRADConstants.DOCUMENT_ERRORS, RiceKeyConstants.ERROR_CUSTOM, "Invalid Numeric Input: " + negotiationAge);
                result = new ArrayList<>();
            }
        }
        return result;
    }
    
    private void addListToList(Collection<Negotiation> fullResultList, Collection<Negotiation> listToAdd) {
        if (fullResultList != null && listToAdd != null) {
            Integer max = org.kuali.rice.kns.lookup.LookupUtils.getSearchResultsLimit(Negotiation.class);
            if (max == null) {
                max = 500;
            }
            if (fullResultList.size() < max) {
                int fullResultListPlusListToAddSize = fullResultList.size() + listToAdd.size();
                if (fullResultListPlusListToAddSize <= max) {
                    fullResultList.addAll(listToAdd);
                } else {
                    int numberOfNewEntriesToAdd = max - fullResultList.size();
                    int counter = 1;
                    for (Negotiation neg : listToAdd) {
                        if (counter < numberOfNewEntriesToAdd) {
                            fullResultList.add(neg);
                        }
                        counter++;
                    }
                }
            }
        }
    }
    
    private Collection findCollectionBySearchHelper(Class businessObjectClass, Map formProps, boolean unbounded, boolean usePrimaryKeyValuesOnly, Object additionalCriteria ) {
        BusinessObject businessObject = checkBusinessObjectClass(businessObjectClass);
        if (usePrimaryKeyValuesOnly) {
            return executeSearch(businessObjectClass, getCollectionCriteriaFromMapUsingPrimaryKeysOnly(businessObjectClass, formProps), unbounded);
        }
        
        Criteria crit = getCollectionCriteriaFromMap(businessObject, formProps);
        if (additionalCriteria != null && additionalCriteria instanceof Criteria) {
            crit.addAndCriteria((Criteria) additionalCriteria);
        }

        return executeSearch(businessObjectClass, crit, unbounded);
    }
    
    private BusinessObject checkBusinessObjectClass(Class businessObjectClass) {
        if (businessObjectClass == null) {
            throw new IllegalArgumentException("BusinessObject class passed to LookupDaoOjb findCollectionBySearchHelper... method was null");
        }
        final BusinessObject businessObject;
        try {
            businessObject = (BusinessObject) businessObjectClass.newInstance();
        }
        catch (IllegalAccessException|InstantiationException e) {
            throw new RuntimeException("LookupDaoOjb could not get instance of " + businessObjectClass.getName(), e);
        }

        return businessObject;
    }
    
    private Collection executeSearch(Class businessObjectClass, Criteria criteria, boolean unbounded) {
        Collection searchResults;
        Long matchingResultsCount = null;
        try {
            Integer searchResultsLimit = org.kuali.rice.kns.lookup.LookupUtils.getSearchResultsLimit(businessObjectClass);
            if (!unbounded && (searchResultsLimit != null)) {
                matchingResultsCount = (long) getPersistenceBrokerTemplate().getCount(QueryFactory.newQuery(businessObjectClass, criteria));
                getDbPlatform().applyLimitSql(searchResultsLimit);
            }
            if ((matchingResultsCount == null) || (matchingResultsCount.intValue() <= searchResultsLimit)) {
                matchingResultsCount = 0L;
            }
            searchResults = getPersistenceBrokerTemplate().getCollectionByQuery(QueryFactory.newQuery(businessObjectClass, criteria));
            // populate Person objects in business objects
            List bos = new ArrayList();
            bos.addAll(searchResults);
            searchResults = bos;
        }
        catch (OjbOperationException|DataIntegrityViolationException e) {
            throw new RuntimeException("NegotiationDaoOjb encountered exception during executeSearch", e);
        }

        return new CollectionIncomplete(searchResults, matchingResultsCount);
    }
    
    /**
     * Search for awards linked to negotiation using both award and negotiation values.
     */
    protected Collection<Negotiation> getNegotiationsLinkedToAward(Map<String, String> negotiationValues, Map<String, String> associatedValues) {
        Map<String, String> values = transformMap(associatedValues, awardTransform);
        if (values == null) {
            return new ArrayList<>();
        }
        Criteria criteria = getCollectionCriteriaFromMap(new Award(), values);

        Criteria activeAwardSubCriteria = new Criteria();
        activeAwardSubCriteria.addIn(AwardConstants.AWARD_SEQUENCE_STATUS,
        	Arrays.asList(VersionStatus.ACTIVE.toString(), VersionStatus.PENDING.toString()));
        ReportQueryByCriteria activeAwardIdsQuery = QueryFactory.newReportQuery(Award.class, activeAwardSubCriteria);
        activeAwardIdsQuery.setAttributes(new String[]{ AwardConstants.MAX_AWARD_ID });
        activeAwardIdsQuery.addGroupBy(AwardConstants.AWARD_NUMBER);
        criteria.addIn(AwardConstants.AWARD_ID, activeAwardIdsQuery);

        Criteria negotiationCrit = new Criteria();
        ReportQueryByCriteria subQuery = QueryFactory.newReportQuery(Award.class, criteria);
        subQuery.setAttributes(new String[] { AwardConstants.AWARD_NUMBER });
        negotiationCrit.addIn(ASSOCIATED_DOC_ID_ATTR, subQuery);
        negotiationCrit.addEqualTo(NEGOTIATION_TYPE_ATTR, 
                getNegotiationService().getNegotiationAssociationType(NegotiationAssociationType.AWARD_ASSOCIATION).getId());
        Collection<Negotiation> result = this.findCollectionBySearchHelper(Negotiation.class, negotiationValues, false, false, negotiationCrit);
        return result;
    }
    
    /**
     * Search for institutional proposals linked to negotiations using both criteria.
     */
    protected Collection<Negotiation> getNegotiationsLinkedToProposal(Map<String, String> negotiationValues, Map<String, String> associatedValues) {
        Map<String, String> values = transformMap(associatedValues, proposalTransform);
        if (values == null) {
            return new ArrayList<>();
        }
        values.put("proposalSequenceStatus", VersionStatus.ACTIVE.name());
        Criteria criteria = getCollectionCriteriaFromMap(new InstitutionalProposal(), values);
        Criteria negotiationCrit = new Criteria();
        ReportQueryByCriteria subQuery = QueryFactory.newReportQuery(InstitutionalProposal.class, criteria);
        subQuery.setAttributes(new String[] {PROPOSAL_NUMBER});
        negotiationCrit.addIn(ASSOCIATED_DOC_ID_ATTR, subQuery);
        negotiationCrit.addEqualTo(NEGOTIATION_TYPE_ATTR, 
                getNegotiationService().getNegotiationAssociationType(NegotiationAssociationType.INSTITUATIONAL_PROPOSAL_ASSOCIATION).getId());
        Collection<Negotiation> result = this.findCollectionBySearchHelper(Negotiation.class, negotiationValues, false, false, negotiationCrit);
        return result;
    }
    
    /**
     * Search for proposal logs linked to negotiations using both criteria.
     */
    protected Collection<Negotiation> getNegotiationsLinkedToProposalLog(Map<String, String> negotiationValues, Map<String, String> associatedValues) {
        Map<String, String> values = transformMap(associatedValues, proposalLogTransform);
        if (values == null) {
            return new ArrayList<>();
        }
        Criteria criteria = getCollectionCriteriaFromMap(new ProposalLog(), values);
        Criteria negotiationCrit = new Criteria();
        ReportQueryByCriteria subQuery = QueryFactory.newReportQuery(ProposalLog.class, criteria);
        subQuery.setAttributes(new String[] {PROPOSAL_NUMBER});
        negotiationCrit.addIn(ASSOCIATED_DOC_ID_ATTR, subQuery);
        negotiationCrit.addEqualTo(NEGOTIATION_TYPE_ATTR, 
                getNegotiationService().getNegotiationAssociationType(NegotiationAssociationType.PROPOSAL_LOG_ASSOCIATION).getId());
        Collection<Negotiation> result = this.findCollectionBySearchHelper(Negotiation.class, negotiationValues, false, false, negotiationCrit);
        return result;
    } 
    
    /**
     * 
     * This method returns Negotiations linked to subawards based on search.
     */
    protected Collection<Negotiation> getNegotiationsLinkedToSubAward(Map<String, String> negotiationValues, Map<String, String> associatedValues) {

        Map<String, String> values = transformMap(associatedValues, subAwardTransform);
        if (values == null) {
            return new ArrayList<>();
        }
        Criteria criteria = getCollectionCriteriaFromMap(new SubAward(), values);
        Criteria negotiationCrit = new Criteria();
        ReportQueryByCriteria subQuery = QueryFactory.newReportQuery(SubAward.class, criteria);
        subQuery.setAttributes(new String[] {"subAwardId"});
        negotiationCrit.addIn(ASSOCIATED_DOC_ID_ATTR, subQuery);
        negotiationCrit.addEqualTo(NEGOTIATION_TYPE_ATTR, 
                getNegotiationService().getNegotiationAssociationType(NegotiationAssociationType.SUB_AWARD_ASSOCIATION).getId());
        Collection<Negotiation> result = this.findCollectionBySearchHelper(Negotiation.class, negotiationValues, false, false, negotiationCrit);
        
        return result;
    }  
    
    /**
     * Search for unassociated negotiations using criteria from the unassociated detail.
     */
    protected Collection<Negotiation> getNegotiationsUnassociated(Map<String, String> negotiationValues, Map<String, String> associatedValues) {
        Map<String, String> values = transformMap(associatedValues, unassociatedTransform);
        if (values == null) {
            return new ArrayList<>();
        }
        Criteria criteria = getCollectionCriteriaFromMap(new NegotiationUnassociatedDetail(), values);
        Criteria negotiationCrit = new Criteria();
        ReportQueryByCriteria subQuery = QueryFactory.newReportQuery(NegotiationUnassociatedDetail.class, criteria);
        subQuery.setAttributes(new String[] {"negotiationUnassociatedDetailId"});
        negotiationCrit.addIn(ASSOCIATED_DOC_ID_ATTR, subQuery);
        negotiationCrit.addEqualTo(NEGOTIATION_TYPE_ATTR, 
                getNegotiationService().getNegotiationAssociationType(NegotiationAssociationType.NONE_ASSOCIATION).getId());
        Collection<Negotiation> result = this.findCollectionBySearchHelper(Negotiation.class, negotiationValues, false, false, negotiationCrit);
        return result;
    }    
    
    /**
     * Take the associated field values and convert them to document specific values using the provided
     * transform key.
     */
    protected Map<String, String> transformMap(Map<String, String> values, Map<String, String> transformKey) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry : values.entrySet()) {
            if (transformKey.get(entry.getKey()) != null) {
                result.put(transformKey.get(entry.getKey()), entry.getValue());
            } else {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        if (result.containsKey(INVALID_COLUMN_NAME)) {
            return null;
        } else {
            return result;
        }
    }
    
    /**
     * Since the negotiation age is not persisted filter negotiations based on age.
     */
    protected Collection<Negotiation> filterByNegotiationAge(String value, Collection<Negotiation> negotiations) {
        int lowValue = 0;
        int highValue = 0;
        boolean greaterThan = false;
        boolean lessThan = false;
        boolean between = false;
        if (value.contains(">")) {
            greaterThan = true;
            lowValue = Integer.parseInt(value.replace(">", ""));
        } else if (value.contains("<")) {
            lessThan = true;
            highValue = Integer.parseInt(value.replace("<", ""));
        } else if (value.contains("..")) {
            between = true;
            String[] values = value.split("\\.\\.");
            lowValue = Integer.parseInt(values[0]);
            highValue = Integer.parseInt(values[1]);
        } else {
            lowValue = Integer.parseInt(value);
        }
        Iterator<Negotiation> iter = negotiations.iterator();
        while (iter.hasNext()) {
            Negotiation negotiation = iter.next();
            if (greaterThan) {
                if (negotiation.getNegotiationAge() <= lowValue) {
                    iter.remove();
                }
            } else if (lessThan) {
                if (negotiation.getNegotiationAge() >= highValue) {
                    iter.remove();
                }
            } else if (between) {
                if (negotiation.getNegotiationAge() < lowValue
                        || negotiation.getNegotiationAge() > highValue) {
                    iter.remove();
                }
            } else {
                if (negotiation.getNegotiationAge() != lowValue) {
                    iter.remove();
                }
            }
        }
        
        return negotiations;
    }

    public NegotiationService getNegotiationService() {
        return negotiationService;
    }

    public void setNegotiationService(NegotiationService negotiationService) {
        this.negotiationService = negotiationService;
    }

}
