/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.print.watermark;


/**
 * 
 * This class is an interface for fetching the appropriate watermark object.
 *  
 */
public interface Watermarkable {
    /**
     * 
     * This method sets the appropriate watermark 
     * bean with respect to the module.
     */
    public WatermarkBean getWatermark();
    
    /**
     * 
     * This method sets the invalid watermark bean.
     */
    public WatermarkBean getInvalidWatermark();
}
