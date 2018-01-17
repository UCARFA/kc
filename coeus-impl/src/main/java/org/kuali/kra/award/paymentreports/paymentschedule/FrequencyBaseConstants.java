/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.paymentschedule;


public enum FrequencyBaseConstants {
    AWARD_EXECUTION_DATE("1"),AWARD_EFFECTIVE_DATE("2"),AWARD_EXPIRATION_DATE_OF_OBLIGATION("3"),FINAL_EXPIRATION_DATE("4")
        ,AWARD_EFFECTIVE_DATE_OF_OBLIGATION("5");
    
    String frequencyBase;
    
    FrequencyBaseConstants(String frequencyBase){
        this.frequencyBase = frequencyBase;
    }
    
    public String getfrequencyBase(){
        return frequencyBase;
    }
    

}
