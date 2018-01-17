<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<c:set var="AUDIT_ERRORS" value="<%=org.kuali.kra.infrastructure.Constants.AUDIT_ERRORS%>" />
<c:set var="AUDIT_WARNINGS" value="<%=org.kuali.kra.infrastructure.Constants.AUDIT_WARNINGS%>" />
<kra:dataValidation auditActivated="${KualiForm.auditActivated}" categories="${AUDIT_ERRORS},${AUDIT_WARNINGS}" topTab="true">
                    <p>You can activate a Validation check to determine any errors or incomplete information. The following Validations types will be determined:</p>
                    <ul>
                      <li>errors that prevent submission into routing</li>
                      <li>warnings that serve as alerts to  possible data issues but will not prevent submission into routing</li>
                      <li>errors that prevent submission to grants.gov</li>
                    </ul>
</kra:dataValidation>
