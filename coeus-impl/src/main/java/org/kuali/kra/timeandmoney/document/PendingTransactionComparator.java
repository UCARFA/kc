/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.document;

import java.util.Comparator;
import org.kuali.kra.timeandmoney.transactions.PendingTransaction;

public class PendingTransactionComparator implements Comparator<PendingTransaction> {

    @Override
    public int compare(PendingTransaction arg0, PendingTransaction arg1) {
        // transactions ids are not generated until a save happens so there are going
        // to be null values in them.
        if (arg0.getTransactionId() == null && arg1.getTransactionId() == null){
            return 0;
        } else if (arg0.getTransactionId() != null && arg1.getTransactionId() != null){
            return arg0.getTransactionId().compareTo(arg1.getTransactionId());
        } else if (arg0.getTransactionId() == null) {
            return 1;
        } else {
            return -1;
        }
    }
}
