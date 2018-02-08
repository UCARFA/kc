/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.s2sgen.impl.generate.support;

public class RRSF424V1_2GeneratorTest extends RRSF424BaseGeneratorTest {

    @Override
    protected String getFormGeneratorName() {
        return RRSF424V1_2Generator.class.getSimpleName();
    }

    @Override
    String getFormName() {
        return "RR_SF424_1_2-V1.2";
    }

    @Override
    String getNamespace() {
        return "http://apply.grants.gov/forms/RR_SF424_1_2-V1.2";
    }
}
