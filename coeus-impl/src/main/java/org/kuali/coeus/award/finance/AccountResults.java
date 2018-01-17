/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.finance;

import com.codiform.moo.annotation.CollectionProperty;

import org.kuali.coeus.sys.framework.rest.ResponseResults;

import java.util.Collection;

public class AccountResults extends ResponseResults {

    @CollectionProperty(source="results", itemClass=AccountDto.class)
    private Collection<AccountDto> accounts;

    public Collection<AccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(Collection<AccountDto> accounts) {
        this.accounts = accounts;
    }


}
