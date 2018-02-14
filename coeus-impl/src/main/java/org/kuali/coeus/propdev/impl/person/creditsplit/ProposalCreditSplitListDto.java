/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.creditsplit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProposalCreditSplitListDto implements Serializable {
    private String description;
    private String lineType;
    private List<CreditSplit> creditSplits;

    public ProposalCreditSplitListDto() {
        super();
        creditSplits = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CreditSplit> getCreditSplits() {
        return creditSplits;
    }

    public void setCreditSplits(List<CreditSplit> creditSplits) {
        this.creditSplits = creditSplits;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }
}
