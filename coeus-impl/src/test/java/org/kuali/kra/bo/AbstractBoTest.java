/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.bo;


import org.junit.Assert;
import org.junit.Test;
import org.kuali.rice.krad.bo.PersistableBusinessObject;

public abstract class AbstractBoTest<T extends PersistableBusinessObject> {

    protected abstract Class<T> getBoClass();

    protected abstract int getAttributeCount();

    @Test
    public void testAttributesCount() throws Exception {
        Assert.assertEquals(getAttributeCount(), getBoClass().getDeclaredFields().length);
    }

    @Test
    public void testEmptyCtor() throws Exception {
        getBoClass().newInstance();
    }
}
