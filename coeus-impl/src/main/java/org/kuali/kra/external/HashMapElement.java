/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external;

import java.io.Serializable;

/**
 * This class was created because the services were having trouble 
 * receiving HashMaps using SOAP. So a list of HashMapElement objects
 *  are sent across instead.
 */
public class HashMapElement implements Serializable {


    private static final long serialVersionUID = 416236787015578068L;
    private String key;
    private String value;
    
   
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    } 
    
    
}
