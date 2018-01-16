/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.customercreation;

public class CustomerConstants {

    public static class CustomerOptions {
        public enum Types {
            EXISTING("Y", "Use Existing Customer"), NEW("N", "Create New Customer"), NO("NA", "No Customer");
            private String code;
            private String name;
            Types(String code, String name) {
                this.code = code;
                this.name = name;
            }
            public String getCode() {
                return code;
            }
            public String getName() {
                return name;
            }
            public static String get(String code) {
                for(Types type : Types.values()) {
                    if(type.getCode().equals(code)){
                        return type.getName();
                    }
                }
                return null;
            }
        }
    }

}
