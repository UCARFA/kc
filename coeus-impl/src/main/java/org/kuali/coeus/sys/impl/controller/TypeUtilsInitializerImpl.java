/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.controller;

import org.kuali.coeus.sys.api.model.ScaleThreeDecimal;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.controller.TypeUtilsInitializer;
import org.kuali.rice.core.api.util.type.TypeUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("typeUtilsInitializer")
public class TypeUtilsInitializerImpl implements TypeUtilsInitializer {

    @Override
    @PostConstruct
    public void addToTypeUtils() {
        TypeUtils.addToDecimalType(ScaleThreeDecimal.class);
        TypeUtils.addToDecimalType(ScaleTwoDecimal.class);
    }
}
