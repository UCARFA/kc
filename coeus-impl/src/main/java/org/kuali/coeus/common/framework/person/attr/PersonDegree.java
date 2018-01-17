/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.attr;


import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * Business Object representation of a PersonDegree. A <code>{@link Person}</code> may have many degrees. This represents the relationship
 * of a <code>{@link Person}</code> to a degree as well as the degree itself.
 * 
 * @see org.kuali.kra.bo.Person
 */
public class PersonDegree extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 586782856382134862L;

    private Integer degreeId;

    private String personId;

    private String degreeCode;

    private String degree;

    private DegreeType degreeType;

    private String fieldOfStudy;

    private String specialization;

    private String school;

    private String schoolIdCode;

    private String schoolId;

    private String graduationYear;

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getDegreeCode() {
        return degreeCode;
    }

    public void setDegreeCode(String degreeCode) {
        this.degreeCode = degreeCode;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public DegreeType getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(DegreeType degreeType) {
        this.degreeType = degreeType;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolIdCode() {
        return schoolIdCode;
    }

    public void setSchoolIdCode(String schoolIdCode) {
        this.schoolIdCode = schoolIdCode;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }
}
