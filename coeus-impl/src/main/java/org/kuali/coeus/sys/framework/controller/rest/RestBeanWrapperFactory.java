/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.controller.rest;


import org.springframework.beans.BeanWrapper;

public interface RestBeanWrapperFactory {

    /**
     * Creates a bean wrapper for an object and configuring the wrapper with converters and
     * enabling nested property support for our rest framework.
     * @param o the object. cannot be null
     * @return a bean wrapper
     * @throws IllegalArgumentException if o is null
     */
    BeanWrapper newInstance(Object o);
}
