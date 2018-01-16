/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.maintenance;

import org.junit.After;
import org.junit.Test;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.common.proposal.framework.mail.MailType;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;
/**
 * This class tests KraMaintainableImpl.
 */
public class KraMaintainableImplTest extends KcIntegrationTestBase {

    @After
    public void tearDown() throws Exception {
        GlobalVariables.setUserSession(null);
    }

    @Test public void testPrepareForSaveInsertQuickstart() throws Exception {
        GlobalVariables.setUserSession(new UserSession("quickstart"));

        KcPersistableBusinessObjectBase kraPersistableBusinessObjectBase = new MailType();
        KraMaintainableImpl kraMaintainableImpl = new KraMaintainableImpl();
        kraMaintainableImpl.setBusinessObject(kraPersistableBusinessObjectBase);

        assertNull(kraPersistableBusinessObjectBase.getUpdateTimestamp());
        assertNull(kraPersistableBusinessObjectBase.getUpdateUser());

        kraMaintainableImpl.prepareForSave();

        GlobalVariables.setUserSession(new UserSession("jtester"));
        kraPersistableBusinessObjectBase.beforeInsert(null);

        updateAsserts("quickstart", kraPersistableBusinessObjectBase);
    }

    @Test public void testPrepareForSaveUpdateQuickstart() throws Exception {
        GlobalVariables.setUserSession(new UserSession("quickstart"));

        KcPersistableBusinessObjectBase kraPersistableBusinessObjectBase = new MailType();
        KraMaintainableImpl kraMaintainableImpl = new KraMaintainableImpl();
        kraMaintainableImpl.setBusinessObject(kraPersistableBusinessObjectBase);

        assertNull(kraPersistableBusinessObjectBase.getUpdateTimestamp());
        assertNull(kraPersistableBusinessObjectBase.getUpdateUser());

        kraMaintainableImpl.prepareForSave();

        GlobalVariables.setUserSession(new UserSession("jtester"));
        kraPersistableBusinessObjectBase.beforeUpdate(null);

        updateAsserts("quickstart", kraPersistableBusinessObjectBase);
    }

    @Test public void testPrepareForSaveInsertJtester() throws Exception {
        GlobalVariables.setUserSession(new UserSession("jtester"));

        KcPersistableBusinessObjectBase kraPersistableBusinessObjectBase = new MailType();
        KraMaintainableImpl kraMaintainableImpl = new KraMaintainableImpl();
        kraMaintainableImpl.setBusinessObject(kraPersistableBusinessObjectBase);

        assertNull(kraPersistableBusinessObjectBase.getUpdateTimestamp());
        assertNull(kraPersistableBusinessObjectBase.getUpdateUser());

        kraMaintainableImpl.prepareForSave();

        GlobalVariables.setUserSession(new UserSession("quickstart"));
        kraPersistableBusinessObjectBase.beforeInsert(null);

        updateAsserts("jtester", kraPersistableBusinessObjectBase);
    }

    @Test public void testPrepareForSaveUpdateJtester() throws Exception {
        GlobalVariables.setUserSession(new UserSession("jtester"));

        KcPersistableBusinessObjectBase kraPersistableBusinessObjectBase = new MailType();
        KraMaintainableImpl kraMaintainableImpl = new KraMaintainableImpl();
        kraMaintainableImpl.setBusinessObject(kraPersistableBusinessObjectBase);

        assertNull(kraPersistableBusinessObjectBase.getUpdateTimestamp());
        assertNull(kraPersistableBusinessObjectBase.getUpdateUser());

        kraMaintainableImpl.prepareForSave();

        GlobalVariables.setUserSession(new UserSession("quickstart"));
        kraPersistableBusinessObjectBase.beforeUpdate(null);

        updateAsserts("jtester", kraPersistableBusinessObjectBase);
    }

    private void updateAsserts(String udpateUser, KcPersistableBusinessObjectBase kraPersistableBusinessObjectBase) {
        assertEquals(udpateUser, kraPersistableBusinessObjectBase.getUpdateUser());
        Timestamp updateTimestamp = kraPersistableBusinessObjectBase.getUpdateTimestamp();
        assertNotNull(kraPersistableBusinessObjectBase.getUpdateTimestamp());

        Date currentDate = new Date(System.currentTimeMillis());
        long diff = updateTimestamp.getTime() - currentDate.getTime();

        assertTrue("Should be less than one second difference between dates", diff < 1000);
    }

}
