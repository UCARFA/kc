/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.signature;

public class PersonSignaturePrintHelper {

    private float signatureTag;
    private float coordinateX;
    private float coordinateY;
    
    public float getSignatureTag() {
        return signatureTag;
    }
    
    public void setSignatureTag(float signatureTag) {
        this.signatureTag = signatureTag;
    }
    
    public float getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(float coordinateX) {
        this.coordinateX = coordinateX;
    }
    
    public float getCoordinateY() {
        return coordinateY;
    }
    
    public void setCoordinateY(float coordinateY) {
        this.coordinateY = coordinateY;
    }
    
    
}
