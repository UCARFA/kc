/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.award.finance.timeAndMoney;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;
import org.kuali.rice.krad.data.jpa.PortableSequenceGenerator;
import org.kuali.rice.krad.data.jpa.converters.BooleanYNConverter;

import javax.persistence.*;

@Entity
@Table(name="TIME_AND_MONEY_POSTS")
public class TimeAndMoneyPosts extends KcPersistableBusinessObjectBase implements MutableInactivatable {

    @PortableSequenceGenerator(name = "SEQ_TIME_AND_MONEY_POSTS_ID")
    @GeneratedValue(generator = "SEQ_TIME_AND_MONEY_POSTS_ID")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "AWARD_ID")
    private Long awardId;
    @Column(name="ACTIVE")
    @Convert(converter = BooleanYNConverter.class)
    private boolean active;
    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;
    @Column(name = "AWARD_FAMILY")
    private String awardFamily;

    public TimeAndMoneyPosts() {
        this.active = Boolean.TRUE;
    }

    public String getAwardFamily() {
        return awardFamily;
    }

    public void setAwardFamily(String awardFamily) {
        this.awardFamily = awardFamily;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAwardId() {
        return awardId;
    }

    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }
}
