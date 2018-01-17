/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.finance;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;
import org.kuali.rice.krad.data.jpa.PortableSequenceGenerator;
import org.kuali.rice.krad.data.jpa.converters.BooleanYNConverter;

import javax.persistence.*;

@Entity
@Table(name="AWARD_POSTS")
public class AwardPosts extends KcPersistableBusinessObjectBase implements MutableInactivatable {

    @PortableSequenceGenerator(name = "SEQ_AWARD_POSTS_ID")
    @GeneratedValue(generator = "SEQ_AWARD_POSTS_ID")
    @Id
    @Column(name = "ID")
    private Long id;
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;
    @Column(name = "AWARD_ID")
    private Long awardId;
    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;
    @Column(name = "AWARD_FAMILY")
    private String awardFamily;
    @Column(name="POSTED")
    @Convert(converter = BooleanYNConverter.class)
    private boolean posted;
    @Column(name="ACTIVE")
    @Convert(converter = BooleanYNConverter.class)
    private boolean active;


    public AwardPosts() {
        posted = Boolean.TRUE;
        active = Boolean.TRUE;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getAwardFamily() {
        return awardFamily;
    }

    public void setAwardFamily(String awardFamily) {
        this.awardFamily = awardFamily;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAwardId() {
        return awardId;
    }

    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }

    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
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
