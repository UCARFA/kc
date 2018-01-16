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
 * This is an Annotation to represent any award syncable list properties
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AwardSyncableList  {
    public static final String DEFAULT_METHOD = "defaultMethod";
    public static final String DEFAULT_PARENT_PROPERTY = "award";
    /**
     * 
     * Set this property to the Class within a list.  This should be set to the destination class.
     * For eg: for List&lt;AwardComment&gt; awardComments (in award ), it should be set to AwardComment.class
     *
     */
    Class    syncClass();
    
    /**
     * 
     * Set this property to the Class within the source list.
     * For eg: for List&lt;AwardTemplateComment&gt; in AwardTemplate, it should be set to AwardTemplateComment.class
     * It will default to Object.class.
     * 
     * This is used by the list sync methods to determine which isInScope method to call when syncing list objects.
     */
    Class    syncSourceClass() default Object.class;
    
    /**
     * Set this property to the variable name representing its parent.
     * 
     */
    String   parentPropertyName() default DEFAULT_PARENT_PROPERTY;
    
    /**
     *If the sync functionality to be overwritten in the service, set the name of the method here and implement the same in service. 
     */
    String   syncMethodName() default DEFAULT_METHOD;
    
    
    /**
     * The scope(s) where the sync should take place.
     * 
     */
    
    AwardTemplateSyncScope[] scopes() default {};
    
    /*
     * 
     */
    
    boolean removeMissingListElementsFromTarget() default true;
    
    /*
     * Do members of the list impact an empty within scope calculation.
     * If this is set to true, then this list has an impact on the source
     * is empty for the scopes.
     */
    boolean impactSourceScopeEmpty() default true;

}
