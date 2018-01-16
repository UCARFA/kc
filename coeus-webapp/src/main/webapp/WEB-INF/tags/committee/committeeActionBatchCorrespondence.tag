<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<div id="workarea">
    <kul:tab tabTitle="Batch Correspondence"
             tabErrorKey="committeeHelper.generateBatchCorrespondenceTypeCode,committeeHelper.generateStartDate,committeeHelper.generateEndDate,committeeHelper.history*"
             auditCluster="requiredFieldsAuditErrors"  
             defaultOpen="false"
             useCurrentTabIndexAsKey="false"  
             transparentBackground="true">
        <div class="tab-container" align="center">
            <kra-committee:committeeActionBatchCorrespondenceGenerate />
            <p>&nbsp;</p>
            <kra-committee:committeeActionBatchCorrespondenceHistory />
            <p>&nbsp;</p>
        </div> 
    </kul:tab>
</div>
