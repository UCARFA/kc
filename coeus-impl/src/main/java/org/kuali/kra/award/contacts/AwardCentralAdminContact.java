/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

/**
 * This class is a minor hack to satisfy the DataDictionary requirements.
 *  Since the Award Central Admin contact type uses the same BO as the Unit Contact type, 
 *  the DD can't find the AwardCentralAdminContact DD entry when it does  
 *  de = documentEntriesByBusinessObjectClass.get(clazz) lookup
 */
public class AwardCentralAdminContact extends AwardUnitContact {
    private static final long serialVersionUID = 2430642816335021874L;

}
