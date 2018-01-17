<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="personAttributes" value="${DataDictionary.KcPerson.attributes}" />
<c:set var="reporter" value = "financialEntityHelper.financialEntityReporter.reporter" />
<kul:tab defaultOpen="true" tabTitle="Reporter" transparentBackground="true"
    tabErrorKey="" >

    <div class="tab-container" align="center">
        <h3>
            <span class="subhead-left"> Contact Information </span>
            <span class="subhead-right"><kul:help parameterNamespace="KC-COIDISCLOSURE" parameterDetailType="Document" parameterName="financialEntityReporterHelp" altText="help"/></span>
        </h3>
        <table id="response-table" width="100%" cellpadding="0" cellspacing="0" class="datatable">
        <tr>
        <td>
                    <table class=tab cellpadding=0 cellspacing="0" summary=""> 
                        <tbody>
                            <tr>
                                <th> 
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.fullName}"/>
                                    </div>
                                </th>
                                <td>
                                    <kul:htmlControlAttribute property="${reporter}.fullName" 
                                                              attributeEntry="${personAttributes.fullName}" 
                                                              readOnly="true"/> 
                                </td>
                                <th width="15%">
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.userName}"/>
                                    </div>
                                </th>
                                <td align="left" width="30%">
                                    <kul:htmlControlAttribute property="${reporter}.userName" 
                                    attributeEntry="${personAttributes.userName}" readOnly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <th nowrap="nowrap"> 
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.emailAddress}"/>
                                    </div>
                                </th>
                                <td>
                                    <kul:htmlControlAttribute property="${reporter}.emailAddress" 
                                                              attributeEntry="${personAttributes.emailAddress}" 
                                                              readOnly="true"/> 
                                </td>
                                <th width="15%">
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.officePhone}"/>
                                    </div>
                                </th>
                                <td align="left" width="30%">
                                    <kul:htmlControlAttribute property="${reporter}.officePhone" 
                                    attributeEntry="${personAttributes.officePhone}" readOnly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <th nowrap="nowrap"> 
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes['extendedAttributes.primaryTitle']}"/>
                                    </div>
                                </th>
                                <td>
                                    <kul:htmlControlAttribute property="${reporter}.primaryTitle" 
                                                              attributeEntry="${personAttributes['extendedAttributes.primaryTitle']}" 
                                                              readOnly="true"/> 
                                </td>
                                <th width="15%">
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes['extendedAttributes.directoryTitle']}"/>
                                    </div>
                                </th>
                                <td width="30%">
                                    <kul:htmlControlAttribute property="${reporter}.directoryTitle" 
                                    attributeEntry="${personAttributes['extendedAttributes.directoryTitle']}" readOnly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <th nowrap="nowrap"> 
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.organizationIdentifier}"/>
                                    </div>
                                </th>
                                <td>
                                    <kul:htmlControlAttribute property="${reporter}.organizationIdentifier" 
                                                              attributeEntry="${personAttributes.organizationIdentifier}" 
                                                              readOnly="true"/> 
                                </td>
                                <th width="15%">
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes['extendedAttributes.school']}"/>
                                    </div>
                                </th>
                                <td align="left" width="30%">
                                    <kul:htmlControlAttribute property="${reporter}.school" 
                                    attributeEntry="${personAttributes['extendedAttributes.school']}" readOnly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <th> 
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.eraCommonsUserName}"/>
                                    </div>
                                </th>
                                <td>
                                    <kul:htmlControlAttribute property="${reporter}.eraCommonsUserName" 
                                                              attributeEntry="${personAttributes.eraCommonsUserName}" 
                                                              readOnly="true"/> 
                                </td>
                                <th width="15%">
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.faxNumber}"/>
                                    </div>
                                </th>
                                <td align="left" width="30%">
                                    <kul:htmlControlAttribute property="${reporter}.faxNumber" 
                                    attributeEntry="${personAttributes.faxNumber}" readOnly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <th> 
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.pagerNumber}"/>
                                    </div>
                                </th>
                                <td>
                                    <kul:htmlControlAttribute property="${reporter}.pagerNumber" 
                                                              attributeEntry="${personAttributes.pagerNumber}" 
                                                              readOnly="true"/> 
                                </td>
                                <th width="15%">
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.mobilePhoneNumber}"/>
                                    </div>
                                </th>
                                <td align="left" width="30%">
                                    <kul:htmlControlAttribute property="${reporter}.mobilePhoneNumber" 
                                    attributeEntry="${personAttributes.mobilePhoneNumber}" readOnly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <th> 
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes['extendedAttributes.officeLocation']}"/>
                                    </div>
                                </th>
                                <td>
                                    <kul:htmlControlAttribute property="${reporter}.officeLocation" 
                                                              attributeEntry="${personAttributes['extendedAttributes.officeLocation']}" 
                                                              readOnly="true"/> 
                                </td>
                                <th width="15%">
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes['extendedAttributes.secondaryOfficeLocation']}"/>
                                    </div>
                                </th>
                                <td align="left" width="30%">
                                    <kul:htmlControlAttribute property="${reporter}.secondaryOfficeLocation" 
                                    attributeEntry="${personAttributes['extendedAttributes.secondaryOfficeLocation']}" readOnly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <th> 
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.addressLine1}"/>
                                    </div>
                                </th>
                                <td>
                                    <kul:htmlControlAttribute property="${reporter}.addressLine1" 
                                                              attributeEntry="${personAttributes.addressLine1}" 
                                                              readOnly="true"/> 
                                </td>
                                <th> 
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.addressLine2}"/>
                                    </div>
                                </th>
                                <td>
                                    <kul:htmlControlAttribute property="${reporter}.addressLine2" 
                                                              attributeEntry="${personAttributes.addressLine2}" 
                                                              readOnly="true"/> 
                                </td>
                            </tr>
                            <tr>
                                <th> 
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.addressLine3}"/>
                                    </div>
                                </th>
                                <td>
                                    <kul:htmlControlAttribute property="${reporter}.addressLine3" 
                                                              attributeEntry="${personAttributes.addressLine3}" 
                                                              readOnly="true"/> 
                                </td>
                                <th width="15%">
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.city}"/>
                                    </div>
                                </th>
                                <td align="left" width="30%">
                                    <kul:htmlControlAttribute property="${reporter}.city" 
                                    attributeEntry="${personAttributes.city}" readOnly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <th width="15%">
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes['extendedAttributes.county']}"/>
                                    </div>
                                </th>
                                <td align="left" width="30%">
                                    <kul:htmlControlAttribute property="${reporter}.county" 
                                    attributeEntry="${personAttributes['extendedAttributes.county']}" readOnly="true"/>
                                </td>
                                <th width="15%">
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.state}"/>
                                    </div>
                                </th>
                                <td align="left" width="30%">
                                    <kul:htmlControlAttribute property="${reporter}.state" 
                                    attributeEntry="${personAttributes.state}" readOnly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <th> 
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.postalCode}"/>
                                    </div>
                                </th>
                                <td>
                                    <kul:htmlControlAttribute property="${reporter}.postalCode" 
                                                              attributeEntry="${personAttributes.postalCode}" 
                                                              readOnly="true"/> 
                                </td>
                                <th width="15%">
                                    <div align="right">
                                        <kul:htmlAttributeLabel attributeEntry="${personAttributes.countryCode}"/>
                                    </div>
                                </th>
                                <td align="left" width="30%">
                                    <kul:htmlControlAttribute property="${reporter}.countryCode" 
                                    attributeEntry="${personAttributes.countryCode}" readOnly="true"/>
                                </td>
                            </tr>

                        </tbody>
                    </table>
                </div>
        </td>
    </tr>
</table>
    </div>
 <kra-coi:financialEntityReporterUnits />
</kul:tab>

