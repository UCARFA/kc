/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.noteattachment;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.personnel.IacucProtocolPerson;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolDao;
import org.kuali.kra.protocol.noteattachment.*;
import org.kuali.kra.protocol.personnel.ProtocolPersonBase;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class IacucProtocolAttachmentServiceImpl extends ProtocolAttachmentServiceImplBase implements IacucProtocolAttachmentService {

    public IacucProtocolAttachmentServiceImpl(BusinessObjectService boService, ProtocolDao protocolDao) {
        super(boService, protocolDao);
    }

    @Override
    public Class<? extends ProtocolBase> getProtocolClassHook() {
        return IacucProtocol.class;
    }

    @Override
    public Class<? extends ProtocolAttachmentStatusBase> getProtocolAttachmentStatusClassHook() {
        return IacucProtocolAttachmentStatus.class;
    }

    @Override
    public Class<? extends ProtocolPersonBase> getProtocolPersonClassHook() {
        return IacucProtocolPerson.class;
    }

    @Override
    public Class<? extends ProtocolAttachmentTypeBase> getProtocolAttachmentTypeClassHook() {
        return IacucProtocolAttachmentType.class;
    }

    @Override
    public Class<? extends ProtocolAttachmentTypeGroupBase> getProtocolAttachmentTypeGroupClassHook() {
        return IacucProtocolAttachmentTypeGroup.class;
    }

    @Override
    public Class<? extends ProtocolAttachmentProtocolBase> getProtocolAttachmentProtocolClassHook() {
        return IacucProtocolAttachmentProtocol.class;
    }

    @Override
    public Class<? extends ProtocolAttachmentPersonnelBase> getProtocolAttachmentPersonnelClassHook() {
        return IacucProtocolAttachmentPersonnel.class;
    }

    @Override
    public Collection<ProtocolAttachmentTypeBase> getTypesForGroup(String code) {
        if (code == null) {
            throw new IllegalArgumentException("the code is null");
        }
  
        @SuppressWarnings("unchecked")
        final Collection<IacucProtocolAttachmentTypeGroup> typeGroups
            = this.boService.findMatching(IacucProtocolAttachmentTypeGroup.class, Collections.singletonMap("groupCode", code));
        if (typeGroups == null) {
          return new ArrayList<ProtocolAttachmentTypeBase>();
        }
      
        final Collection<ProtocolAttachmentTypeBase> types = new ArrayList<ProtocolAttachmentTypeBase>();
        for (final ProtocolAttachmentTypeGroupBase typeGroup : typeGroups) {
            types.add(typeGroup.getType());
        }
      
        return types;
    }

}
