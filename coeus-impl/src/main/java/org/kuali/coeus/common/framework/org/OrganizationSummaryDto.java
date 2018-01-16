/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.org;

import org.kuali.coeus.common.framework.rolodex.RolodexDto;

import com.codiform.moo.annotation.Property;

public class OrganizationSummaryDto {

    private String organizationId;
    private String organizationName;
    private String address;
    @Property(translate = true, source = "rolodex")
    private RolodexDto contact;
    
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public RolodexDto getContact() {
		return contact;
	}
	public void setContact(RolodexDto contact) {
		this.contact = contact;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
}
