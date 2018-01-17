<%@ page import="org.springframework.core.io.ClassPathResource" %>
<%@ page import="java.nio.file.Files" %>
<%@ page import="java.nio.file.Paths" %>
<%@ page import="java.nio.charset.Charset" %>
<%@ page import="java.util.List" %>
<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--KC MODIFICATION START--%>
<title>Kuali Coeus 2.0 Acknowledgements</title>
<link href="css/screen.css" rel="stylesheet" type="text/css">
<%--KC MODIFICATION END--%>
</head>
<body onload="placeFocus()">
 <table width="100%" border=0 cellpadding=0 cellspacing=0 class="headercell1">
	<tr>
		<td width="50%" align="left"><img src="static/images/logo-kra.gif" alt="Kuali Coeus" hspace=5 vspace=5></td>
  	</tr>
</table>

 <table width="95%" border=0 cellspacing=0 cellpadding=0 align="center">
 <tr>
<td class="content" valign="top">
<BR/>
<h3><a name="Acknowledgements-"></a><font color="maroon">Acknowledgments</font></h3>

<p><img src="http://opensource.org/trademarks/osi-certified/web/osi-certified-60x50.png" align="right" border="0" /><br/>
Copyright 2005-2017 Kuali, Inc. All rights reserved. This software is licensed for use pursuant to the <a href="http://www.gnu.org/licenses/agpl-3.0.html">Affero General Public License, version 3</a>. Portions of this software are copyrighted by other parties, including the parties listed below, and you should see the licenses directory for complete copyright and licensing information.
<h3><a name="LicensingandAcknowledgments-ThirdPartyContributions"></a>Third Party Contributions</h3>

<%
    final List<String> lines = Files.readAllLines(Paths.get(new ClassPathResource("META-INF/THIRD-PARTY.txt").getURI()), Charset.forName("UTF-8"));
    for (String line : lines) {
        out.println("<p>" + line + "</p>");
    }
%>

</td>
</tr>
</table>
</body>
</html>
