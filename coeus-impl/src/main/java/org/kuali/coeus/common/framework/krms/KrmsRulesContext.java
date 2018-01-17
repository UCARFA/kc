/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.krms;

import org.kuali.rice.krms.api.engine.Facts;

import java.util.Map;

public interface KrmsRulesContext {
    
    void populateContextQualifiers(Map<String, String> qualifiers);
    
    void addFacts(Facts.Builder factsBuilder);
    
    void populateAgendaQualifiers(Map<String, String> qualifiers);
    
}
