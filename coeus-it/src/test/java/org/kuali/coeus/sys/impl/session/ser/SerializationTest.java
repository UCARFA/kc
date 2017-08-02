package org.kuali.coeus.sys.impl.session.ser;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.propdev.impl.budget.core.ProposalBudgetForm;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocumentForm;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.uif.view.ViewModel;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;


import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SerializationTest extends KcIntegrationTestBase {

    private static final List<String> BROKEN_VIEWS = Stream.of(
            ProposalBudgetForm.class.getName(),
            ProposalDevelopmentDocumentForm.class.getName()
    ).collect(Collectors.toList());


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
                                //if no value is set then set it.  Since Object type is generic and unknown just give it a placeholder
                                final Object newValue = descriptor.getPropertyType().equals(Object.class) ? SerPlaceHolder.INSTANCE : descriptor.getPropertyType().newInstance();
                                PropertyUtils.setProperty(view, name, newValue);
                            }
                        } catch (IllegalAccessException|InvocationTargetException|NoSuchMethodException|InstantiationException e) {
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
                && !metadataReader.getClassMetadata().isAbstract()
                && !BROKEN_VIEWS.contains(metadataReader.getClassMetadata().getClassName());

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
