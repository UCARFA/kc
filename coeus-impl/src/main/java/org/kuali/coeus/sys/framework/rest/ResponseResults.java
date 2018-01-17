/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.rest;

import com.codiform.moo.annotation.Property;

public class ResponseResults {
    @Property(source="totalResults")
    private Integer totalFound;
    @Property(source="mvel:results.size()")
    private Integer count;

    public Integer getTotalFound() {
        return totalFound;
    }

    public void setTotalFound(Integer totalFound) {
        this.totalFound = totalFound;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
