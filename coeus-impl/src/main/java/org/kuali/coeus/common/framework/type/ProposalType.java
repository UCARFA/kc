/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.type;

import org.kuali.coeus.common.api.type.ProposalTypeContract;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROPOSAL_TYPE")
public class ProposalType extends KcPersistableBusinessObjectBase implements ProposalTypeContract {

    public static final String RESUBMISSION_TYPE_CODE = "2";

    public static final String CONTINUATION_TYPE_CODE = "4";

    public static final String REVISION_TYPE_CODE = "5";


    private static final long serialVersionUID = -7629520657077311450L;

    @Id
    @Column(name = "PROPOSAL_TYPE_CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

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
}
