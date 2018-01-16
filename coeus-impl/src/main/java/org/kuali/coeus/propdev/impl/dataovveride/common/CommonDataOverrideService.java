/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.dataovveride.common;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public interface CommonDataOverrideService {

    void setChangedValue(KcPersistableBusinessObjectBase bo, String propertyName, String propertyValue);
    String getChangedValue(KcPersistableBusinessObjectBase bo, String propertyName);
    <T extends KcPersistableBusinessObjectBase> String getDisplayReferenceValue(T bo, String propertyName, Class<T> clazz);
}
