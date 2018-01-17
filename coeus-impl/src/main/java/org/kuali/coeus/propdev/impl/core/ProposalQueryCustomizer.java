/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.core;

import org.kuali.coeus.sys.framework.persistence.KcQueryCustomizerDefaultImpl;

public class ProposalQueryCustomizer extends KcQueryCustomizerDefaultImpl {
    @Override
    public void addAttribute(String name, String value) {
        super.addProposalSystemAttribute(name, value);
    }
}
