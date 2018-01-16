/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to define the export of items for award sync.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AwardSyncableProperty {
    /**
     * Is this property used as a key for this BO
     * @return
     */
    boolean key() default false;
    
    /**
     * Does this property identify a parent relationship that should be followed
     * as part of the sync export.
     * @return
     */
    boolean parent() default false;
    
    /**
     * Required if on a parent property {@link #parent}. Identifies the name
     * of the property the parent has to relate to this child element.
     * @return
     */
    String parentProperty() default "";
}
