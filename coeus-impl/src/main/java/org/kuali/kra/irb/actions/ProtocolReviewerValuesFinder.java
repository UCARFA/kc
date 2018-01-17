/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.actions.submit.ProtocolReviewer;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionStatus;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.document.Document;

import java.util.ArrayList;
import java.util.List;


public class ProtocolReviewerValuesFinder extends IrbActionsKeyValuesBase {
    

    private static final long serialVersionUID = 6339476452241934050L;

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        
        Protocol protocol = getProtocol();
        if (protocol != null) {
            ProtocolSubmission submission = getCurrentSubmission(protocol);
            if (submission != null) {
                List<ProtocolReviewer> reviewers = (List)submission.getProtocolReviewers();
                for (ProtocolReviewer reviewer : reviewers) {
                    keyValues.add(new ConcreteKeyValue(reviewer.getProtocolReviewerId().toString(), reviewer.getFullName()));
                }
            }
        }
        
        return keyValues;
    }

    @SuppressWarnings("unchecked")
    private ProtocolSubmission getCurrentSubmission(Protocol protocol) {
        List<ProtocolSubmission> protocolSubmissions = (List)protocol.getProtocolSubmissions();
        for (ProtocolSubmission submission : protocolSubmissions) {
            if (StringUtils.equals(submission.getSubmissionStatusCode(), ProtocolSubmissionStatus.IN_AGENDA) ||
                StringUtils.equals(submission.getSubmissionStatusCode(), ProtocolSubmissionStatus.SUBMITTED_TO_COMMITTEE)) {
                return submission;
            }
        }
        return null;
    }

    private Protocol getProtocol() {
        Document document = getDocument();
        if (document instanceof ProtocolDocument) {
            return ((ProtocolDocument) document).getProtocol();
        }
        return null;
    }
}
