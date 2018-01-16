/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.rules;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.negotiations.bo.Negotiation;
import org.kuali.kra.negotiations.bo.NegotiationActivity;
import org.kuali.kra.negotiations.document.NegotiationDocument;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * 
 * Validation class to use when validating activities.
 */
public class NegotiationActivityRuleImpl implements NegotiationActivityAddRule {
    
    private static final String START_DATE_PROPERTY = "startDate";
    private static final String END_DATE_PROPERTY = "endDate";
    private static final String ACTIVITY_TYPE = "activityType";
    private static final String ACTIVITY_TYPE_ID = "activityTypeId";
    private static final String LOCATION = "location";
    private static final String LOCATION_ID = "locationId";
    private static final String DESCRIPTION = "description";
    private static final String ACTIVITY_TYPE_DESC = "Activity Type (Activity Type)";
    private static final String LOCATION_DESC = "Location (Location)";
    private static final String ACTIVITY_START_DATE_DESC = "Activity Start Date (Activity Start Date)";
    private static final String ACTIVITY_DESCRIPTION_DESC = "Activity Description (Activity Description)";

    private ErrorReporter errorReporter;
    
    @Override
    public boolean processAddNegotiationActivityRule(NegotiationActivityAddRuleEvent event) {
        boolean result = true;
        
        NegotiationDocument negotiationDoc = (NegotiationDocument) event.getDocument();
        Negotiation negotiation = negotiationDoc.getNegotiation();
        NegotiationActivity newActivity = event.getNewActivity();
        
        GlobalVariables.getMessageMap().addToErrorPath(event.getErrorPathPrefix());
        result &= validateNegotiationActivity(newActivity, negotiation);
        GlobalVariables.getMessageMap().removeFromErrorPath(event.getErrorPathPrefix());
        
        
        return result;
    }
    
    /**
     * 
     * Call this to validate individual activities.
     */
    public boolean validateNegotiationActivity(NegotiationActivity activity, Negotiation negotiation) {
        boolean result = true;
        activity.refreshReferenceObject(ACTIVITY_TYPE);
        if (activity.getActivityType() == null) {
            result = false;
            getErrorReporter().reportError(ACTIVITY_TYPE_ID, KeyConstants.ERROR_REQUIRED, ACTIVITY_TYPE_DESC);
        }
        activity.refreshReferenceObject(LOCATION);
        if (activity.getLocation() == null) {
            result = false;
            getErrorReporter().reportError(LOCATION_ID, KeyConstants.ERROR_REQUIRED, LOCATION_DESC);
        }
        if (activity.getStartDate() == null) {
            result = false;
            getErrorReporter().reportError(START_DATE_PROPERTY, KeyConstants.ERROR_REQUIRED, ACTIVITY_START_DATE_DESC);
        }
        if (StringUtils.isBlank(activity.getDescription())) {
            result = false;
            getErrorReporter().reportError(DESCRIPTION, KeyConstants.ERROR_REQUIRED, ACTIVITY_DESCRIPTION_DESC);
        }
        if (activity.getStartDate() != null && negotiation.getNegotiationStartDate() != null 
                && activity.getStartDate().compareTo(negotiation.getNegotiationStartDate()) < 0) {
            result = false;
            getErrorReporter().reportError(START_DATE_PROPERTY, KeyConstants.NEGOTIATION_ACTIVITY_START_BEFORE_NEGOTIATION);
        }
        if (activity.getStartDate() != null && activity.getEndDate() != null
                && activity.getStartDate().compareTo(activity.getEndDate()) > 0) {
            result = false;
            getErrorReporter().reportError(END_DATE_PROPERTY, KeyConstants.NEGOTIATION_ACTIVITY_START_BEFORE_END);
        }
        if (activity.getEndDate() != null && negotiation.getNegotiationEndDate() != null
                && activity.getEndDate().compareTo(negotiation.getNegotiationEndDate()) > 0) {
            getErrorReporter().reportWarning(END_DATE_PROPERTY, KeyConstants.NEGOTIATION_ACTIVITY_END_AFTER_NEGOTIATION);
        }

        return result;
    }


    public ErrorReporter getErrorReporter() {
        if (errorReporter == null) {
            errorReporter = KcServiceLocator.getService(ErrorReporter.class);
        }

        return errorReporter;
    }

    public void setErrorReporter(ErrorReporter errorReporter) {
        this.errorReporter = errorReporter;
    }
}
