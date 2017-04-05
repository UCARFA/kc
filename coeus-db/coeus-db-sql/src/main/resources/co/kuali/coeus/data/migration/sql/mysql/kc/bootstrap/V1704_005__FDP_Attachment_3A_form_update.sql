--
-- Kuali Coeus, a comprehensive research administration system for higher education.
--
-- Copyright 2005-2016 Kuali, Inc.
--
-- This program is free software: you can redistribute it and/or modify
-- it under the terms of the GNU Affero General Public License as
-- published by the Free Software Foundation, either version 3 of the
-- License, or (at your option) any later version.
--
-- This program is distributed in the hope that it will be useful,
-- but WITHOUT ANY WARRANTY; without even the implied warranty of
-- MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
-- GNU Affero General Public License for more details.
--
-- You should have received a copy of the GNU Affero General Public License
-- along with this program.  If not, see <http://www.gnu.org/licenses/>.
--

delete from SUBAWARD_FORMS WHERE FORM_ID = 'FDP_ATT_3A';

INSERT INTO SUBAWARD_FORMS(FORM_ID,DESCRIPTION,UPDATE_TIMESTAMP,UPDATE_USER,FORM,FILE_NAME,CONTENT_TYPE,VER_NBR,OBJ_ID,TEMPLATE_TYPE_CODE) values ('FDP_ATT_3A',	'FDP Attachment 3A',now(),'admin',
'<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:award="http://subcontractFdpReports.bean.xml.utils.coeus.mit.edu/award" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:subcontract="http://subcontractFdpReports.bean.xml.utils.coeus.mit.edu/subcontract" xmlns:xdt="http://www.w3.org/2005/xpath-datatypes" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:fo="http://www.w3.org/1999/XSL/Format">
<xsl:output version="1.0" method="xml" encoding="UTF-8" indent="no"/>
<xsl:param name="SV_OutputFormat" select="''PDF''"/>
<xsl:variable name="XML" select="/"/>
<xsl:variable name="fo:layout-master-set">
<fo:layout-master-set>
<fo:simple-page-master master-name="default-page" page-height="11in" page-width="8.5in" margin-left="0.2in" margin-right="0.2in">
<fo:region-body margin-top="0.1in" margin-bottom="0.6in"/>
<fo:region-before extent="0.1in"/>
</fo:simple-page-master>
</fo:layout-master-set>
</xsl:variable>
<xsl:template match="/">
<fo:root>
<xsl:copy-of select="$fo:layout-master-set"/>
<fo:page-sequence master-reference="default-page" initial-page-number="1" format="1">
<xsl:call-template name="headerall"/>
<fo:flow flow-name="xsl-region-body">
<fo:block>
<fo:block/>
<xsl:for-each select="$XML">
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" margin-left="(100% - 90%) div 2" margin-right="(100% - 90%) div 2" width="90%" border-spacing=".25">
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-body start-indent="0pt">
<fo:table-row font-family="Arial">
<fo:table-cell font-family="Arial" font-size="9pt" number-columns-spanned="9" padding="2pt" height="32" text-align="right" display-align="before">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:block text-align="center" margin="0pt">
<fo:block>
<fo:inline>
<xsl:text>&#160;</xsl:text>
</fo:inline>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:block font-size="medium" font-weight="bold" margin="0pt">
<fo:block>
<fo:inline>
<xsl:text>Attachment 3A</xsl:text>
</fo:inline>
</fo:block>
</fo:block>
</fo:block>
</fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:block text-align="center" margin="0pt">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:block font-size="medium" margin="0pt">
<fo:block>
<fo:inline>
<xsl:text>Research Subaward Agreement</xsl:text>
</fo:inline>
</fo:block>
</fo:block>
</fo:block>
</fo:block>


<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:block text-align="center" margin="0pt">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:block font-size="small" margin="0pt">
<fo:block>
<fo:inline>
<xsl:text>Pass-Through Entity (PTE) Contacts</xsl:text>
</fo:inline>
</fo:block>
</fo:block>
</fo:block>
</fo:block>
<fo:inline>
<xsl:text>Subaward Number:</xsl:text>
</fo:inline>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:SubcontractDetail">
<xsl:for-each select="subcontract:FsrsSubawardNumber">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
<fo:block/>
</fo:block>
</fo:table-cell>
</fo:table-row>

<fo:table-row>
<fo:table-cell number-columns-spanned="9" padding="2pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Pass-Through Entity (PTE)</xsl:text>
</fo:inline>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table table-layout="fixed" width="100%" border-spacing=".5">
<fo:table-column column-width="proportional-column-width(1)"/>

<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing="0.25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="80%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>PTE Name:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeRecipientContacts">
<xsl:for-each select="subcontract:RequisitionerOrgDetails">
<xsl:for-each select="subcontract:OrganizationName">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="80%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Address:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeRecipientContacts">
<xsl:for-each select="subcontract:OrgRolodexDetails">
<xsl:for-each select="subcontract:Address1">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
<fo:block/>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeRecipientContacts">
<xsl:for-each select="subcontract:OrgRolodexDetails">
<xsl:for-each select="subcontract:Address2">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
<fo:block/>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeRecipientContacts">
<xsl:for-each select="subcontract:OrgRolodexDetails">
<xsl:for-each select="subcontract:Address3">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="27%"/>
<fo:table-column column-width="5%"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="30%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>City:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeRecipientContacts">
<xsl:for-each select="subcontract:OrgRolodexDetails">
<xsl:for-each select="subcontract:City">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>State:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell number-columns-spanned="2" padding="2pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeRecipientContacts">
<xsl:for-each select="subcontract:OrgRolodexDetails">
<xsl:for-each select="subcontract:StateDescription">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Zip Code: </xsl:text>
</fo:inline>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeRecipientContacts">
<xsl:for-each select="subcontract:OrgRolodexDetails">
<xsl:for-each select="subcontract:Pincode">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
<fo:block text-align="center">
<fo:leader leader-pattern="rule" rule-thickness="1" leader-length="100%" color="black"/>
</fo:block>
<fo:inline>
<xsl:text>PTE Administrative Contact</xsl:text>
</fo:inline>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table table-layout="fixed" width="100%" border-spacing="2pt">
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="80%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Name:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAdministrativeContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:RolodexName">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="80%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Address:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAdministrativeContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Address1">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
<fo:block/>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAdministrativeContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Address2">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
<fo:block/>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAdministrativeContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Address3">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="27%"/>
<fo:table-column column-width="5%"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="30%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>City:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAdministrativeContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:City">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>State:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell number-columns-spanned="2" padding="2pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAdministrativeContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:StateDescription">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Zip Code: </xsl:text>
</fo:inline>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAdministrativeContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Pincode">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="10%"/>
<fo:table-column column-width="25%"/>
<fo:table-column column-width="5%"/>
<fo:table-column column-width="30%"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Telephone:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAdministrativeContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:PhoneNumber">
<fo:inline>
<xsl:text>&#160;</xsl:text>
</fo:inline>
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Email: </xsl:text>
</fo:inline>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAdministrativeContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Email">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block/>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block/>
</fo:table-cell>
</fo:table-row>

                                                        <fo:table-row>
                                                            <fo:table-cell padding="1.5pt" text-align="left" display-align="center" number-columns-spanned="6">
                                                                <fo:block>
                                                                    <fo:inline>
                                                                        <xsl:text>COI Contact email:</xsl:text>
                                                                    </fo:inline>
                                                                    <xsl:for-each select="subcontract:SubContractData">
                                                                        <xsl:for-each select="subcontract:PrimeAdministrativeContact">
                                                                              <xsl:for-each select="subcontract:CoiContactEmail">
                                                                                  <fo:inline>
                                                                                      <xsl:text>&#160;</xsl:text>
                                                                                  </fo:inline>
                                                                                  <xsl:variable name="value-of-template">
                                                                                      <xsl:apply-templates/>
                                                                                  </xsl:variable>
                                                                                  <xsl:choose>
                                                                                      <xsl:when test="contains(string($value-of-template),''&#x2029;'')">
                                                                                          <fo:block>
                                                                                              <xsl:copy-of select="$value-of-template"/>
                                                                                          </fo:block>
                                                                                      </xsl:when>
                                                                                      <xsl:otherwise>
                                                                                          <fo:inline>
                                                                                              <xsl:copy-of select="$value-of-template"/>
                                                                                          </fo:inline>
                                                                                      </xsl:otherwise>
                                                                                  </xsl:choose>
                                                                              </xsl:for-each>
                                                                        </xsl:for-each>
                                                                    </xsl:for-each>
                                                                </fo:block>
                                                            </fo:table-cell>
                                                        </fo:table-row>


</fo:table-body>
</fo:table>

</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>


</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
<fo:block text-align="center">
<fo:leader leader-pattern="rule" rule-thickness="1" leader-length="100%" color="black"/>
</fo:block>
<fo:inline>
<xsl:text>PTE Principal Investigator</xsl:text>
</fo:inline>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table table-layout="fixed" width="100%" border-spacing="2pt">
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="80%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Name:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimePrincipalInvestigator">
<xsl:for-each select="subcontract:FullName">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="80%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Address:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimePrincipalInvestigator">
<xsl:for-each select="subcontract:AddressLine1">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
<fo:block/>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimePrincipalInvestigator">
<xsl:for-each select="subcontract:AddressLine2">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
<fo:block/>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimePrincipalInvestigator">
<xsl:for-each select="subcontract:AddressLine3">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="27%"/>
<fo:table-column column-width="5%"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="30%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>City:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimePrincipalInvestigator">
<xsl:for-each select="subcontract:City">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>State:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell number-columns-spanned="2" padding="2pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimePrincipalInvestigator">
<xsl:for-each select="subcontract:State">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Zip Code: </xsl:text>
</fo:inline>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimePrincipalInvestigator">
<xsl:for-each select="subcontract:PostalCode">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="10%"/>
<fo:table-column column-width="25%"/>
<fo:table-column column-width="5%"/>
<fo:table-column column-width="30%"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Telephone:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimePrincipalInvestigator">
<xsl:for-each select="subcontract:MobilePhoneNumber">
<fo:inline>
<xsl:text>&#160;</xsl:text>
</fo:inline>
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Email: </xsl:text>
</fo:inline>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimePrincipalInvestigator">
<xsl:for-each select="subcontract:EmailAddress">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block/>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block/>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>


</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
<fo:block text-align="center">
<fo:leader leader-pattern="rule" rule-thickness="1" leader-length="100%" color="black"/>
</fo:block>
<fo:inline>
<xsl:text>PTE Financial Contact</xsl:text>
</fo:inline>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table table-layout="fixed" width="100%" border-spacing="2pt">
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="80%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Name:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeFinancialContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:RolodexName">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="80%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Address:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeFinancialContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Address1">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
<fo:block/>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeFinancialContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Address2">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
<fo:block/>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeFinancialContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Address3">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="27%"/>
<fo:table-column column-width="5%"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="30%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>City:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeFinancialContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:City">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>State:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell number-columns-spanned="2" padding="2pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeFinancialContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:StateDescription">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Zip Code: </xsl:text>
</fo:inline>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeFinancialContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Pincode">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="10%"/>
<fo:table-column column-width="25%"/>
<fo:table-column column-width="5%"/>
<fo:table-column column-width="30%"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Telephone:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeFinancialContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:PhoneNumber">
<fo:inline>
<xsl:text>&#160;</xsl:text>
</fo:inline>
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Email: </xsl:text>
</fo:inline>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeFinancialContact">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Email">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block/>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block/>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>


<!--============= New Field PTE Financial Contact, change mapping here=================-->
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="10%"/>
<fo:table-column column-width="25%"/>
<fo:table-column column-width="5%"/>
<fo:table-column column-width="30%"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-body start-indent="0pt">

<fo:table-row>
<fo:table-cell padding="1pt"  number-columns-spanned="2"  display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Email Invoice? </xsl:text>
</fo:inline>
<xsl:choose>
<xsl:when test="subcontract:SubContractData/subcontract:PrimeFinancialContact/subcontract:InvoicesEmailed = &quot;Y&quot;">
<fo:external-graphic content-height="8" content-width="7">
<xsl:attribute name="src">
<xsl:text>url(</xsl:text>
<xsl:call-template name="double-backslash">
<xsl:with-param name="text">
<xsl:value-of select="string(concat(subcontract:SubContractData/subcontract:PrintRequirement/subcontract:ImageCheckedPath,&apos;checked.gif&apos;))"/>
</xsl:with-param>
<xsl:with-param name="text-length">
<xsl:value-of select="string-length(string(concat(subcontract:SubContractData/subcontract:PrintRequirement/subcontract:ImageCheckedPath,&apos;checked.gif&apos;)))"/>
</xsl:with-param>
</xsl:call-template>
<xsl:text>)</xsl:text>
</xsl:attribute>
</fo:external-graphic>
</xsl:when>
<xsl:otherwise>
<fo:external-graphic content-height="8" content-width="7">
<xsl:attribute name="src">
<xsl:text>url(</xsl:text>
<xsl:call-template name="double-backslash">
<xsl:with-param name="text">
<xsl:value-of select="string(concat(subcontract:SubContractData/subcontract:PrintRequirement/subcontract:ImageUncheckedPath,&apos;checkbox.gif&apos;))"/>
</xsl:with-param>
<xsl:with-param name="text-length">
<xsl:value-of select="string-length(string(concat(subcontract:SubContractData/subcontract:PrintRequirement/subcontract:ImageUncheckedPath,&apos;checkbox.gif&apos;)))"/>
</xsl:with-param>
</xsl:call-template>
<xsl:text>)</xsl:text>
</xsl:attribute>
</fo:external-graphic>
</xsl:otherwise>
</xsl:choose>
<fo:inline>
<xsl:text> Yes </xsl:text>
</fo:inline>
<fo:inline font-family="Arial" font-size="8pt">
<xsl:text>&#160;&#160; </xsl:text>
</fo:inline>
<fo:inline>
<xsl:text>Or </xsl:text>
</fo:inline>
<fo:inline font-family="Arial" font-size="8pt">
<xsl:text>&#160;&#160; </xsl:text>
</fo:inline>
<xsl:choose>
<xsl:when test="subcontract:SubContractData/subcontract:PrimeFinancialContact/subcontract:InvoicesEmailed  = &quot;N&quot;">
<fo:external-graphic content-height="8" content-width="7">
<xsl:attribute name="src">
<xsl:text>url(</xsl:text>
<xsl:call-template name="double-backslash">
<xsl:with-param name="text">
<xsl:value-of select="string(concat(subcontract:SubContractData/subcontract:PrintRequirement/subcontract:ImageCheckedPath,&apos;checked.gif&apos;))"/>
</xsl:with-param>
<xsl:with-param name="text-length">
<xsl:value-of select="string-length(string(concat(subcontract:SubContractData/subcontract:PrintRequirement/subcontract:ImageCheckedPath,&apos;checked.gif&apos;)))"/>
</xsl:with-param>
</xsl:call-template>
<xsl:text>)</xsl:text>
</xsl:attribute>
</fo:external-graphic>
</xsl:when>
<xsl:otherwise>
<fo:external-graphic content-height="8" content-width="7">
<xsl:attribute name="src">
<xsl:text>url(</xsl:text>
<xsl:call-template name="double-backslash">
<xsl:with-param name="text">
<xsl:value-of select="string(concat(subcontract:SubContractData/subcontract:PrintRequirement/subcontract:ImageUncheckedPath,&apos;checkbox.gif&apos;))"/>
</xsl:with-param>
<xsl:with-param name="text-length">
<xsl:value-of select="string-length(string(concat(subcontract:SubContractData/subcontract:PrintRequirement/subcontract:ImageUncheckedPath,&apos;checkbox.gif&apos;)))"/>
</xsl:with-param>
</xsl:call-template>
<xsl:text>)</xsl:text>
</xsl:attribute>
</fo:external-graphic>
</xsl:otherwise>
</xsl:choose>
<fo:inline>
<xsl:text> No </xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center" number-columns-spanned="4">
<fo:block>
<fo:inline>
<xsl:text>Invoice email (if different): </xsl:text>
</fo:inline>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeFinancialContact">
<xsl:for-each select="subcontract:InvoiceEmailDifferent">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center" number-columns-spanned="6">
<fo:block>
<fo:inline>
<xsl:text>Invoice Address (if different): </xsl:text>
</fo:inline>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeFinancialContact">
<xsl:for-each select="subcontract:InvoiceAddressDifferent">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>


<!--============= END New Field PTE Financial Contact=================-->



<fo:block text-align="center">
<fo:leader leader-pattern="rule" rule-thickness="1" leader-length="100%" color="black"/>
</fo:block>
<fo:inline>
<xsl:text>PTE Authorized Official</xsl:text>
</fo:inline>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table table-layout="fixed" width="100%" border-spacing="2pt">
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="80%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Name:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAuthorizedOfficial">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:RolodexName">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="80%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Address:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAuthorizedOfficial">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Address1">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
<fo:block/>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAuthorizedOfficial">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Address2">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
<fo:block/>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAuthorizedOfficial">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Address3">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="8%"/>
<fo:table-column column-width="27%"/>
<fo:table-column column-width="5%"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="30%"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>City:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAuthorizedOfficial">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:City">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>State:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell number-columns-spanned="2" padding="2pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAuthorizedOfficial">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:StateDescription">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Zip Code: </xsl:text>
</fo:inline>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAuthorizedOfficial">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Pincode">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="10%"/>
<fo:table-column column-width="25%"/>
<fo:table-column column-width="5%"/>
<fo:table-column column-width="30%"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-body start-indent="0pt">
<fo:table-row>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Telephone:</xsl:text>
</fo:inline>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAuthorizedOfficial">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:PhoneNumber">
<fo:inline>
<xsl:text>&#160;</xsl:text>
</fo:inline>
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" text-align="left" display-align="center">
<fo:block>
<fo:inline>
<xsl:text>Email: </xsl:text>
</fo:inline>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAuthorizedOfficial">
<xsl:for-each select="subcontract:RolodexDetails">
<xsl:for-each select="subcontract:Email">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block/>
</fo:table-cell>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block/>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>

<!--============= New Field Central Email Begin, change email mapping here=================-->
<fo:table font-family="Arial" font-size="9pt" table-layout="fixed" width="100%" border-spacing=".25">
<fo:table-column column-width="20%"/>
<fo:table-column column-width="25%"/>
<fo:table-column column-width="5%"/>
<fo:table-column column-width="20%"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-column column-width="proportional-column-width(1)"/>
<fo:table-body start-indent="0pt">
<fo:table-row>


<fo:table-cell padding="1.5pt" text-align="left" display-align="center" number-columns-spanned="6">
<fo:block>
<fo:inline>
<xsl:text>Central Email: </xsl:text>
</fo:inline>
<xsl:for-each select="subcontract:SubContractData">
<xsl:for-each select="subcontract:PrimeAuthorizedOfficial">
<xsl:for-each select="subcontract:CentralEmail">
<xsl:variable name="value-of-template">
<xsl:apply-templates/>
</xsl:variable>
<xsl:choose>
<xsl:when test="contains(string($value-of-template),''&#x2029;'')">
<fo:block>
<xsl:copy-of select="$value-of-template"/>
</fo:block>
</xsl:when>
<xsl:otherwise>
<fo:inline>
<xsl:copy-of select="$value-of-template"/>
</fo:inline>
</xsl:otherwise>
</xsl:choose>
</xsl:for-each>
</xsl:for-each>
</xsl:for-each>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row>
<fo:table-cell padding="1.5pt" display-align="center">
<fo:block>
<fo:inline-container>
<fo:block>
<xsl:text>&#x2029;</xsl:text>
</fo:block>
</fo:inline-container>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>



<fo:block text-align="center">
<fo:leader leader-pattern="rule" rule-thickness="0.5" leader-length="100%" color="black"/>
</fo:block>
</fo:block>
</fo:table-cell>
</fo:table-row>
</fo:table-body>
</fo:table>
</xsl:for-each>
</fo:block>
<fo:block id="SV_RefID_PageTotal"/>
</fo:flow>
</fo:page-sequence>
</fo:root>
</xsl:template>
<xsl:template name="headerall">
<fo:static-content flow-name="xsl-region-before">
<fo:block/>
</fo:static-content>
</xsl:template>
<xsl:template name="double-backslash">
<xsl:param name="text"/>
<xsl:param name="text-length"/>
<xsl:variable name="text-after-bs" select="substring-after($text, ''\\'')"/>
<xsl:variable name="text-after-bs-length" select="string-length($text-after-bs)"/>
<xsl:choose>
<xsl:when test="$text-after-bs-length = 0">
<xsl:choose>
<xsl:when test="substring($text, $text-length) = ''\\''">
<xsl:value-of select="concat(substring($text,1,$text-length - 1), ''\\'')"/>
</xsl:when>
<xsl:otherwise>
<xsl:value-of select="$text"/>
</xsl:otherwise>
</xsl:choose>
</xsl:when>
<xsl:otherwise>
<xsl:value-of select="concat(substring($text,1,$text-length - $text-after-bs-length - 1), ''\\'')"/>
<xsl:call-template name="double-backslash">
<xsl:with-param name="text" select="$text-after-bs"/>
<xsl:with-param name="text-length" select="$text-after-bs-length"/>
</xsl:call-template>
</xsl:otherwise>
</xsl:choose>
</xsl:template>
</xsl:stylesheet>
','FDP Attachment 3A.xsl','application/octet-stream',1,UUID(),3);
