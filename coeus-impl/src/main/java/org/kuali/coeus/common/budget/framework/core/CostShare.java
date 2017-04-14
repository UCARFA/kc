package org.kuali.coeus.common.budget.framework.core;

import org.kuali.kra.bo.CostShareType;

public interface CostShare {
    String getSourceAccount();
    Integer getCostShareTypeCode();
    CostShareType getCostShareType();

}
