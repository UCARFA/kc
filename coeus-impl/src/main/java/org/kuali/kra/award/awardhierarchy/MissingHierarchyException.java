/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy;

/**
 * Custom exception thrown when a hierarchy node search fails to yield an AwardHierarchy when it should have
 */
public class MissingHierarchyException extends RuntimeException {
    public MissingHierarchyException(String awardNumber) {
        super("No hierarchy node found for awardNumber: " + awardNumber);   
    }
}
