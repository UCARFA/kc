/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.print;

import org.apache.xmlbeans.XmlObject;
import org.kuali.coeus.common.framework.print.stream.xml.PrintBaseXmlStream;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import java.util.Map;

/**
 * This class is used to populate xmlbeans object for ProtocolBase schema elements
 */
public abstract class ProtocolXmlStreamBase extends PrintBaseXmlStream {

    @Override
    public abstract Map<String, XmlObject> generateXmlStream(KcPersistableBusinessObjectBase printableBusinessObject, Map<String, Object> reportParameters);
    
}
