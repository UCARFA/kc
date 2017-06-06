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
