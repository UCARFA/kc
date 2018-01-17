/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.creditsplit;

/**
 * Method interface for {@link org.kuali.coeus.propdev.impl.person.creditsplit.CreditSplit} instances to determine the <code>name</code>
 * accessor of a {@link org.kuali.coeus.propdev.impl.person.creditsplit.CreditSplit}.
 */
public interface NamedCreditSplitable extends CreditSplitable {
    String getCreditSplitName();
}
