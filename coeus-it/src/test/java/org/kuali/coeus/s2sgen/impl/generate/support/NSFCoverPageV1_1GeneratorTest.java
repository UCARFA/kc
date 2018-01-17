/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.s2sgen.impl.generate.support;

public class NSFCoverPageV1_1GeneratorTest extends NSFCoverPageLegacyBaseGeneratorTest {

    private static final String NAMESPACE = "http://apply.grants.gov/forms/NSF_CoverPage-V1.1";
    private static final String FORM_NAME = "NSF_CoverPage-V1.1";

    @Override
    protected String getFormName() {
        return FORM_NAME;
    }

    @Override
    protected String getNamespace() {
        return NAMESPACE;
    }

    @Override
    protected String getFormGeneratorName() {
        return NSFCoverPageV1_1Generator.class.getSimpleName();
    }
}
