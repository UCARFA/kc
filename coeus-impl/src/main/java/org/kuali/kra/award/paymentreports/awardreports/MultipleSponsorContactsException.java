/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.awardreports;

/**
 * 
 * This class throws a MultipleSponsorContactsException in case more than one sponsor contacts is present 
 */
public class MultipleSponsorContactsException extends RuntimeException {


    private static final long serialVersionUID = -315196634642722965L;

    /**
     * 
     * Constructs a MultipleSponsorContactsException.java.
     * @param numberOfRecipients
     */
    public MultipleSponsorContactsException(int numberOfRecipients) {
        super("There are " + numberOfRecipients + " number of Sponsor Contacts. There should be only 1. ");
    }
}
