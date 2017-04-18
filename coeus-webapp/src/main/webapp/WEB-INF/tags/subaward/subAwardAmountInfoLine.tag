<%--
   - Kuali Coeus, a comprehensive research administration system for higher education.
   - 
   - Copyright 2005-2016 Kuali, Inc.
   - 
   - This program is free software: you can redistribute it and/or modify
   - it under the terms of the GNU Affero General Public License as
   - published by the Free Software Foundation, either version 3 of the
   - License, or (at your option) any later version.
   - 
   - This program is distributed in the hope that it will be useful,
   - but WITHOUT ANY WARRANTY; without even the implied warranty of
   - MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   - GNU Affero General Public License for more details.
   - 
   - You should have received a copy of the GNU Affero General Public License
   - along with this program.  If not, see <http://www.gnu.org/licenses/>.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<c:set var="subAwardAmountInfoAttributes" value="${DataDictionary.SubAwardAmountInfo.attributes}" />
<c:set var="subAwardAttributes" value="${DataDictionary.SubAward.attributes}" />
<%@ attribute name="amountInfo" required="true" type="org.kuali.kra.subaward.bo.SubAwardAmountInfo" %>
<%@ attribute name="amountInfoPath" required="true" %>
<%@ attribute name="index" required="true" %>
<%@ attribute name="currentTabIndex" required="true" %>
<%@ attribute name="readOnly" required="true" %>
<%@ attribute name="formAction" required="true" %>
<%@ attribute name="rowIndex" required="true" %>
<c:set var="costSplitEnabled" value="${KualiForm.costSplitEnabled}" />
<c:set var="attributeColor" value="#999999" />
<tr bgcolor="#f5f5f5"><td width="9%" class="infoline" colspan="6"><font color=${attributeColor}><b><c:out value="${rowIndex+1}" /></b></font></td></tr>

<tr>
    <c:choose>
        <c:when test="${!costSplitEnabled}">
            <th><div align="left">&nbsp;</div></th>
            <th><div align="center"><font color=${attributeColor}><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.effectiveDate}" /></font></div></th>
            <th><div align="center"><font color=${attributeColor}>*<kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.obligatedChange}" /></font></div></th>
            <th><div align="center"><font color=${attributeColor}>*<kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.anticipatedChange}" /></font></div></th>
            <th colspan="2"><div align="center">&nbsp;</div></th>
        </c:when>
        <c:otherwise>
            <th><div align="center"><font color=${attributeColor}><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.effectiveDate}" /></font></div></th>
            <th><div align="center"><font color=${attributeColor}>*<kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.obligatedChangeDirect}" /></font></div></th>
            <th><div align="center"><font color=${attributeColor}>*<kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.obligatedChangeIndirect}" /></font></div></th>
            <th><div align="center"><font color=${attributeColor}>*<kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.anticipatedChangeDirect}" /></font></div></th>
            <th><div align="center"><font color=${attributeColor}>*<kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.anticipatedChangeIndirect}" /></font></div></th>
            <th><div align="center"><font color=${attributeColor}><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.rate}" /></font></div></th>
        </c:otherwise>
    </c:choose>
</tr>

