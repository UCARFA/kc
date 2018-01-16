/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.sponsor;

import com.codiform.moo.annotation.Property;

public class SponsorDto {

	private String sponsorCode;
	private String sponsorName;
	private String acronym;
    @Property(translate = true, update = true)
    private SponsorTypeDto sponsorType;

    public String getSponsorCode() {
		return sponsorCode;
	}
	public void setSponsorCode(String sponsorCode) {
		this.sponsorCode = sponsorCode;
	}
	public String getSponsorName() {
		return sponsorName;
	}
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}
	public String getAcronym() {
		return acronym;
	}
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
    public SponsorTypeDto getSponsorType() {
        return sponsorType;
    }
    public void setSponsorType(SponsorTypeDto sponsorType) {
        this.sponsorType = sponsorType;
    }
}
