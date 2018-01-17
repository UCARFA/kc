/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.rice.krad.uif.element;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.coeus.org.kuali.rice.krad.uif.element.ValuesFinderDisplayInputField;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.keyvalues.KeyValuesBase;
import org.kuali.rice.krad.keyvalues.KeyValuesFinder;
import org.kuali.rice.krad.uif.component.BindingInfo;
import org.kuali.rice.krad.uif.lifecycle.ViewLifecycle;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@PrepareForTest(ViewLifecycle.class)
@RunWith(PowerMockRunner.class)
public class ValuesFinderDisplayInputFieldTest {

    private static final String BINDING_PATH = "value";
    private static final String KEY_SEPARATOR = ",";
    private static final String NEW_SEPARATOR = ";";
    private static final ConcreteKeyValue SELECTED = new ConcreteKeyValue("selected", "This option is selected");
    private static final ConcreteKeyValue ALSO_SELECTED = new ConcreteKeyValue("also", "I also want this one");

    private BindingInfo bindingInfo;
    private KeyValuesFinder keyValuesFinder = new KeyValuesBase() {
        @Override
        public List<KeyValue> getKeyValues() {
            return Arrays.asList(
                    new ConcreteKeyValue("test", "This is a test"),
                    new ConcreteKeyValue("second", "This is the second option"),
                    SELECTED,
                    new ConcreteKeyValue("fourth", "The fourth option is this one"),
                    ALSO_SELECTED
            );
        }
    };
    private ValuesFinderDisplayInputField valuesFinderDisplayInputField;

    @Before
    public void setup() {
        bindingInfo = new BindingInfo();
        bindingInfo.setBindingPath(BINDING_PATH);
        keyValuesFinder = new KeyValuesBase() {
            @Override
            public List<KeyValue> getKeyValues() {
                return Arrays.asList(
                        new ConcreteKeyValue("test", "This is a test"),
                        new ConcreteKeyValue("second", "This is the second option"),
                        SELECTED,
                        new ConcreteKeyValue("fourth", "The fourth option is this one"),
                        ALSO_SELECTED
                );
            }
        };
        valuesFinderDisplayInputField = new ValuesFinderDisplayInputField();
        valuesFinderDisplayInputField.setBindingInfo(bindingInfo);

        PowerMockito.mockStatic(ViewLifecycle.class);
    }

    @Test
    public void test_fieldDisplaysDescriptionsFromValuesFinder() {
        String selectedValues = String.format("%s%s%s", SELECTED.getKey(), KEY_SEPARATOR, ALSO_SELECTED.getKey());
        String expectedDisplay = String.format("%s%s%s", SELECTED.getValue(), NEW_SEPARATOR, ALSO_SELECTED.getValue());

        valuesFinderDisplayInputField.setValuesSeparator(NEW_SEPARATOR);
        valuesFinderDisplayInputField.setOptionsFinder(keyValuesFinder);
        valuesFinderDisplayInputField.performFinalize(new TestValueClass(selectedValues), null);

        assertEquals(expectedDisplay, valuesFinderDisplayInputField.getReadOnlyDisplayReplacement());
    }

    private class TestValueClass {

        private String value;

        private TestValueClass(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
