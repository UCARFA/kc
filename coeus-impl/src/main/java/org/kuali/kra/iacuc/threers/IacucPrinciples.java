/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.threers;

import org.kuali.kra.protocol.ProtocolAssociateBase;

/**
 * 
 * This class represents the "Three R's" or principles of IACUC,
 * (Reduction, Refinement, &amp; Replacement).
 */
public class IacucPrinciples extends ProtocolAssociateBase {

    private static final long serialVersionUID = 580264349919894175L;
    
    private Integer iacucPrinciplesId;
    private String reduction;
    private String refinement;
    private String replacement;
    private String searchRequired;
    private boolean exceptionsPresent;
    
    public Integer getIacucPrinciplesId() {
        return iacucPrinciplesId;
    }
    public void setIacucPrinciplesId(Integer iacucPrinciplesId) {
        this.iacucPrinciplesId = iacucPrinciplesId;
    }
    public String getReduction() {
        return reduction;
    }
    public void setReduction(String reduction) {
        this.reduction = reduction;
    }
    public String getRefinement() {
        return refinement;
    }
    public void setRefinement(String refinement) {
        this.refinement = refinement;
    }
    public String getReplacement() {
        return replacement;
    }
    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }
    
    @Override
    public void resetPersistenceState() {
        this.setIacucPrinciplesId(null);        
    }
    public boolean isExceptionsPresent() {
        return exceptionsPresent;
    }
    public void setExceptionsPresent(boolean exceptionsPresent) {
        this.exceptionsPresent = exceptionsPresent;
    }
    public String getSearchRequired() {
        return searchRequired;
    }
    public void setSearchRequired(String searchRequired) {
        this.searchRequired = searchRequired;
    }
    
}
