/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s;

import javax.persistence.*;

import org.kuali.coeus.propdev.api.s2s.S2sUserAttachedFormFileContract;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.krad.data.jpa.PortableSequenceGenerator;

@Entity
@Table(name = "S2S_USER_ATTACHED_FORM_FILE")
public class S2sUserAttachedFormFile extends KcPersistableBusinessObjectBase implements S2sUserAttachedFormFileContract { 

    private static final long serialVersionUID = 379923661813734826L;
    
    @PortableSequenceGenerator(name = "SEQ_S2S_USER_ATTD_FORM_FILE_ID")
    @GeneratedValue(generator = "SEQ_S2S_USER_ATTD_FORM_FILE_ID")
    @Id
    @Column(name = "S2S_USER_ATTACHED_FORM_FILE_ID")
    private Long id;

    @Lob
    @Column(name = "FORM_FILE")
    private byte[] formFile;
    
    @Column(name = "XML_FILE")
    private String xmlFile;

    @ManyToOne(cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "S2S_USER_ATTACHED_FORM_ID")
    private S2sUserAttachedForm s2sUserAttachedForm;

    @Override
    public Long getS2sUserAttachedFormId() {
        return s2sUserAttachedForm != null ? s2sUserAttachedForm.getId() : null;
    }

    @Override
    public byte[] getFormFile() {
        return formFile;
    }

    public void setFormFile(byte[] formFile) {
        this.formFile = formFile;
    }

    @Override
    public String getXmlFile() {
        return xmlFile;
    }

    public void setXmlFile(String xmlFile) {
        this.xmlFile = xmlFile;
    }

    @Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public S2sUserAttachedForm getS2sUserAttachedForm() {
        return s2sUserAttachedForm;
    }

    public void setS2sUserAttachedForm(S2sUserAttachedForm s2sUserAttachedForm) {
        this.s2sUserAttachedForm = s2sUserAttachedForm;
    }
}
