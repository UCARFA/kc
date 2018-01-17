/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.noteattachment;

import org.kuali.rice.kns.service.DictionaryValidationService;
import org.kuali.rice.kns.service.KNSServiceLocator;

/**
 * This class contains methods to "help" in validating {@link ProtocolNotepadBase ProtocolNotepadBase}.
 */
class ProtocolNotepadRuleHelper {

    private final DictionaryValidationService validationService;
    
    private String propertyPrefix;
    
    /**
     * Creates helper deferring the setting of the prefix to later.
     */
    ProtocolNotepadRuleHelper() {
        this(KNSServiceLocator.getKNSDictionaryValidationService());
    }
    
    /**
     * Creates helper using prefix provided.
     *  
     * @param aPropertyPrefix the prefix (ex: notesAttachmentsHelper.newProtocolNotepad)
     * @throws IllegalArgumentException if the propertyPrefix is null
     */
    ProtocolNotepadRuleHelper(final String aPropertyPrefix) {
        this();
        this.resetPropertyPrefix(aPropertyPrefix);
    }
    
    /**
     * Creates helper deferring the setting of the prefix to later and setting used services.
     * @throws IllegalArgumentException if the validationService is null
     */
    ProtocolNotepadRuleHelper(final DictionaryValidationService validationService) {
        if (validationService == null) {
            throw new IllegalArgumentException("the validationService is null");
        }
        
        this.validationService = validationService;
    }
    
    /**
     * Resets the property prefix.
     * @param aPropertyPrefix the prefix (ex: notesAttachmentsHelper.newAttachmentProtocol)
     * @throws IllegalArgumentException if the propertyPrefix is null
     */
    void resetPropertyPrefix(final String aPropertyPrefix) {
        if (aPropertyPrefix == null) {
            throw new IllegalArgumentException("propertyPrefix is null");
        }
        
        this.propertyPrefix = aPropertyPrefix;
    }
    
    /**
     * Validates the attachment's primitive fields (non reference fields). Creates a hard error.
     * 
     * @return true if valid.
     */
    boolean validPrimitiveFields(final ProtocolNotepadBase notepad) {
        return this.validationService.isBusinessObjectValid(notepad, this.propertyPrefix);
    }
}
