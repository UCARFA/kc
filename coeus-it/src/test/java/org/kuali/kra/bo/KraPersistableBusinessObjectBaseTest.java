/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.bo;

import org.junit.After;
import org.junit.Before;
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
 * This class tests KraPersistableBusinessObjectBase.
 */
public class KraPersistableBusinessObjectBaseTest extends KcIntegrationTestBase {

    @Before
    public void setUp() throws Exception {
        GlobalVariables.setUserSession(new UserSession("quickstart"));
    }

    @After
    public void tearDown() throws Exception {
        GlobalVariables.setUserSession(null);
    }

    @Test public void testBeforeInsertQuickstart() throws Exception {
        KcPersistableBusinessObjectBase kraPersistableBusinessObjectBase = new MailType();
        assertNull(kraPersistableBusinessObjectBase.getUpdateTimestamp());
        assertNull(kraPersistableBusinessObjectBase.getUpdateUser());
        kraPersistableBusinessObjectBase.beforeInsert(null);

        updateAsserts("quickstart", kraPersistableBusinessObjectBase);
    }

    @Test public void testBeforeUpdateQuickstart() throws Exception {
        KcPersistableBusinessObjectBase kraPersistableBusinessObjectBase = new MailType();
        assertNull(kraPersistableBusinessObjectBase.getUpdateTimestamp());
        assertNull(kraPersistableBusinessObjectBase.getUpdateUser());
        kraPersistableBusinessObjectBase.beforeUpdate(null);

        updateAsserts("quickstart", kraPersistableBusinessObjectBase);
    }

    @Test public void testBeforeInsertUser4() throws Exception {
        GlobalVariables.setUserSession(new UserSession("jtester"));

        KcPersistableBusinessObjectBase kraPersistableBusinessObjectBase = new MailType();
        assertNull(kraPersistableBusinessObjectBase.getUpdateTimestamp());
        assertNull(kraPersistableBusinessObjectBase.getUpdateUser());
        kraPersistableBusinessObjectBase.beforeInsert(null);

        updateAsserts("jtester", kraPersistableBusinessObjectBase);
    }

    @Test public void testBeforeUpdateUser4() throws Exception {
        GlobalVariables.setUserSession(new UserSession("jtester"));

        KcPersistableBusinessObjectBase kraPersistableBusinessObjectBase = new MailType();
        assertNull(kraPersistableBusinessObjectBase.getUpdateTimestamp());
        assertNull(kraPersistableBusinessObjectBase.getUpdateUser());
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
