<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/jquery/new_kuali.css" type="text/css" />
<link rel="stylesheet" href="css/jquery/kuali-stylesheet.css"
<c:set var="notificationAttributes" value="${DataDictionary.KcNotification.attributes}" />
<c:set var="notification" value="${KualiForm.disclosureHelper.viewNotification}" />
<html>
   <head>
		<link rel="stylesheet" href="css/jquery/new_kuali.css" type="text/css" />
		<link rel="stylesheet" href="css/jquery/kuali-stylesheet.css"
			type="text/css" />
		<script>var jsContextPath = "${pageContext.request.contextPath}";</script>
		<title>Disclosure Notification</title>
	</head>

	<body>
	    <table border="1" style="padding: 0px; border-collapse: collapse;">
            <tbody>
                <tr>
                    <td style="background-color: rgb(195, 195, 195); font-weight: bold;" colspan="5">Notification Details:</td>
		        </tr>
			    <tr>
		            <td class="infoline fineprint sequencetd" style="font-weight: bold; text-align: center; color: rgb(51, 51, 51);">Date Created</td>
          			<td class="infoline fineprint sequencetd" style="font-weight: bold; text-align: center; color: rgb(51, 51, 51);">Recipients</td>
		            <td class="infoline fineprint sequencetd" style="font-weight: bold; text-align: center; color: rgb(51, 51, 51);">Subject</td>
           			<td class="infoline fineprint sequencetd" style="font-weight: bold; text-align: center; color: rgb(51, 51, 51);">Message</td>
        		</tr>
				<tr>
	    			<td>
		   				<div align="center">
		    				<fmt:formatDate value="${notification.createTimestamp}" pattern="MM/dd/yyyy KK:mm a" /> 
						</div>
					</td>    
        			<td align="center" valign="middle">
			    		<div align="center">
				    		${notification.recipients}
	           			</div>
		   	    	</td>
					<td align="left" valign="middle">
           				<div align="left"> 
               				${notification.subject}
		            	</div>
    		    	</td>
					<td align="center" valign="middle">
           				<div align="left">
		               		${notification.message}
						</div>
					</td>
	    		</tr>
	    	</tbody>
		</table>
		<kul:csrf />
	</body>
</html>
