/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.notification;

import org.kuali.kra.award.home.Award;

import java.util.Map;

public class AwardNoticeNotificationRenderer extends AwardNotificationRenderer {

    private static final long serialVersionUID = -2831418548566311094L;

    private static final String DOCHANDLER_APP_URL_PROP = "application.url";

    private static final String AWARD_NOTICE_ID = "{AWARD_NOTICE_ID}";

    protected Long awardNoticeId;

    public AwardNoticeNotificationRenderer(Long awardNoticeId, Award award) {
    	super(award);
        this.awardNoticeId = awardNoticeId;
    }

    @Override
    public Map<String,String> getDefaultReplacementParameters() {
        Map<String,String> replacementParams = super.getDefaultReplacementParameters();
        replacementParams.put(AWARD_NOTICE_ID, awardNoticeId.toString());

        return replacementParams;
    }

    // Overriding this method since NotificationRendererBase doesn't form the URL correctly
    protected String getDocumentLocation() {
        String appUrl = getKualiConfigurationService().getPropertyValueAsString(DOCHANDLER_APP_URL_PROP);
        if (appUrl == null) {
            // default is to back up URL before KEN (relative to base at this server)
           return "..";
        } else {
            return appUrl;
        }
    }
}
