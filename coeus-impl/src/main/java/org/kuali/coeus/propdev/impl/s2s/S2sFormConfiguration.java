/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.propdev.impl.s2s;


import org.kuali.coeus.propdev.api.s2s.S2sFormConfigurationContract;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;
import org.kuali.rice.krad.data.jpa.PortableSequenceGenerator;
import org.kuali.rice.krad.data.jpa.converters.BooleanYNConverter;

import javax.persistence.*;

@Entity
@Table(name = "S2S_FORM_CONFIG")
public class S2sFormConfiguration extends KcPersistableBusinessObjectBase implements S2sFormConfigurationContract, MutableInactivatable {

    @PortableSequenceGenerator(name = "SEQ_S2S_FORM_CONFIG_ID")
    @GeneratedValue(generator = "SEQ_S2S_FORM_CONFIG_ID")
    @Id
    @Column(name = "S2S_FORM_CONFIG_ID")
    private String id;

    @Column(name = "FORM_NAME")
    private String formName;

    @Column(name = "ACTIVE_FLAG")
    @Convert(converter = BooleanYNConverter.class)
    private boolean active;

    @Column(name = "INACTIVE_MESSAGE")
    private String inactiveMessage;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getInactiveMessage() {
        return inactiveMessage;
    }

    public void setInactiveMessage(String inactiveMessage) {
        this.inactiveMessage = inactiveMessage;
    }
}
