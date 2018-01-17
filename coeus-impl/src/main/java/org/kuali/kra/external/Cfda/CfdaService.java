/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.Cfda;

import org.kuali.kra.award.home.CFDA;

import java.io.IOException;
import java.util.SortedMap;


public interface CfdaService {

    public CfdaUpdateResults updateCfda() throws IOException;
    
    public SortedMap<String, CFDA> retrieveGovCodes() throws IOException;
}
