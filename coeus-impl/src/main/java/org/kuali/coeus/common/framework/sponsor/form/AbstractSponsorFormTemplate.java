/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.sponsor.form;


import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public abstract class AbstractSponsorFormTemplate extends KcPersistableBusinessObjectBase implements Comparable<AbstractSponsorFormTemplate> {

    private Long sponsorFormTemplateId;

    private Long sponsorFormId;

    private Integer pageNumber;

    private String pageDescription;

    private SponsorForms sponsorForms;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }

    public final SponsorForms getSponsorForms() {
        return sponsorForms;
    }

    public final void setSponsorForms(SponsorForms sponsorForms) {
        this.sponsorForms = sponsorForms;
    }

    @Override
    public int compareTo(AbstractSponsorFormTemplate abstractSponsorFormTemplate) {
        int result = getSponsorForms().getPackageNumber().compareTo(abstractSponsorFormTemplate.getSponsorForms().getPackageNumber());
        result = result != 0 ? result : getPageNumber().compareTo(abstractSponsorFormTemplate.getPageNumber());
        return result;
    }

    public Long getSponsorFormTemplateId() {
        return sponsorFormTemplateId;
    }

    public void setSponsorFormTemplateId(Long sponsorFormTemplateId) {
        this.sponsorFormTemplateId = sponsorFormTemplateId;
    }

    public Long getSponsorFormId() {
        return sponsorFormId;
    }

    public void setSponsorFormId(Long sponsorFormId) {
        this.sponsorFormId = sponsorFormId;
    }
}
