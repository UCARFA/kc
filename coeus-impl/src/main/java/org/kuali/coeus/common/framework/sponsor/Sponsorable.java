/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.sponsor;

import org.kuali.rice.krad.bo.PersistableBusinessObject;


public interface Sponsorable extends PersistableBusinessObject {

    String getSponsorCode();

    void setSponsorCode(String sponsorCode);

    String getPrimeSponsorCode();

}