<tr>
<c:choose>
    <c:when test="${!costSplitEnabled}">
        <th><div align="left">&nbsp;</div></th>
        <td width="9%" valign="middle">
		    <div align="center">
			    <kul:htmlControlAttribute property="${amountInfoPath}.effectiveDate" attributeEntry="${subAwardAmountInfoAttributes.effectiveDate}" datePicker="true" readOnly="${readOnly}" />
		    </div>
	    </td>

	    <td width="9%" valign="middle">
		    <div align="center">
			    <kul:htmlControlAttribute property="${amountInfoPath}.obligatedChange" attributeEntry="${subAwardAmountInfoAttributes.obligatedChange}" readOnly="${readOnly}" />
		    </div>
	    </td>

	    <td width="9%" valign="middle">
		    <div align="center">
			    <kul:htmlControlAttribute property="${amountInfoPath}.anticipatedChange" attributeEntry="${subAwardAmountInfoAttributes.anticipatedChange}" readOnly="${readOnly}" />
		    </div>
        </td>
    </c:when>
    <c:otherwise>
        <td>
            <div align="center">
                <kul:htmlControlAttribute property="${amountInfoPath}.effectiveDate" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.effectiveDate}" datePicker="true" />
            </div>
        </td>
        <td>
            <div align="center">
                <kul:htmlControlAttribute property="${amountInfoPath}.obligatedChangeDirect" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.obligatedChangeDirect}" />
            </div>
        </td>
        <td>
            <div align="center">
                <kul:htmlControlAttribute property="${amountInfoPath}.obligatedChangeIndirect" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.obligatedChangeIndirect}" />
            </div>
        </td>
        <td>
            <div align="center">
                <kul:htmlControlAttribute property="${amountInfoPath}.anticipatedChangeDirect" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.anticipatedChangeDirect}" />
            </div>
        </td>
        <td>
            <div align="center">
                <kul:htmlControlAttribute property="${amountInfoPath}.anticipatedChangeIndirect" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.anticipatedChangeIndirect}" />
            </div>
        </td>
        <td>
            <div align="center">
                <kul:htmlControlAttribute property="${amountInfoPath}.rate" readOnly="${readOnly}" attributeEntry="${subAwardAmountInfoAttributes.rate}" />
            </div>
        </td>
    </c:otherwise>
</c:choose>
</tr>

<tr>
    <th><div align="center"><font color=${attributeColor}><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.modificationTypeCode}" /></font></div></th>
    <th><div align="center"><font color=${attributeColor}><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.modificationEffectiveDate}" /></font></div></th>
    <th><div align="center"><font color=${attributeColor}><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.modificationID}" /></font></div></th>
    <th><div align="center"><font color=${attributeColor}><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.periodofPerformanceStartDate}" /></font></div></th>
    <th><div align="center"><font color=${attributeColor}><kul:htmlAttributeLabel attributeEntry="${subAwardAmountInfoAttributes.periodofPerformanceEndDate}" /></font></div></th>
</tr>

<tr>
	<td width="9%" valign="middle">
		<div align="center">
			<kul:htmlControlAttribute
				property="${amountInfoPath}.modificationTypeCode"
				attributeEntry="${subAwardAmountInfoAttributes.modificationTypeCode}" readOnly="${readOnly}" />
		</div>
    </td>
	<td width="9%" valign="middle">
		<div align="center">
			<kul:htmlControlAttribute
				property="${amountInfoPath}.modificationEffectiveDate"
				attributeEntry="${subAwardAmountInfoAttributes.modificationEffectiveDate}"
				datePicker="true" readOnly="${readOnly}" />
		</div>
	</td>
	<td width="9%" valign="middle">
		<div align="center">
			<kul:htmlControlAttribute property="${amountInfoPath}.modificationID"
				attributeEntry="${subAwardAmountInfoAttributes.modificationID}"
				readOnly="${readOnly}" />
		</div>
	</td>
	<td width="9%" valign="middle">
		<div align="center">
			<kul:htmlControlAttribute
				property="${amountInfoPath}.periodofPerformanceStartDate"
				attributeEntry="${subAwardAmountInfoAttributes.periodofPerformanceStartDate}"
				datePicker="true" readOnly="${readOnly}" />
		</div>
	</td>
	<td width="9%" valign="middle">
		<div align="center">
			<kul:htmlControlAttribute
				property="${amountInfoPath}.periodofPerformanceEndDate"
				attributeEntry="${subAwardAmountInfoAttributes.periodofPerformanceEndDate}"
				datePicker="true" readOnly="${readOnly}" />
		</div>
	</td>

