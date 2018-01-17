/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.ynq;

import org.kuali.coeus.common.api.ynq.YnqExplanationTypeContract;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "YNQ_EXPLANATION_TYPE")
public class YnqExplanationType extends KcPersistableBusinessObjectBase implements YnqExplanationTypeContract {

    @Id
    @Column(name = "EXPLANATION_TYPE")
    private String explanationType;

    @Column(name = "DESCRIPTION")
    private String description;

    public YnqExplanationType() {
        super();
    }

    @Override
    public String getExplanationType() {
        return explanationType;
    }

    public void setExplanationType(String explanationType) {
        this.explanationType = explanationType;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
