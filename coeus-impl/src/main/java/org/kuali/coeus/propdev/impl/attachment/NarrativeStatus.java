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
import org.kuali.coeus.propdev.api.attachment.NarrativeStatusContract;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NARRATIVE_STATUS")
public class NarrativeStatus extends KcPersistableBusinessObjectBase implements NarrativeStatusContract {

    @Id
    @Column(name = "NARRATIVE_STATUS_CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
	 * Determine if two NarrativeStatuses have the same values.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof NarrativeStatus) {
            NarrativeStatus other = (NarrativeStatus) obj;
            return StringUtils.equals(this.code, other.code) && StringUtils.equals(this.description, other.description);
        }
        return false;
    }
}
