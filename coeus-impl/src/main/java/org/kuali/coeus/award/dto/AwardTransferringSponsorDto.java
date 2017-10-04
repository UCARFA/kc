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
