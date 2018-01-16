/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s.nih;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class NihValidationMapping extends KcPersistableBusinessObjectBase {
    public static final String A_TAG = "a";
    public static final String HREF = "href";
    public static final String TARGET = "target";
    private Long id;
    private String ruleNumber;
    private String customMessage;
    private boolean forceError = Boolean.FALSE;
    private boolean appendToOriginal = Boolean.TRUE;
    private String pageId;
    private String sectionId;
    private boolean active = Boolean.TRUE;

    public String getRuleNumber() {
        return ruleNumber;
    }

    public void setRuleNumber(String ruleNumber) {
        this.ruleNumber = ruleNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    public boolean getForceError() {
        return forceError;
    }

    public void setForceError(boolean forceError) {
        this.forceError = forceError;
    }

    public boolean getAppendToOriginal() {
        return appendToOriginal;
    }

    public void setAppendToOriginal(boolean appendToOriginal) {
        this.appendToOriginal = appendToOriginal;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    protected void prePersist() {
        super.prePersist();
        cleanCustomMessage();
    }

    @Override
    protected void preUpdate() {
        super.preUpdate();
        cleanCustomMessage();
    }

    public void cleanCustomMessage() {
        final Whitelist basic = Whitelist.basic();
        basic.addAttributes(A_TAG, HREF, TARGET);
        setCustomMessage(Jsoup.clean(customMessage, basic));
    }
}
