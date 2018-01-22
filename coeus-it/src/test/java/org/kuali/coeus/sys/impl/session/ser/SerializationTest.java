/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.sys.impl.session.ser;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Assert;
import org.junit.Test;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.uif.view.ViewModel;
import org.mockito.Mockito;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Stream;

public class SerializationTest extends KcIntegrationTestBase {

    /**
     * This test finds all KRAD views (forms) on the classpath, it executes all getters, call all setters & init methods (hopefully triggering any lazy loading)
     * and then attempts to serialize.
     */
    @Test
    public void test_empty_krad_views() {
        final Map<Class<? extends ViewModel>, SerializableUtils.SerInfo> failed = new HashMap<>();

        getViewsToTest().forEach(viewClass -> {
            try {
                final ViewModel view = viewClass.newInstance();

                Stream.of(PropertyUtils.getPropertyDescriptors(view)).forEach(descriptor -> {
                    final String name = descriptor.getName();
                    if (descriptor.getReadMethod() != null) {
                        try {
                            //this forces lazy loading
                            final Object o = PropertyUtils.getProperty(view, name);
                            if (o == null){
                                final Object newValue;
                                if (descriptor.getPropertyType().equals(Object.class)) {
                                    newValue = SerPlaceHolder.INSTANCE;
                                } else if (descriptor.getPropertyType().isInterface() && !descriptor.getPropertyType().isArray()) {
                                    if ((Collection.class.isAssignableFrom(descriptor.getPropertyType()) || List.class.isAssignableFrom(descriptor.getPropertyType())) && !Set.class.isAssignableFrom(descriptor.getPropertyType())) {
                                        final List<Object> list = new ArrayList<>();
                                        final Type returnType = descriptor.getReadMethod().getGenericReturnType();
                                        if (returnType instanceof ParameterizedType) {
                                            String clazz = ((ParameterizedType) returnType).getActualTypeArguments()[0].getTypeName();
                                            list.add(Class.forName(clazz).newInstance());
                                        }
                                        newValue = list;
                                    } else if (Set.class.isAssignableFrom(descriptor.getPropertyType())) {
                                        final List<Object> set = new ArrayList<>();
                                        final Type returnType = descriptor.getReadMethod().getGenericReturnType();
                                        if (returnType instanceof ParameterizedType) {
                                            String clazz = ((ParameterizedType) returnType).getActualTypeArguments()[0].getTypeName();
                                            set.add(Class.forName(clazz).newInstance());
                                        }
                                        newValue = set;
                                    } else if (Map.class.isAssignableFrom(descriptor.getPropertyType())) {
                                        final Map<Object, Object> map = new HashMap<>();
                                        final Type returnType = descriptor.getReadMethod().getGenericReturnType();
                                        if (returnType instanceof ParameterizedType) {
                                            String keyClazz = ((ParameterizedType) returnType).getActualTypeArguments()[0].getTypeName();
                                            String valueClazz = ((ParameterizedType) returnType).getActualTypeArguments()[1].getTypeName();
                                            map.put(Class.forName(keyClazz).newInstance(), Class.forName(valueClazz).equals(Object.class) ? SerPlaceHolder.INSTANCE : Class.forName(valueClazz).newInstance());
                                        }
                                        newValue = map;
                                    } else {
                                        newValue = Mockito.mock(descriptor.getPropertyType(), Mockito.withSettings().serializable());
                                    }
                                } else if (Modifier.isAbstract(descriptor.getPropertyType().getModifiers()) && !descriptor.getPropertyType().isArray()) {
                                    newValue = Mockito.mock(descriptor.getPropertyType(), Mockito.withSettings().serializable());
                                } else if (descriptor.getPropertyType().isArray()) {
                                    final Object array = Array.newInstance(descriptor.getPropertyType().getComponentType(), 1);
                                    Array.set(array, 0, descriptor.getPropertyType().getComponentType().newInstance());
                                    newValue = array;
                                } else if (descriptor.getPropertyType().isEnum()) {
                                    newValue = descriptor.getPropertyType().getEnumConstants()[0];
                                } else {
                                    newValue = descriptor.getPropertyType().newInstance();
                                }

                                PropertyUtils.setProperty(view, name, newValue);
                            }
                        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException | ClassNotFoundException e) {
                            //ignore if fails
                        }
                    }
                });

                try {
                    final Method initialize = viewClass.getDeclaredMethod("initialize");
                    initialize.invoke(view);
                } catch (NoSuchMethodException e) {
                    //ignore.  not all Views have initialize()
                }

                final SerializableUtils.SerInfo serInfo = SerializableUtils.getSerializationInfo(view);
                if (!serInfo.isSerializable()) {
                    failed.put(viewClass, serInfo);
                }
            } catch (InstantiationException|IllegalAccessException|InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });

        Assert.assertTrue("Serialization failed for: " + failed, failed.isEmpty());
    }

    private Stream<Class<? extends ViewModel>> getViewsToTest() {
        final ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);

        final TypeFilter testableFilter = (metadataReader, metadataReaderFactory) ->
                new AssignableTypeFilter(ViewModel.class).match(metadataReader, metadataReaderFactory)
                        && !metadataReader.getClassMetadata().isAbstract();

        provider.addIncludeFilter(testableFilter);
        provider.setResourceLoader(new PathMatchingResourcePatternResolver(this.getClass().getClassLoader()));
        final Set<BeanDefinition> views = provider.findCandidateComponents("org.kuali");
        return views.stream().map(view -> {
            try {
                @SuppressWarnings("unchecked")
                final Class<? extends ViewModel> clazz = (Class<? extends ViewModel> ) Class.forName(view.getBeanClassName());
                return clazz;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static class SerPlaceHolder implements Serializable {
        private static final Serializable INSTANCE = new SerPlaceHolder();
    }
}
