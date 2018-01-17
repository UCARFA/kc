<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="disclosurePersonUnitsAttributes" value="${DataDictionary.DisclosurePersonUnit.attributes}" />
<c:set var="disclosureReporter" value="document.coiDisclosureList[0].disclosurePersons[0]" />
<c:set var="unitAttributes" value="${DataDictionary.Unit.attributes}" />
<bean:define id="disclosurePersonUnits" name="KualiForm" property="document.coiDisclosureList[0].disclosurePersons[0].disclosurePersonUnits" />
<c:set var="readOnly" value="${!KualiForm.disclosureHelper.modifyReporter || readOnly}" />

<div class="tab-container" align="center">
    <kul:innerTab tabTitle="Unit Details" parentTab="Reporter" defaultOpen="false" tabErrorKey="disclosureHelper.newDisclosurePersonUnit.*,document.coiDisclosureList[0].disclosurePersons[0]*" useCurrentTabIndexAsKey="false">
    	<div class="innerTab-container" align="left">
        	<table class=tab cellpadding="0" cellspacing="0" summary="">
                <tbody>
                	<%-- Header --%>
                    <tr>
                        <kul:htmlAttributeHeaderCell literalLabel="&nbsp;" scope="col" /> 
                        <kul:htmlAttributeHeaderCell attributeEntry="${unitAttributes.unitName}" scope="col" align="center"/>
                        <kul:htmlAttributeHeaderCell attributeEntry="${disclosurePersonUnitsAttributes.unitNumber}" scope="col" align="center"/>
                        <kul:htmlAttributeHeaderCell attributeEntry="${disclosurePersonUnitsAttributes.leadUnitFlag}" scope="col" align="center"/>
                        <c:if test="${!readOnly}">
                            <kul:htmlAttributeHeaderCell literalLabel="Actions" scope="col" align="center"/>
                        </tr> 
                        <%-- Header --%>
                        
                        <%-- New data --%>
                        <%-- kra:permission value="${KualiForm.disclosureHelper.modifyPersonnel}" --%>
                        <c:if test="${not readOnly}">
                        	 <tbody class="addline">
                             <tr>
                                <th class="infoline">
                                    <c:out value="Add:" />
                                </th>
                                <td align="left" valign="middle" class="infoline">
                                    <div id="disclosureHelper.newDisclosurePersonUnit.unitName.div" class="same-line">
                                        <kul:htmlControlAttribute property="disclosureHelper.newDisclosurePersonUnit.unitName"
                                                                  attributeEntry="${unitAttributes.unitName}" readOnly="true"
                                                                  readOnlyBody="${empty KualiForm.disclosureHelper.newDisclosurePersonUnit.unitName}">
                                            (select)
                                        </kul:htmlControlAttribute>
                                    </div>
                                    &nbsp;
                                    <kul:lookup boClassName="org.kuali.coeus.common.framework.unit.Unit" fieldConversions="unitNumber:disclosureHelper.newDisclosurePersonUnit.unitNumber,unitName:disclosureHelper.newDisclosurePersonUnit.unitName" />
                                    <span class="fineprint"></span> 
                                </td>
                                <td align="left" valign="middle" class="infoline">
                                    <div align=left>
                                        <kul:htmlControlAttribute property="disclosureHelper.newDisclosurePersonUnit.unitNumber"
                                            attributeEntry="${unitAttributes.unitNumber}" 
                                            onblur="ajaxLoad('getUnitName','disclosureHelper.newDisclosurePersonUnit.unitNumber', 'disclosureHelper.newDisclosurePersonUnit.unitName');" 
                                        />

                                    </div>
                                    <span class="fineprint"></span> 
                                </td>
                                    <td align="left" valign="middle" class="infoline">
                                        <div align=center class="ignoreMeFromWarningOnAddRow">
                                            <bean:define id="leadFlag" name="KualiForm" property="disclosureHelper.newDisclosurePersonUnit.leadUnitFlag" />
											<html:checkbox property="disclosureHelper.newDisclosurePersonUnit.leadUnitFlag" title="Add this unit as lead" />
                                        </div>
                                    </td>
                                <td class="infoline">
                                    <div align=center>
                                        <html:image property="methodToCall.addDisclosurePersonUnit.line${status.index}" 
                                        src="${ConfigProperties.kr.externalizable.images.url}tinybutton-add1.gif" title="Add Unit" alt="Add Unit" styleClass="tinybutton addButton"/></div>
                                </td>
                            </c:if>
                        </tr>
                        </tbody>
                     </c:if>   
                        <%-- /kra:permission --%>
                        <%-- New data --%>
                        
                        <%-- Existing data --%>
                        <c:forEach var="disclosurePersonUnit" items="${disclosurePersonUnits}" varStatus="status">
                             <tr>
                                <th class="infoline">
                                    <c:out value="${status.index+1}" />
                                </th>
                              <td align="left" valign="middle">
                                <div align="left">
                                    <kul:htmlControlAttribute property="${disclosureReporter}.disclosurePersonUnits[${status.index}].unit.unitName" attributeEntry="${unitAttributes.unitName}"  readOnly="true" />
                                </div>
                              </td>
                              <td align="left" valign="middle">
                                <div align="left">
                                    <kul:htmlControlAttribute property="${disclosureReporter}.disclosurePersonUnits[${status.index}].unitNumber" attributeEntry="${unitAttributes.unitNumber}"  readOnly="true" />
                                </div>
                              </td>
                                  <td align="left" valign="middle">
                                    <div align="center">
                                        <html:radio property="${disclosureReporter}.selectedUnit" value="${status.index}" disabled="${readOnly}"/>
                                    </div>
                                  </td>
                              <c:if test="${!readOnly}">
                                  <td class="infoline">
                                    <div align="center">
                                        <html:image property="methodToCall.deleteDisclosurePersonUnit.${disclosureReporter}.line${status.index}"
                                        src='${ConfigProperties.kra.externalizable.images.url}tinybutton-delete1.gif' styleClass="tinybutton"/>
                                    </div>
                                  </td>
                            </c:if>
                            </tr>
                        </c:forEach>
                        <%-- Existing data --%>
            	</tr> 
            	<%--           
                <tr>
                    <td align="center" colspan="5">
                        <div align="center">
                            <html:image property="methodToCall.savedisclosurePersonUnits.anchor${tabKey}"
                                        src='${ConfigProperties.kra.externalizable.images.url}tinybutton-submit.gif' styleClass="tinybutton"/>
                        </div>
                    </td>
                </tr>
                --%>
            	</tbody>
        	</table>
        </div>
    </kul:innerTab>
</div>
