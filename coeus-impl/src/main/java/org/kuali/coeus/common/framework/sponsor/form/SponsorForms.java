/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.sponsor.form;

import org.kuali.coeus.common.framework.sponsor.Sponsor;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import java.util.ArrayList;
import java.util.List;

public class SponsorForms extends KcPersistableBusinessObjectBase {

    private Long sponsorFormId;

    private String packageName;

    private Integer packageNumber;

    private String sponsorCode;

    private String sponsorHierarchyName;

    private Sponsor sponsor;

    private List<SponsorFormTemplateList> sponsorFormTemplates;

    public SponsorForms() {
        super();
        sponsorFormTemplates = new ArrayList<SponsorFormTemplateList>();
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Integer getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(Integer packageNumber) {
        this.packageNumber = packageNumber;
    }

    public String getSponsorCode() {
        return sponsorCode;
    }

    public void setSponsorCode(String sponsorCode) {
        this.sponsorCode = sponsorCode;
    }

    public final Sponsor getSponsor() {
        return sponsor;
    }

    public final void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public final List<SponsorFormTemplateList> getSponsorFormTemplates() {
        return sponsorFormTemplates;
    }

    public final void setSponsorFormTemplates(List<SponsorFormTemplateList> sponsorFormTemplates) {
        this.sponsorFormTemplates = sponsorFormTemplates;
    }

    public Long getSponsorFormId() {
        return sponsorFormId;
    }

    public void setSponsorFormId(Long sponsorFormId) {
        this.sponsorFormId = sponsorFormId;
    }

    public String getSponsorHierarchyName() {
        return sponsorHierarchyName;
    }

    public void setSponsorHierarchyName(String sponsorHierarchyName) {
        this.sponsorHierarchyName = sponsorHierarchyName;
    }
}
