/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.attachment;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.propdev.api.attachment.NarrativeTypeContract;
import org.kuali.rice.krad.data.jpa.converters.BooleanYNConverter;

import javax.persistence.*;

/**
 * Business Object for narratives added to a proposal. Narratives are the same as Proposal Attachments and vice-versa.
 * 
 * 
 * @version $Revision: 1.4 $
 */
@Entity
@Table(name = "NARRATIVE_TYPE")
public class NarrativeType extends KcPersistableBusinessObjectBase implements NarrativeTypeContract {

    @Id
    @Column(name = "NARRATIVE_TYPE_CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SYSTEM_GENERATED")
    @Convert(converter = BooleanYNConverter.class)
    private boolean systemGenerated;

    @Column(name = "ALLOW_MULTIPLE")
    @Convert(converter = BooleanYNConverter.class)
    private boolean allowMultiple;

    @Column(name = "NARRATIVE_TYPE_GROUP")
    private String narrativeTypeGroup;

    @Override
    public boolean isAllowMultiple() {
        return allowMultiple;
    }

    public void setAllowMultiple(boolean allowMultiple) {
        this.allowMultiple = allowMultiple;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getNarrativeTypeGroup() {
        return narrativeTypeGroup;
    }

    public void setNarrativeTypeGroup(String narrativeTypeGroup) {
        this.narrativeTypeGroup = narrativeTypeGroup;
    }

    @Override
    public boolean isSystemGenerated() {
        return systemGenerated;
    }

    public void setSystemGenerated(boolean systemGenerated) {
        this.systemGenerated = systemGenerated;
    }

    /**
     * Determine if two NarrativeTypes have the same values.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof NarrativeType) {
            NarrativeType other = (NarrativeType) obj;
            return StringUtils.equals(this.code, other.code) && StringUtils.equals(this.description, other.description) && this.systemGenerated == other.systemGenerated && this.allowMultiple == other.allowMultiple && StringUtils.equals(this.narrativeTypeGroup, other.narrativeTypeGroup);
        }
        return false;
    }
}
