/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.noteattachment;

import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentTypeBase;

/**
 * This class represents the Protocol Attachment Type.
 */
public class IacucProtocolAttachmentType extends ProtocolAttachmentTypeBase {

    private static final long serialVersionUID = 2053606476193782286L;


    /**
     * empty ctor to satisfy JavaBean convention.
     */
    public IacucProtocolAttachmentType() {
        super();
    }

    /**
     * Convenience ctor to set the relevant properties of this class.
     * 
     * <p>
     * This ctor does not validate any of the properties.
     * </p>
     * 
     * @param code the code.
     * @param description the description.
     */
    public IacucProtocolAttachmentType(String code, String description) {
        super(code, description);
    }

}
