/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.budget.service;

import java.io.Serializable;

/*
<p>Java class for BudgetCategoryDTO complex type.
* 
* <p>The following schema fragment specifies the expected content contained within this class.
* 
* <pre>
* &lt;complexType name="budgetCategoryDTO">
*   &lt;complexContent>
*     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
*       &lt;sequence>
*         &lt;element name="budgetCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="authorPersonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="budgetCategoryTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*         &lt;element name="budgetCategoryTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
*       &lt;/sequence>
*     &lt;/restriction>
*   &lt;/complexContent>
* &lt;/complexType>
* </pre>
* 
* 
*/
public class BudgetCategoryDTO implements Serializable {


    private static final long serialVersionUID = 1L;
    
    String budgetCategoryCode;
    String authorPersonName;
    String budgetCategoryTypeCode;
    String description;
    String budgetCategoryTypeDescription;
    
    public String getBudgetCategoryCode() {
        return budgetCategoryCode;
    }
    public void setBudgetCategoryCode(String budgetCategoryCode) {
        this.budgetCategoryCode = budgetCategoryCode;
    }
    public String getAuthorPersonName() {
        return authorPersonName;
    }
    public void setAuthorPersonName(String authorPersonName) {
        this.authorPersonName = authorPersonName;
    }
    public String getBudgetCategoryTypeCode() {
        return budgetCategoryTypeCode;
    }
    public void setBudgetCategoryTypeCode(String budgetCategoryTypeCode) {
        this.budgetCategoryTypeCode = budgetCategoryTypeCode;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getBudgetCategoryTypeDescription() {
        return budgetCategoryTypeDescription;
    }
    public void setBudgetCategoryTypeDescription(String budgetCategoryTypeDescription) {
        this.budgetCategoryTypeDescription = budgetCategoryTypeDescription;
    }

}
