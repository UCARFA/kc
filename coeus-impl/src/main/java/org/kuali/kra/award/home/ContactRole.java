/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home;

import org.kuali.rice.krad.bo.BusinessObject;


/**
 * This class defines an Award contact role
 */
public interface ContactRole extends BusinessObject {
    String PI_CODE = "PI";
    String COI_CODE = "COI";
    String KEY_PERSON_CODE = "KP";
    String MULTI_PI_CODE = "MPI";
        
    String getRoleCode();
    String getRoleDescription();
}
