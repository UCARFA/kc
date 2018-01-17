/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.controller.rest;


import org.kuali.coeus.sys.framework.controller.rest.RestBeanWrapperFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.beans.PropertyEditor;
import java.util.Map;

@Component("restBeanWrapperFactory")
public class RestBeanWrapperFactoryImpl implements RestBeanWrapperFactory {

    @Resource(name="restPropertyEditors")
    private Map<Class<?>, ? extends PropertyEditor> restPropertyEditors;

    @Override
    public BeanWrapper newInstance(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("object to wrap is null");
        }
        final BeanWrapper wrapper;
        if (o instanceof Class) {
            wrapper = new BeanWrapperImpl((Class<?>) o);
        } else {
            wrapper = new BeanWrapperImpl(o);
        }

        restPropertyEditors.forEach(wrapper::registerCustomEditor);
        wrapper.setAutoGrowNestedPaths(true);

        return wrapper;
    }

    public Map<Class<?>, ? extends PropertyEditor> getRestPropertyEditors() {
        return restPropertyEditors;
    }

    public void setRestPropertyEditors(Map<Class<?>, ? extends PropertyEditor> restPropertyEditors) {
        this.restPropertyEditors = restPropertyEditors;
    }
}
