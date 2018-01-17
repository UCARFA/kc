<?xml version="1.0" encoding="UTF-8"?>
<!--
   - Copyright © 2005-2018 Kuali, Inc.
   - All Rights Reserved
   - You may use and modify this code under the terms of the Kuali, Inc.
   - Pre-Release License Agreement. You may not distribute it.
   -
   - You should have received a copy of the Kuali, Inc. Pre-Release License
   - Agreement with this file. If not, please write to license@kuali.co.
 -->
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<xsl:variable name="documentNumber">
			<xsl:value-of select="Protocol/ProtocolMasterData/DocumentNumber" />
		</xsl:variable>

		The IRB protocol number
		<a title="" target="_self"
			href="../kew/DocHandler.do?command=displayDocSearchView$amp;docId={$documentNumber}">
			<xsl:value-of select="Protocol/ProtocolMasterData/ProtocolNumber" />
		</a>

		, Principal Investigator
		<xsl:for-each select="Protocol/Investigator[PI_flag = 'true']">
			<xsl:value-of select="Person/Firstname" />
			<xsl:text> </xsl:text>
			<xsl:value-of select="Person/LastName" />
		</xsl:for-each>
		has had the action "Request To Close Enrollment" performed on it.
		<br />
		The action was executed by
		<xsl:value-of select="Protocol/user/firstName" />
		<xsl:text> </xsl:text>
		<xsl:value-of select="Protocol/user/lastName" />
		. Additional information and further actions can be accessed through
		the Kuali Coeus system.

	</xsl:template>
</xsl:stylesheet>