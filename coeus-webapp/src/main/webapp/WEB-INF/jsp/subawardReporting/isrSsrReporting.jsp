<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<%@ include file="/WEB-INF/jsp/kraTldHeader.jsp"%>        	
 <c:set var="KualiForm" value="${IsrSsrReportGenerationForm}" scope="request"/>   
<kul:page  docTitle="ISR/SSR Reporting"  transactionalDocument="false" 
htmlFormAction="isrSsrReporting">
	<kul:tabTop tabTitle="Generate Report" defaultOpen="true" tabErrorKey="awardNo">
		 <div class="tab-container" align="center">
			<h3>
				<span class="subhead-left">Generate Report</span>
			</h3>
			 <table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<th align="right" valign="center" width="44%"><c:out
										value="Report:"/>
					</th>
					<td><html:select property="reportName">
								<html:option value="SF294" />
								<html:option value="SF295" />
							</html:select>
					</td>
				</tr>
				<tr>
				<th align="right" valign="center" width="44%"><c:out
										value="Award No:"/>
				</th>
				<td align="left">
				<html:text property="awardNo" size="20" maxlength="20" styleId = "awardNo"/>
									<kul:lookup boClassName="org.kuali.kra.award.home.Award"
                			    	fieldConversions="awardNumber:awardNo" />
				</td>
				</tr>				
				<tr>
				<th align="right" valign="center" width="44%"><c:out
										value="Report Type:"/>
				</th>
				<td><c:out value="Regular"/>
				<html:radio property="reportType" value="Regular" />
				<c:out value="Final"/>
				<html:radio property="reportType" value="Final" />
				<c:out value="Revised"/>
				<html:radio property="reportType" value="Revised" />
				</td>				
				</tr>
			</table>
		</div>
	</kul:tabTop>	
	<kul:panelFooter />
	<br><br>
		<div align="center">
		<html:image property="methodToCall.printReport"
										src='${ConfigProperties.kra.externalizable.images.url}buttonsmall_report.gif' onclick="excludeSubmitRestriction=true"/>		
	<html:image property="methodToCall.close" src="${ConfigProperties.kr.externalizable.images.url}buttonsmall_close.gif" styleClass="globalbuttons" title="close" alt="close" />
	</div>												
    </kul:page>




