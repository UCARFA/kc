/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.editable;

import java.sql.Date;

public interface PersonEditable {

    String getPersonId();

    Integer getRolodexId();

    String getFullName();

    void setRolodexId(Integer rolodexId);

    void setSocialSecurityNumber(String socialSecurityNumber);

    void setFirstName(String firstName);

    void setMiddleName(String middleName);

    void setFullName(String fullName);

    void setPriorName(String priorName);

    void setUserName(String userName);

    void setEmailAddress(String emailAddress);

    void setDateOfBirth(Date dateOfBirth);

    void setAge(Integer age);

    void setAgeByFiscalYear(Integer ageByFiscalYear);

    void setGender(String gender);

    void setRace(String race);

    void setEducationLevel(String educationLevel);

    void setDegree(String degree);

    void setMajor(String major);

    void setHandicappedFlag(Boolean handicappedFlag);

    void setHandicapType(String handicapType);

    void setVeteranFlag(Boolean veteranFlag);

    void setVeteranType(String veteranType);

    void setVisaCode(String visaCode);

    void setVisaType(String visaType);

    void setVisaRenewalDate(Date visaRenewalDate);

    void setHasVisa(Boolean hasVisa);

    void setOfficeLocation(String officeLocation);

    void setOfficePhone(String officePhone);

    void setSecondaryOfficeLocation(String secondaryOfficeLocation);

    void setSecondaryOfficePhone(String secondaryOfficePhone);

    void setSchool(String school);

    void setYearGraduated(String yearGraduated);

    void setDirectoryDepartment(String directoryDepartment);

    void setSaluation(String saluation);

    void setCountryOfCitizenship(String countryOfCitizenship);

    void setPrimaryTitle(String primaryTitle);

    void setDirectoryTitle(String directoryTitle);

    void setHomeUnit(String homeUnit);

    void setFacultyFlag(Boolean facultyFlag);

    void setGraduateStudentStaffFlag(Boolean graduateStudentStaffFlag);

    void setResearchStaffFlag(Boolean researchStaffFlag);

    void setServiceStaffFlag(Boolean serviceStaffFlag);

    void setSupportStaffFlag(Boolean supportStaffFlag);

    void setOtherAcademicGroupFlag(Boolean otherAcademicGroupFlag);

    void setMedicalStaffFlag(Boolean medicalStaffFlag);

    void setVacationAccrualFlag(Boolean vacationAccrualFlag);

    void setOnSabbaticalFlag(Boolean onSabbaticalFlag);

    void setIdProvided(String idProvided);

    void setIdVerified(String idVerified);

    void setAddressLine1(String addressLine1);

    void setAddressLine2(String addressLine2);

    void setAddressLine3(String addressLine3);

    void setCity(String city);

    void setCounty(String county);

    void setState(String state);

    void setPostalCode(String postalCode);

    void setCountryCode(String countryCode);

    void setFaxNumber(String faxNumber);

    void setPagerNumber(String pagerNumber);

    void setMobilePhoneNumber(String mobilePhoneNumber);

    void setEraCommonsUserName(String eraCommonsUserName);

    void setLastName(String lastName);
    
    void setCitizenshipTypeCode(Integer citizenshipTypeCode);

}
