/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home;

import org.kuali.kra.award.AwardTemplateSyncScope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This Annotation represents award syncable property
 * The scopes attribute determines what scope the sync will happen if
 * a scope or scopes are specified by the call to sync the award.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AwardSyncable {

    public static final String DEFAULT_PARENT_PROPERTY = "award";
    
    /**
     * The scope(s) where the sync should take place.    
     * 
     */
    AwardTemplateSyncScope[] scopes() default {};
    
    String   parentPropertyName() default DEFAULT_PARENT_PROPERTY;
    
    boolean impactSourceScopeEmpty() default true;
    
    
}
