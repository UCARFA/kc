<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>
<%@ attribute name="shortUrl" required="true" type="java.lang.String" description="short url" %>

<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script>
    var $j = jQuery.noConflict();
    $j(function() {
        $j( "#dialog" ).dialog({
            autoOpen: false
        });

        $j( "#opener" ).click(function() {
            $j( "#dialog" ).dialog( "open" );
            $j("#shortUrlText").select();
        });
    });
</script>

<div style ="min-height:50px" id="dialog" title="Short Url">
    <input id="shortUrlText" style="width:100%" type="text" value="${shortUrl}"/>
</div>

<div style="display:inline;cursor:pointer" id="opener"><i style="font-size:15px" class="material-icons">link</i></div>