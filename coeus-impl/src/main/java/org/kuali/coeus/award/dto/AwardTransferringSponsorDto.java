/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.dto;

import org.kuali.coeus.common.framework.sponsor.SponsorDto;

import com.codiform.moo.annotation.Property;

public class AwardTransferringSponsorDto {

    private Integer awardTransferringSponsorId;

    private String sponsorCode;
    
    @Property(translate = true, update = true)
    private SponsorDto sponsor;

    public Integer getAwardTransferringSponsorId() {
        return awardTransferringSponsorId;
    }

    public void setAwardTransferringSponsorId(Integer awardTransferringSponsorId) {
        this.awardTransferringSponsorId = awardTransferringSponsorId;
    }

    public String getSponsorCode() {
        return sponsorCode;
    }

    public void setSponsorCode(String sponsorCode) {
        this.sponsorCode = sponsorCode;
    }

	public SponsorDto getSponsor() {
		return sponsor;
	}

	public void setSponsor(SponsorDto sponsor) {
		this.sponsor = sponsor;
	}


}
