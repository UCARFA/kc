/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rule.event;

import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.rice.krad.document.Document;

import java.util.List;

/**
 * 
 * This class is using the new rule framework.  The old framework is using CommitteeMembershipRuleEventBase
 */
public abstract class CommitteeMemberEventBase <Z extends KcBusinessRule> extends KcDocumentEventBaseExtension {
    
    /**
     * Enum helps identify type of error to respond.
     */
    public enum ErrorType {HARDERROR, SOFTERROR};
    
    private List<CommitteeMembershipBase> committeeMemberships;
        
    private ErrorType type;
    
    /**
     * 
     * Constructs a CommitteeMemberEventBase.java.
     * @param description
     * @param errorPathPrefix
     * @param document
     * @param committeeMemberships
     * @param type
     */
    public CommitteeMemberEventBase(String description, String errorPathPrefix, Document document, List<CommitteeMembershipBase> committeeMemberships, ErrorType type) {        
        super(description, errorPathPrefix, document);
        this.committeeMemberships = committeeMemberships;
        this.type = type;
    }
        
    public ErrorType getType() {
        return this.type;
    }

    public List<CommitteeMembershipBase> getCommitteeMemberships() {
        return committeeMemberships;
    }

    public void setCommitteeMemberships(List<CommitteeMembershipBase> committeeMemberships) {
        this.committeeMemberships = committeeMemberships;
    }
}

