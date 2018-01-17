/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.bo;

import org.kuali.coeus.sys.api.model.Sortable;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Defines a sortable Business Object that sorts via a {@code sortId}.
 */
@MappedSuperclass
public abstract class KraSortablePersistableBusinessObjectBase extends KcPersistableBusinessObjectBase implements Sortable {

    private static final long serialVersionUID = 1375643268900632092L;

    @Column(name = "SORT_ID")
    private Integer sortId;

    @Override
    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
