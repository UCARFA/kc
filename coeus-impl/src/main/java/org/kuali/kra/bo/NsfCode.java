/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.bo;


import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.krad.data.jpa.PortableSequenceGenerator;

import javax.persistence.*;

@Entity
@Table(name = "NSF_CODES")
public class NsfCode extends KcPersistableBusinessObjectBase {

    @PortableSequenceGenerator(name = "SEQUENCE_NSF_CODES")
    @GeneratedValue(generator = "SEQUENCE_NSF_CODES")
    @Id
    @Column(name = "NSF_SEQUENCE_NUMBER")
    private Integer nsfSequenceNumber;

    @Column(name = "NSF_CODE")
    private String nsfCode;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "DESCRIPTION")
    private String description;

    public Integer getNsfSequenceNumber() {
        return nsfSequenceNumber;
    }

    public void setNsfSequenceNumber(Integer nsfSequenceNumber) {
        this.nsfSequenceNumber = nsfSequenceNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNsfCode() {
        return nsfCode;
    }

    public void setNsfCode(String nsfCode) {
        this.nsfCode = nsfCode;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
