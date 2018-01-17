/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.persistence;

import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.persistence.config.DescriptorCustomizer;
import org.eclipse.persistence.descriptors.ClassDescriptor;

import java.util.Collection;

/**
 * In eclipse link, you are only allowed a single customizer annotation on an entity.  This customizer
 * implementation makes it possible to aggregate customizers so that each customization
 * can be in a separate class.
 *
 * For example:
 * {@code
 * @Customizer(DepartmentCustomizer.class)
 * class Department {
 *     List<Employee> employees;
 *     List<Rooms> rooms;
 * }
 *
 * class EmployeeCustomizer extends DescriptorCustomizer { ... }
 * class RoomCustomizer extends DescriptorCustomizer { ... }
 *
 * class DepartmentCustomizer extends CompositeDescriptorCustomizer {
 *      @Override
 *      protected Collection<DescriptorCustomizer> getCustomizers() {
 *          Collection<DescriptorCustomizer> customizers = new ArrayList<DescriptorCustomizer>();
 *          customizers.add(new EmployeeCustomizer());
 *          customizers.add(new RoomCustomizer());
 *          return customizers;
 *      }
 * }
 * }
 */
public abstract class CompositeDescriptorCustomizer implements DescriptorCustomizer {

    protected abstract Collection<DescriptorCustomizer> getCustomizers();

    @Override
    public final void customize(ClassDescriptor descriptor) throws Exception {
        final Collection<DescriptorCustomizer> customizers = getCustomizers();
        if (CollectionUtils.isEmpty(customizers)) {
            throw new IllegalStateException("getCustomizers cannot return an empty Collection");
        }

        for (DescriptorCustomizer customizer : customizers) {
            if (customizer == null) {
                throw new IllegalStateException("customizer is null");
            }

            customizer.customize(descriptor);
        }
    }
}