</tr>
<tr>
	<th>
        <div align="right">
            <font color=${attributeColor}>
			    <kul:htmlAttributeLabel
				    attributeEntry="${subAwardAmountInfoAttributes.comments}" />
            </font>
		</div>
    </th>
	<td><kul:htmlControlAttribute
			property="${amountInfoPath}.comments"
			attributeEntry="${subAwardAmountInfoAttributes.comments}"
			readOnly="${readOnly}" />
    </td>
    <td width="9%" valign="middle">
        <div align="center">Attachment Actions :</div>
        <br></br>
        <div align="center"></div>
        <div id="replaceDiv${index}" style="display: block;">
            <c:if test="${amountInfo.fileName!=null}">
                <kra:fileicon attachment="${amountInfo}" />
            </c:if>
            <kul:htmlControlAttribute property="${amountInfoPath}.fileName"
                                      readOnly="true"
                                      attributeEntry="${subAwardAmountInfoAttributes.fileName}" />
        </div>
        <c:if test="${!readOnly}">
            <div id="fileDiv${index}" valign="middle" style="display: none;">
                <html:file property="${amountInfoPath}.newFile" />
                <html:image
                        property="methodToCall.replaceHistoryOfChangesAttachment.line${index}.anchor${currentTabIndex}"
                        src='${ConfigProperties.kra.externalizable.images.url}tinybutton-add1.gif'
                        styleClass="tinybutton" />
            </div>
        </c:if>
        <div align="center">
            <c:if test="${amountInfo.fileName!=null}">
                <html:image
                        styleId="downloadHistoryOfChangesAttachment.line${amountInfo.subAwardAmountInfoId}"
                        property="methodToCall.downloadHistoryOfChangesAttachment.line${amountInfo.subAwardAmountInfoId}.anchor${currentTabIndex}"
                        src='${ConfigProperties.kra.externalizable.images.url}tinybutton-view.gif'
                        styleClass="tinybutton"
                        onclick="javascript: openNewWindow('${formAction}','downloadHistoryOfChangesAttachment','${amountInfo.subAwardAmountInfoId}',${KualiForm.formKey},'${KualiForm.document.sessionDocument}'); return false" />
            </c:if>
            <c:if test="${!readOnly}">
                <html:image styleId="replaceHistoryOfChangesAttachment.line${index}"
                            onclick="javascript: showHide('fileDiv${index}','replaceDiv${index}') ; return false"
                            src='${ConfigProperties.kra.externalizable.images.url}tinybutton-replace.gif'
                            styleClass="tinybutton"
                            property="methodToCall.replaceNarrativeAttachment.line${index}.anchor${currentTabIndex};return false" />
                <c:if test="${amountInfo.fileName!=null}">
                    <html:image
                            property="methodToCall.deleteAmountInfo.line${index}.anchor${currentTabIndex}"
                            src='${ConfigProperties.kra.externalizable.images.url}tinybutton-delete1.gif'
                            styleClass="tinybutton" />
                </c:if>
            </c:if>
            <c:if test="${readOnly}">&nbsp;</c:if>
        </div>
    </td>
</tr>
<c:choose>
    <c:when test="${costSplitEnabled}">
        <tr>
            <th><font color=${attributeColor}><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.totalObligatedAmount}" /></font></th>
            <td colspan="2">
                <kul:htmlControlAttribute property="document.subAwardList[0].totalObligatedAmount" disabled="true" attributeEntry="${subAwardAttributes.totalObligatedAmount}" />
            </td>
            <th><font color=${attributeColor}><kul:htmlAttributeLabel attributeEntry="${subAwardAttributes.totalAnticipatedAmount}" /></font></th>
            <td colspan="2">
                <kul:htmlControlAttribute property="document.subAwardList[0].totalAnticipatedAmount" disabled="true" attributeEntry="${subAwardAttributes.totalAnticipatedAmount}" />
            </td>
        </tr>
    </c:when>
</c:choose>