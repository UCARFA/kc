/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.kuali.coeus.sys.framework.keyvalue.FormViewAwareUifKeyValuesFinderBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.AwardForm;
import org.kuali.kra.award.lookup.AwardTransactionLookupService;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Gets all sequence numbers for the current award id.  See
 * the method <code>getKeyValues()</code> for a full description.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class AwardTransactionValuesFinder extends FormViewAwareUifKeyValuesFinderBase {
    
    private AwardTransactionLookupService transactionLookupService;
    
    /**
     * Grabs the current award from the current form and loops through all
     * AwardAmountInfos and puts the transaction id in both for key and value for
     * each pair.
     * 
     * @return the list of &lt;key, value&gt; pairs of the current award tranaction ids
     * @see org.kuali.rice.krad.keyvalues.KeyValuesFinder#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {
        AwardForm form = getAwardForm();
        
        List<KeyValue> keyValues = new ArrayList<>();
        Integer usableSequence = form.getAwardPrintChangeReport().getAwardVersion();
        if (usableSequence == null) {
            usableSequence = form.getAwardDocument().getAward().getSequenceNumber();
        }
        Map<Integer, String> transactionValues = getTransactionLookupService().getApplicableTransactionIds(form.getAwardDocument().getAward().getAwardNumber(),
                usableSequence);

        keyValues.addAll(transactionValues.entrySet().stream()
                .map(entry -> new ConcreteKeyValue(entry.getKey().toString(), entry.getValue()))
                .collect(Collectors.toList()));

        return keyValues;
    }
    
    
    /**
     * Get the Award Document for the current session.  The
     * document is within the current form.
     * 
     * @return the current document or null if not found
     */
    private AwardForm getAwardForm() {
        return (AwardForm) getFormOrView();
    }

    public AwardTransactionLookupService getTransactionLookupService() {
        if (transactionLookupService == null) {
            transactionLookupService = KcServiceLocator.getService(AwardTransactionLookupService.class);
        }

        return transactionLookupService;
    }

    public void setTransactionLookupService(AwardTransactionLookupService transactionLookupService) {
        this.transactionLookupService = transactionLookupService;
    }
}
