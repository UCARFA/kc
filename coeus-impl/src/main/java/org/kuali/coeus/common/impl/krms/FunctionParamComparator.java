/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.krms;

import org.kuali.rice.krms.api.repository.function.FunctionParameterDefinition;

import java.util.Comparator;


public class FunctionParamComparator implements Comparator<FunctionParameterDefinition> {
    @Override
    public int compare(FunctionParameterDefinition param1, FunctionParameterDefinition param2) {
        return param1.getSequenceNumber().compareTo(param2.getSequenceNumber());
    }
}
