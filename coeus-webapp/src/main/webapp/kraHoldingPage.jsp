<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<script type="text/javascript" src="scripts/jquery/jquery.js"></script>
<script type="text/javascript">
    var jq = jQuery.noConflict();
    jq(document).ready(function(){
    	top.jQuery.unblockUI();
    }
	);
</script>

<meta http-equiv="refresh" content="5">
        
<kul:page showDocumentInfo="false"
          headerTitle="Kuali Transactional Document Postprocessing Holding Page"
          docTitle="Kuali Transactional Document Postprocessing Holding Page"
          transactionalDocument="false"
          htmlFormAction="kraHoldingPage"
          defaultMethodToCall="returnToPortal">

	<input type="hidden" name="holdingPageDocumentId" value="${holdingPageDocumentId}">
	<input type="hidden" name="holdingPageReturnLocation" value="${holdingPageReturnLocation}">

    <div class="topblurb">
        <div align="center">
	        <table cellpadding="10" cellspacing="0" border="0">
	            <tr>
	                <td>
	                    <div align="center">
	                        The document is being processed. You will be returned to the document once processing is complete. 
	                        You can also return to the main menu by clicking below.
	                    </div>
	                </td>
	            </tr>
	            <tr>
	                <td>
	                    <div align="center">
	                        <input type="image" name="methodToCall.returnToPortal" title="Return to Portal" alt="Return to Portal" 
	                               src="${ConfigProperties.kra.externalizable.images.url}buttonsmall_returnToPortal.gif" class="tinybutton" />
	                    </div>
	                </td>
	            </tr>
	        </table>
	    </div>
    </div>
    
</kul:page>
