/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.summary;

import org.kuali.coeus.common.framework.person.KcPersonDto;

import com.codiform.moo.annotation.Optionality;
import com.codiform.moo.annotation.Property;

public class InvestigatorDto {

	private String personId;
	private String fullName;
	private String emailAddress;
	@Property(source = "mvel:person.?userName", optionality=Optionality.OPTIONAL)
	private String userName;
	private String roleCode;
	private String projectRole;
	@Property(translate = true, optionality = Optionality.OPTIONAL)
	private KcPersonDto person;
	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getProjectRole() {
		return projectRole;
	}
	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}
	public KcPersonDto getPerson() {
		return person;
	}
	public void setPerson(KcPersonDto person) {
		this.person = person;
	}
}
