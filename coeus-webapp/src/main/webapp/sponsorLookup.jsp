<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>

<html>
<kul:page lookup="true" 
          docTitle="Add Sponsor Hierarchy" 
          transactionalDocument="false" 
          htmlFormAction="sponsorLookup">

	<input type="hidden" id="mapKey"
		name="mapKey" 
		value="${SponsorHierarchyForm.mapKey}" />

	<input type="hidden" id="methodToCall"
		name="methodToCall" value="${SponsorHierarchyForm.methodToCall}"/>
    <input type="hidden" id="anchor"
        name="anchor" value="topOfForm"/>


   		<label>
   			<html:image styleId="lookupBtn" tabindex="1000000" property="methodToCall.performLookup.(!!org.kuali.coeus.common.framework.sponsor.SponsorHierarchyMaintenanceLookupable!!).(:;newSponsors[0];:).((%true%)).anchor"
	           src="${ConfigProperties.kr.externalizable.images.url}searchicon.gif" border="0" alt="Multiple Value Search on " title="Multiple Value Search on " />
   		
         	</label><br>
         	
         		<input type="hidden" id="selectedSponsors" name="selectedSponsors" value="${SponsorHierarchyForm.selectedSponsors}" />
         	
</kul:page>
            
<script type="text/javascript">
  
     function returnSponsor() {
            var sponsors = document.getElementById("selectedSponsors").value
            var mapKey = document.getElementById("mapKey").value
           // alert("return sponsor "+mapKey+sponsors)
            window.opener.returnSponsor(sponsors, mapKey);
     
     }
     var lookupBtn=document.getElementById("lookupBtn");
     if (document.getElementById("methodToCall").value != "refresh") {
         var mapKey = document.getElementById("mapKey").value
        // alert("not refres "+mapKey)
        lookupBtn.click();
     } else {
       //  alert("refresh")
        returnSponsor();
        window.close();
     }
</script>

</html>
