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

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.16.1', 'This information pertains to the Applicant information which is centrally maintained on the Organization Record. The system administrator may modify these records.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.16.2', 'This information pertains to the Applicant information which is centrally maintained on the Organization Record. The system administrator may modify these records.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.17.1', 'This information pertains to the Applicant information which is centrally maintained on the Organization Record. The system administrator may modify these records.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.17.2', '',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.17.3', 'This information pertains to the Applicant information which is centrally maintained on the Organization Record. The system administrator may modify these records.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.19.1', 'This information pertains to the Applicant information which is centrally maintained on the Organization Record. The system administrator may modify these records.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.19.2', 'This information pertains to the Applicant information which is centrally maintained on the Organization Record. The system administrator may modify these records.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.101.1', 'This information pertains to the Person to Contact information which is centrally maintained on the Person Record and assigned via the Administrator table. The system administrator may modify these records.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.104.1', 'This information pertains to the Person to Contact information which is centrally maintained on the Person Record and assigned via the Administrator table. The system administrator may modify these records.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.104.2', 'This information pertains to the Person to Contact information which is centrally maintained on the Person Record and assigned via the Administrator table. The system administrator may modify these records.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.28.1', 'This information is centrally maintained on the Organization Record. The system administrator may modify these records.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.33.1', '',
'0', '1', 'PropDev-Details', 'PropDev-Details-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.33.2', 'Please review the S2S Opportunity selected on the S2S tab as well as the Proposal Type selected on the Proposal Details screen',
'0', '1', 'PropDev-Details', 'PropDev-Details-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.33.26', 'Please review the S2S Opportunity selected on the S2S tab as well as the Proposal Type selected on the Proposal Details screen',
'0', '1', 'PropDev-Details', 'PropDev-Details-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.33.29', 'Please review the S2S Opportunity selected on the S2S tab as well as the Proposal Type selected on the Proposal Details screen',
'0', '1', 'PropDev-Details', 'PropDev-Details-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.41.1', '',
'0', '1', 'PropDev-Details', 'PropDev-Details-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.42.3', 'Please review your budget start and end dates',
'0', '1', 'PropDev-BudgetPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.42.8', '',
'0', '1', 'PropDev-BudgetPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.42.4', 'Please review your budget start and end dates',
'0', '1', 'PropDev-BudgetPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.42.5', '',
'0', '1', 'PropDev-BudgetPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.42.6', 'Please review your budget start and end dates',
'0', '1', 'PropDev-BudgetPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.42.7', '',
'0', '1', 'PropDev-BudgetPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.42.9', 'Please review your budget start and end dates',
'0', '1', 'PropDev-BudgetPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.42.10', 'Please review your budget start and end dates',
'0', '1', 'PropDev-BudgetPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.42.11', 'Please review your budget start and end dates',
'0', '1', 'PropDev-BudgetPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.43.1', 'Please correct the Applicant Congressional Distrtict ',
'0', '1', 'PropDev-OrganizationLocationsPage', 'PropDev-ApplicantOrganizationPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.45.1', 'Please correct the PD/Contact ERA Commons name in either this proposal or the commons',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.21.2', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.21.1', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.21.3', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.21.5', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.21.6', '',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.21.7', '',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.21.8', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.21.9', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.31.1', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.57.2', 'The system administrator may modify the state on the PD/PI person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.57.3', 'The system administrator may modify the state on the PD/PI person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.58.1', 'The system administrator may modify the province on the PD/PI person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.58.2', 'The system administrator may modify the province on the PD/PI person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.58.3', 'The system administrator may modify the province on the PD/PI person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.60.1', 'The system administrator may modify the zip code on the PD/PI person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.60.2', 'The system administrator may modify the zip code on the PD/PI person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.41.1', 'The system administrator may modify the state on the Key Personnel person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.41.2', 'The system administrator may modify the state on the Key Personnel person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.42.1', 'The system administrator may modify the province on the Key Personnel person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.42.2', 'The system administrator may modify the province on the Key Personnel person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.42.3', 'The system administrator may modify the province on the Key Personnel person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.44.1', 'The system administrator may modify the zip code on the Key Personnel person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.44.2', 'The system administrator may modify the zip code on the Key Personnel person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.48.1', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.48.2', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.48.4', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.48.5', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.48.6', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.48.7', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.48.8', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.48.9', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.48.10', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.49.3', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.49.4', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.49.5', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.49.6', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.50.1', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.63.1', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.14.1', 'The system administrator may modify the state on the PD/PI person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.15.1', 'The system administrator may modify the province on the PD/PI person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.15.2', 'The system administrator may modify the province on the PD/PI person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.15.3', 'The system administrator may modify the province on the PD/PI person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.17.1', 'The system administrator may modify the zip code on the PD/PI person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.17.2', 'The system administrator may modify the zip code on the PD/PI person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.64.2', '',
'0', '1', 'PropDev-BudgetPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.65.1', '',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.68.1', 'Review answers on the Grants.gov S2S Questionnaire.',
'0', '1', 'PropDev-QuestionnairePage', 'PropDev-QuestionnairePage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.72.1', 'If you should want to change the Authorized Representative name, the system administrator may modify the person record.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.85.2', 'The system administrator may modify the state on the Authorized Representative person record.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.85.3', 'The system administrator may modify the state on the Authorized Representative person record.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.86.1', 'The system administrator may modify the province on the Authorized Representative person record.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.86.2', 'The system administrator may modify the province on the Authorized Representative person record.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.86.3', 'The system administrator may modify the province on the Authorized Representative person record.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.88.1', 'The system administrator may modify the zip code on the Authorized Representative person record.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.88.2', 'The system administrator may modify the zip code on the Authorized Representative person record.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.91.3', 'The system administrator may modify the zip code on the Authorized Representative person record, or the address book if person is a non-employee.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.94.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalDetails', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.94.2', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalDetails', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.94.3', 'Review your funding opportunity announcement. Coverletter may be removed from the attachments page.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalDetails', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.26.2', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-PersonnelSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.26.3', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-PersonnelSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.27.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-PersonnelSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.53.2', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-PersonnelSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '005.53.3', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-PersonnelSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '003.3.1', 'The DUNS number is maintained centrally and must be modified on the organization record by a system administrator',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '003.8.1', 'The state is maintained centrally and must be modified on the organization record by a system administrator',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '003.8.2', 'The state is maintained centrally and must be modified on the organization record by a system administrator',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '003.9.1', 'The province is maintained centrally and must be modified on the organization record by a system administrator',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '003.9.2', 'The province is maintained centrally and must be modified on the organization record by a system administrator',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '003.9.3', 'The province is maintained centrally and must be modified on the organization record by a system administrator',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '003.10.1', 'The zip code is maintained centrally and must be modified on the organization record by a system administrator',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '003.10.2', 'The zip code is maintained centrally and must be modified on the organization record by a system administrator',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '003.12.1', 'Add a congressional district to the Performing Organization listed.',
'0', '1', 'PropDev-OrganizationLocationsPage', 'PropDev-PerformingOrganizationPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '003.12.2', '',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.1.1', '',
'0', '1', 'PropDev-CompliancePage', 'PropDev-CompliancePage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.1.3', 'If Human Subjects compliance entry has been added, the answer selected on the Cover Page Supplement should be Yes.',
'0', '1', 'PropDev-QuestionnairePage', 'PropDev-QuestionnairePage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.1.8', 'Review the Compliance page to ensure human subjects have not been added.',
'0', '1', 'PropDev-CompliancePage', 'PropDev-CompliancePage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.1.9', 'Review the Compliance page to ensure human subjects have not been added.',
'0', '1', 'PropDev-CompliancePage', 'PropDev-CompliancePage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.3.4', '',
'0', '1', 'PropDev-OpportunityPage', 'PropDev-OpportunityPage-AddUserAttachedForm', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.3.5', '',
'0', '1', 'PropDev-OpportunityPage', 'PropDev-OpportunityPage-AddUserAttachedForm', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.7.1', 'Review your compliance entry for animal protocols to ensure completeness',
'0', '1', 'PropDev-CompliancePage', 'PropDev-CompliancePage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.7.6', '',
'0', '1', 'PropDev-CompliancePage', 'PropDev-CompliancePage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.9.1', '',
'0', '1', 'PropDev-CompliancePage', 'PropDev-CompliancePage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.10.1', '',
'0', '1', 'PropDev-CompliancePage', 'PropDev-CompliancePage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.10.2', 'Animal Assurance Numbers are centrally maintained and may be modified on the organization record by a system administraor.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.20.2', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-Attachments-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.20.3', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-Attachments-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.21.2', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-Attachments-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.22.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-Attachments-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.22.2', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-Attachments-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.22.3', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-Attachments-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.23.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-Attachments-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.24.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-Attachments-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '004.25.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-Attachments-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '008.1.2', '',
'0', '1', 'PropDev-QuestionnairePage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '008.1.6', '',
'0', '1', 'PropDev-QuestionnairePage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '008.25.1', '',
'0', '1', 'PropDev-QuestionnairePage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '008.25.2', '',
'0', '1', 'PropDev-QuestionnairePage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '008.26.4', '',
'0', '1', 'PropDev-QuestionnairePage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '008.21.5', '',
'0', '1', 'PropDev-QuestionnairePage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '008.23.3', '',
'0', '1', 'PropDev-QuestionnairePage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '008.27.2', '',
'0', '1', 'PropDev-QuestionnairePage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '008.29.1', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '008.29.2', '',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '008.36.1', '',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '008.40.2', '',
'0', '1', 'PropDev-BudgetPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '018.0.4', '',
'0', '1', 'PropDev-BudgetPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '018.1.2', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '018.3.2', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '018.3.3', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '018.3.4', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '018.4.1', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '018.5.1', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '018.5.2', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '018.8.1', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '018.9.1', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '018.12.2', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '018.13.1', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '018.13.3', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '019.1.2', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '019.1.3', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '019.2.2', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '019.3.2', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '019.5.2', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '019.6.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-Attachments-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.0.2', '',
'0', '1', 'PropDev-OpportunityPage', 'PropDev-OpportunityPage-AddUserAttachedForm', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.0.3', '',
'0', '1', 'PropDev-OpportunityPage', 'PropDev-OpportunityPage-AddUserAttachedForm', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.0.4', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '022.0.3', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.2.1', 'Ensure that the Subaward Organization has a DUNS number included on the centrally maintained organization record. Contact a system admnistrator for assistance.',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.4.1', '',
'0', '1', 'PropDev-Details', 'PropDev-Details-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.10.2', 'Please include the PI effort in the Assign Personnel. If no salary support for the investigator is requested, then add zero for the % charge. ',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.12.1', 'Please include a value greater than zero for personnel effort in the Assign Personnel. If no salary support for the investigator is requested, then add zero for the % charge. ',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '022.12.1', 'Please include a value greater than zero for personnel effort in the Assign Personnel. If no salary support for the investigator is requested, then add zero for the % charge. ',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '022.10.2', 'Please include the PI effort in the Assign Personnel. If no salary support for the investigator is requested, then add zero for the % charge. ',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.12.2', 'Please include a value greater than zero for personnel effort in the Assign Personnel. If no salary support for the investigator is requested, then add zero for the % charge. ',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.12.3', 'Please include the PI effort in the Assign Personnel. If no salary support for the investigator is requested, then add zero for the % charge. ',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.13.1', 'Make any adjustments to your calendar or academic effort on th Adjust Personnel page.',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '022.12.2', 'Make any adjustments to your calendar or academic effort on th Adjust Personnel page.',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.34.1', 'Participants may be maintatined under Non-personnel, participant expenses.',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '022.44.1', 'Participants may be maintatined under Non-personnel, participant expenses.',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.52.1', ' Please review the modular budget section.',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.52.2', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.52.3', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.52.4', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.53.1', ' Review the Rates section entry of applicable rate. ',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.53.2', 'Career submissions require an applicable rate of 8. ',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '022.62.2', 'Career submissions require an applicable rate of 8.',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '020.54.1', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '022.0.1', '',
'0', '1', 'PropDev-OpportunityPage', 'PropDev-OpportunityPage-AddUserAttachedForm', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '022.0.2', '',
'0', '1', 'PropDev-OpportunityPage', 'PropDev-OpportunityPage-AddUserAttachedForm', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '022.12.3', 'Make any adjustments to your calendar or academic effort on th Adjust Personnel page.',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '022.61.2', 'Select the Modular Budget form to include in your submission.',
'0', '1', 'PropDev-OpportunityPage', 'PropDev-OpportunityPage-AddUserAttachedForm', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '022.61.3', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '022.61.4', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '022.61.5', '',
'0', '1', 'PropDev-Budget', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.1.1', 'An introduction may be added on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.1.2', 'An introduction may be added on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.1.3', 'An introduction may be removed on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.1.5', 'An introduction may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.1.7', 'An introduction may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.3.3', 'The Research Strategy attachment may be replaced within the Proposal Attachments section.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.3.4', 'The Research Strategy attachment may be replaced within the Proposal Attachments section.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.3.5', 'The Research Strategy attachment may be replaced within the Proposal Attachments section.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.3.6', 'The Research Strategy attachment may be replaced within the Proposal Attachments section.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.3.7', 'The Research Strategy attachment may be replaced within the Proposal Attachments section.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.3.8', 'The Research Strategy attachment may be replaced within the Proposal Attachments section.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.3.9', 'The Research Strategy attachment may be replaced within the Proposal Attachments section.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.3.10', 'The Research Strategy attachment may be replaced within the Proposal Attachments section.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.3.11', 'The Research Strategy attachment may be replaced within the Proposal Attachments section.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.3.12', 'The Research Strategy attachment may be replaced within the Proposal Attachments section.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.3.13', 'The Research Strategy attachment may be replaced within the Proposal Attachments section.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.3.14', 'The Research Strategy attachment may be replaced within the Proposal Attachments section.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.3.15', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.4.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.4.2', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.17.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.7.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.9.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.10.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.12.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.12.2', 'Review the Key Personnel Roles  against the Proposal Attachments added.',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-Details', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.14.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '010.16.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.1.1', 'An Introduction may be added on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.1.2', 'An Introduction may be added on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.1.3', 'An Introduction may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.1.4', 'An Introduction may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.1.5', 'The Introduction may be removed on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.2.1', 'Attach a Candidate Information and Goals Attachment.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.1.3', 'An Introduction may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.1.4', 'An Introduction may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.1.5', 'An Introduction may be removed on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.2.1', 'PHS-ResTrainingPlan_Background should be selected as the attachment type. ',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.2.2', 'Review the page count for all of the attachments combined. You may want to copy and paste all into a document to confirm. ',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.2.3', 'Review the page count for all of the attachments combined. You may want to copy and paste all into a document to confirm. ',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.3.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.4.2', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.5.1', 'PHS_Career_Training_Resp_Conduct_Research should be selected as the attachment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.5.2', 'The Responsible Conduct of Research attachment may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.6.1', 'The Mentoring Plan attachment may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.6.2', 'The Mentoring Plan attachment may be removed on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.6.3', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.7.2', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.7.3', 'The Mentor Statements attachment may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.7.4', 'PHS_Career_Mentor_Statements_Letters should be selected as the attachment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.10.2', 'PHS_Career_Inst_Commitment should be selected as the attachment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.10.1', 'The Institutional Commitment attachment may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.11.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.11.2', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.15.1', 'PHS_Career_ProtectionOfHumanSubjects should be selected as the attahcment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.16.1', 'PHS_Career_InclusionOfWomenAndMinorities should be selected as the attachment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.18.1', 'PHS_Career_InclusionOfChildren should be selected as the attachment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.19.1', 'PHS_Career_VertebrateAnimals should be selected as the attachment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.23.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.24.1', 'The citizenship details are modifiyable from the person\'s Extended Details tab.',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-ExtendedDetailsPersonal', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.24.2', 'The citizenship details are modifiyable from the person\'s Extended Details tab.',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-ExtendedDetailsPersonal', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.24.6', 'The citizenship details are modifiyable from the person\'s Extended Details tab.',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-ExtendedDetailsPersonal', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.24.7', 'The citizenship details are modifiyable from the person\'s Extended Details tab.',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-ExtendedDetailsPersonal', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.24.8', 'The citizenship details are modifiyable from the person\'s Extended Details tab.',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-ExtendedDetailsPersonal', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.24.9', 'The citizenship details are modifiyable from the person\'s Extended Details tab.',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-ExtendedDetailsPersonal', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.25.1', 'PHS_Career_Goals_Objectives should be selected as the attachment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.25.2', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.25.3', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '013.26.1', 'PHS-ResTrainingPlan_DataSafetyMonitorPlan should be selected as the attachment type. ',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.2.4', 'Review the number of pages for your attachments for Background, Program Plan, and Recruitment and Retention Plan to Enhance Diversity
',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.2.5', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.3.1', 'PHS-ResTrainingPlan_ProgramPlan should be selected as the attachment type. ',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.3.2', 'The Program Plan attachment may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.4.1', 'PHS-ResTrainingPlan_RecruitmentPlan should be selected as the attachment type. ',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.5.1', 'PHS-ResTrainingPlan_RespConductResearch should be selected as the attachment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.5.2', 'The Plan for Responsible Conduct of Research attachment may be replaced on the Proposal tab of the Attachments screen. See <a href="https://grants.nih.gov/grants/guide/notice-files/NOT-OD-10-019.html" target="_blank">NIH guidelines for RCR</a>',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.17.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.17.2', 'The Methods for Enhancing Reproducibility attachment may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.6.1', 'PHS-ResTrainingPlan_ProgressReport should be selected as the attachment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.6.2', 'The Progress Report attachment may be removed on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.7.1', 'PHS-ResTrainingPlan_HumanSubjects should be seleced as the attachment type. ',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.18.1', 'PHS-ResTrainingPlan_DataSafetyMonitorPlan should be selected as the attachment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.8.1', 'PHS-ResTrainingPlan_VertAnimals should be selected as the attachment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.10.1', 'PHS-ResTrainingPlan_PILeadershipPlan should be selected as the attachment type. If Multi-PI is not planned, review the person roles on the Key Personnel page. ',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.10.2', 'PHS-ResTrainingPlan_PILeadershipPlan should be selected as the attachment type. If Multi-PI is not planned, review the person roles on the Key Personnel page. ',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.12.1', 'PHS-ResTrainingPlan_FacBiosketches should be selected as the attachment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.13.1', 'PHS-ResTrainingPlan_DataTables should be selected as the attachment type.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '014.16.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '015.7.1', 'Complete the number of trainees on the questionnaire PHS398 Training Budget',
'0', '1', 'PropDev-QuestionnairePage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '015.48.1', 'Complete the training related expenses on the questionnaire PHS398 Training Budget',
'0', '1', 'PropDev-QuestionnairePage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '015.54.1', 'Training projects must be calculated at an indirect rate of 8%, please review your activity type and budget applicable rate.',
'0', '1', 'PropDev-DetailsPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.1.1', 'An Introduction may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.1.2', 'An Introduction may be added on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.2.1', '',
'0', '1', '', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.3.1', 'The Research Strategy may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.10.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.15.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.18.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.23.1', 'Review your entries on the Fellowship Supplemental Questionnaire',
'0', '1', 'PropDev-QuestionnairePage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.37.1', 'The Goals for Fellowship Training and Career may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.38.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.40.1', 'Review the citizenship type selected on the person\'s Extended Details.',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-ExtendedDetailsPersonal', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.40.7', 'Review the citizenship type selected on the person\'s Extended Details.',
'0', '1', 'PropDev-PersonnelPage', 'PropDev-PersonnelPage-ExtendedDetailsPersonal', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.43.2', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.47.1', 'Ensure that the Senior Fellowship question has been answered Yes, so that the base salary question appears.',
'0', '1', 'PropDev-QuestionnairePage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.56.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.57.1', 'See the <a href="https://grants.nih.gov/grants/how-to-apply-application-guide/forms-d/general/g.430-phs-fellowship-supplemental-form.htm"> Fellowship Guidelines for more information. </a>',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.58.1', 'The Letters of Support from Collaborators may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.59.1', 'The Description of Institutional Environmental and Committment to Training may be added on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.59.2', 'The Description of Institutional Environmental and Committment to Training may be replaced on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '024.60.1', 'The Data Safetly Monitoring Plan may be added on the Proposal tab of the Attachments screen.',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-Section', '1', 'admin', NOW(), '1', UUID());
