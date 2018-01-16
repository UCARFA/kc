/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.infrastructure;


/**
 * A constants class containing constants relating to class properties.
 * 
 * @see org.kuali.kra.infrastructure.Constants
 * @see org.kuali.kra.infrastructure.KeyConstants
 */
public class PropertyConstants {

    public enum DOCUMENT {
        TYPE_NAME("documentTypeName");

        
        private String value;
        
        private DOCUMENT(String val) {
            value = val;
        }
        
        /**
         * 
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return value;
        }
    }
    
    /**
     * Property Constants relating to <code>{@link org.kuali.core.bo.Parameter}</code>
     * 
     * @see org.kuali.core.bo.Parameter
     */
    public enum PARAMETER {
        DETAIL_TYPE_CODE("parameterDetailTypeCode"),
        NAME("parameterName"),
        NAMESPACE_CODE("parameterNamespaceCode");

        
        private String value;
        
        private PARAMETER(String val) {
            value = val;
        }
        
        /**
         * 
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return value;
        }
    }
}
