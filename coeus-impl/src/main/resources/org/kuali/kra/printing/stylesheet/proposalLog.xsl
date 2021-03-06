<?xml version="1.0" encoding="UTF-8"?>
<!--
   - Kuali Coeus, a comprehensive research administration system for higher education.
   -
   - Copyright 2005-2016 Kuali, Inc.
   -
   - This program is free software: you can redistribute it and/or modify
   - it under the terms of the GNU Affero General Public License as
   - published by the Free Software Foundation, either version 3 of the
   - License, or (at your option) any later version.
   -
   - This program is distributed in the hope that it will be useful,
   - but WITHOUT ANY WARRANTY; without even the implied warranty of
   - MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   - GNU Affero General Public License for more details.
   -
   - You should have received a copy of the GNU Affero General Public License
   - along with this program.  If not, see <http://www.gnu.org/licenses/>.
 -->
<!--Designed and generated by Altova StyleVision Enterprise Edition 2008 rel. 2 - see http://www.altova.com/stylevision for more information.-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:xdt="http://www.w3.org/2005/xpath-datatypes" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:output version="1.0" method="xml" encoding="UTF-8" indent="no"/>
	<xsl:param name="SV_OutputFormat" select="'PDF'"/>
	<xsl:variable name="XML" select="/"/>
	<xsl:variable name="fo:layout-master-set">
		<fo:layout-master-set>
			<fo:simple-page-master master-name="default-page" page-height="11in" page-width="8.5in" margin-left="0.1in" margin-right="0.4in">
				<fo:region-body margin-top="0.3in" margin-bottom="0.79in"/>
			</fo:simple-page-master>
		</fo:layout-master-set>
	</xsl:variable>
	<xsl:template match="/">
		<fo:root>
			<xsl:copy-of select="$fo:layout-master-set"/>
			<fo:page-sequence master-reference="default-page" initial-page-number="1" format="1">
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<xsl:for-each select="$XML">
							<fo:inline-container>
								<fo:block>
									<xsl:text>&#x2029;</xsl:text>
								</fo:block>
							</fo:inline-container>
							<fo:table font-family="Verdana" font-size="10pt" line-height="10pt" table-layout="fixed" width="100%" border-spacing="2pt">
								<fo:table-column column-width="15%"/>
								<fo:table-column column-width="20%"/>
								<fo:table-column column-width="15%"/>
								<fo:table-column column-width="20%"/>
								<fo:table-column column-width="10%"/>
								<fo:table-column column-width="20%"/>
								<fo:table-body start-indent="0pt">
									<fo:table-row>
										<fo:table-cell font-size="10pt" number-columns-spanned="6" padding="2pt" height="19" text-align="center" display-align="center">
											<fo:block>
												<fo:inline font-weight="bold" text-decoration="underline">
													<xsl:text>Proposal Log</xsl:text>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell font-size="10pt" padding="2pt" text-align="right" display-align="before">
											<fo:block>
												<fo:inline font-weight="bold">
													<xsl:text>Prop. No.:</xsl:text>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="0" display-align="center">
											<fo:block>
												<xsl:for-each select="proposalLog">
													<xsl:for-each select="proposalNumber">
														<xsl:variable name="value-of-template">
															<xsl:apply-templates/>
														</xsl:variable>
														<xsl:choose>
															<xsl:when test="contains(string($value-of-template),'&#x2029;')">
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
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" text-align="right" display-align="before">
											<fo:block>
												<fo:inline font-weight="bold">
													<xsl:text>Prop. Type:</xsl:text>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-family="Verdana" font-size="10pt" padding-left="0" padding-right="0" padding="2pt" display-align="before">
											<fo:block>
												<xsl:for-each select="proposalLog">
													<xsl:for-each select="proposalType">
														<xsl:for-each select="proposalTypeDesc">
															<xsl:variable name="value-of-template">
																<xsl:apply-templates/>
															</xsl:variable>
															<xsl:choose>
																<xsl:when test="contains(string($value-of-template),'&#x2029;')">
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
										<fo:table-cell font-size="10pt" padding-left="0" padding-right="0" padding="2pt" text-align="right" display-align="before">
											<fo:block>
												<fo:inline font-weight="bold">
													<xsl:text>Status</xsl:text>
												</fo:inline>
												<fo:inline>
													<xsl:text>:</xsl:text>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="0" display-align="center">
											<fo:block>
												<xsl:for-each select="proposalLog">
													<xsl:for-each select="status">
														<xsl:variable name="value-of-template">
															<xsl:apply-templates/>
														</xsl:variable>
														<xsl:choose>
															<xsl:when test="contains(string($value-of-template),'&#x2029;')">
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
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell font-size="10pt" padding="2pt" text-align="right" display-align="before">
											<fo:block>
												<fo:inline font-weight="bold">
													<xsl:text>P.Investigator:</xsl:text>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block>
												<xsl:for-each select="proposalLog">
													<xsl:for-each select="PI">
														<xsl:for-each select="FullName">
															<xsl:variable name="value-of-template">
																<xsl:apply-templates/>
															</xsl:variable>
															<xsl:choose>
																<xsl:when test="contains(string($value-of-template),'&#x2029;')">
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
										<fo:table-cell font-size="10pt" padding-right="0" padding="2pt" text-align="right" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block/>
										</fo:table-cell>
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell font-size="10pt" padding="2pt" text-align="right" display-align="before">
											<fo:block>
												<fo:inline font-weight="bold">
													<xsl:text>Lead Unit:</xsl:text>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block>
												<xsl:for-each select="proposalLog">
													<xsl:for-each select="leadUnit">
														<xsl:for-each select="unitNumber">
															<xsl:variable name="value-of-template">
																<xsl:apply-templates/>
															</xsl:variable>
															<xsl:choose>
																<xsl:when test="contains(string($value-of-template),'&#x2029;')">
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
														<fo:inline>
															<xsl:text>&#160;&#160;&#160; </xsl:text>
														</fo:inline>
														<xsl:for-each select="unitName">
															<xsl:variable name="value-of-template">
																<xsl:apply-templates/>
															</xsl:variable>
															<xsl:choose>
																<xsl:when test="contains(string($value-of-template),'&#x2029;')">
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
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block/>
										</fo:table-cell>
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell font-size="10pt" padding="2pt" text-align="right" display-align="before">
											<fo:block>
												<fo:inline font-weight="bold">
													<xsl:text>Sponsor:</xsl:text>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block>
												<xsl:for-each select="proposalLog">
													<xsl:for-each select="sponsor">
														<xsl:for-each select="sponsorCode">
															<xsl:variable name="value-of-template">
																<xsl:apply-templates/>
															</xsl:variable>
															<xsl:choose>
																<xsl:when test="contains(string($value-of-template),'&#x2029;')">
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
														<fo:inline>
															<xsl:text>&#160;&#160;&#160; </xsl:text>
														</fo:inline>
														<xsl:for-each select="sponsorName">
															<xsl:variable name="value-of-template">
																<xsl:apply-templates/>
															</xsl:variable>
															<xsl:choose>
																<xsl:when test="contains(string($value-of-template),'&#x2029;')">
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
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block>
												<fo:inline>
													<xsl:text>&#160;&#160;&#160; </xsl:text>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell font-size="10pt" padding="2pt" height="20" text-align="right" display-align="before">
											<fo:block>
												<fo:inline font-weight="bold">
													<xsl:text>Title:</xsl:text>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" height="20" display-align="before">
											<fo:block>
												<xsl:for-each select="proposalLog">
													<xsl:for-each select="proposalTitle">
														<xsl:variable name="value-of-template">
															<xsl:apply-templates/>
														</xsl:variable>
														<xsl:choose>
															<xsl:when test="contains(string($value-of-template),'&#x2029;')">
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
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" height="20" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" height="20" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" height="20" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" height="20" display-align="before">
											<fo:block/>
										</fo:table-cell>
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell font-size="10pt" padding="2pt" text-align="right" display-align="before">
											<fo:block>
												<fo:inline font-weight="bold">
													<xsl:text>Comments:</xsl:text>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block>
												<xsl:for-each select="proposalLog">
													<xsl:for-each select="comments">
														<xsl:variable name="value-of-template">
															<xsl:apply-templates/>
														</xsl:variable>
														<xsl:choose>
															<xsl:when test="contains(string($value-of-template),'&#x2029;')">
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
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding-right="0" padding="2pt" text-align="right" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block/>
										</fo:table-cell>
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell font-size="10pt" padding="2pt" text-align="right" display-align="center">
											<fo:block>
												<fo:inline font-weight="bold">
													<xsl:text>User:</xsl:text>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block>
												<xsl:for-each select="proposalLog">
													<xsl:for-each select="updateUser">
														<xsl:variable name="value-of-template">
															<xsl:apply-templates/>
														</xsl:variable>
														<xsl:choose>
															<xsl:when test="contains(string($value-of-template),'&#x2029;')">
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
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding-right="0" padding="2pt" text-align="right" display-align="before">
											<fo:block>
												<fo:inline font-weight="bold">
													<xsl:text>Timestamp:</xsl:text>
												</fo:inline>
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="2pt" display-align="before">
											<fo:block>
												<xsl:for-each select="proposalLog">
													<xsl:for-each select="updateTimeStamp">
														<xsl:variable name="value-of-template">
															<xsl:apply-templates/>
														</xsl:variable>
														<xsl:choose>
															<xsl:when test="contains(string($value-of-template),'&#x2029;')">
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
											</fo:block>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="0" display-align="center">
											<fo:block/>
										</fo:table-cell>
										<fo:table-cell font-size="10pt" padding="0" display-align="center">
											<fo:block/>
										</fo:table-cell>
									</fo:table-row>
									<fo:table-row>
										<fo:table-cell number-columns-spanned="6" padding="2pt" display-align="center">
											<fo:block>
												<fo:block text-align="center">
													<fo:leader leader-pattern="rule" rule-thickness="1" leader-length="100%" color="black"/>
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
	<xsl:template name="double-backslash">
		<xsl:param name="text"/>
		<xsl:param name="text-length"/>
		<xsl:variable name="text-after-bs" select="substring-after($text, '\')"/>
		<xsl:variable name="text-after-bs-length" select="string-length($text-after-bs)"/>
		<xsl:choose>
			<xsl:when test="$text-after-bs-length = 0">
				<xsl:choose>
					<xsl:when test="substring($text, $text-length) = '\'">
						<xsl:value-of select="concat(substring($text,1,$text-length - 1), '\\')"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="$text"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="concat(substring($text,1,$text-length - $text-after-bs-length - 1), '\\')"/>
				<xsl:call-template name="double-backslash">
					<xsl:with-param name="text" select="$text-after-bs"/>
					<xsl:with-param name="text-length" select="$text-after-bs-length"/>
				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>
