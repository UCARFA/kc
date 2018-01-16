/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.keywords;

import org.kuali.coeus.common.framework.keyword.AbstractScienceKeyword;
import org.kuali.coeus.common.framework.keyword.ScienceKeyword;
import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;
import org.kuali.kra.award.home.Award;

/**
 * 
 * This class is BO to represent Award Science Keyword object
 */
public class AwardScienceKeyword extends AbstractScienceKeyword implements SequenceAssociate<Award> {


    private static final long serialVersionUID = -8415861677886653309L;

    private Long awardScienceKeywordId;

    private Award award;

    /**
     * Empty constructor for AwardScienceKeyword.
     */
    public AwardScienceKeyword() {
    }

    /**
     * Constructs a AwardScienceKeyword.
     * @param awardId
     * @param scienceKeyword
     */
    public AwardScienceKeyword(Long awardId, ScienceKeyword scienceKeyword) {
        super();
        setScienceKeywordDescription(scienceKeyword.getDescription());
        setScienceKeywordCode(scienceKeyword.getCode());
        setScienceKeyword(scienceKeyword);
        setVersionNumber(getVersionNumber() == null ? 1 : getVersionNumber());
    }

    /**
     * Gets the awardScienceKeywordId attribute. 
     * @return Returns the awardScienceKeywordId.
     */
    public Long getAwardScienceKeywordId() {
        return awardScienceKeywordId;
    }

    /**
     * Sets the awardScienceKeywordId attribute value.
     * @param awardScienceKeywordId The awardScienceKeywordId to set.
     */
    public void setAwardScienceKeywordId(Long awardScienceKeywordId) {
        this.awardScienceKeywordId = awardScienceKeywordId;
    }

    /**
     * Gets the award attribute. 
     * @return Returns the award.
     */
    public Award getAward() {
        return award;
    }

    /**
     * Sets the award attribute value.
     * @param award The award to set.
     */
    public void setAward(Award award) {
        this.award = award;
    }
    
    @Override
    public Award getSequenceOwner() {
        return award;
    }

    @Override
    public void setSequenceOwner(Award sequenceOwner) {
        award = sequenceOwner;
    }

    @Override
    public Integer getSequenceNumber() {
        return getSequenceOwner() != null ? getSequenceOwner().getSequenceNumber() : null;
    }

    @Override
    public void resetPersistenceState() {
        awardScienceKeywordId = null;
     }

}
