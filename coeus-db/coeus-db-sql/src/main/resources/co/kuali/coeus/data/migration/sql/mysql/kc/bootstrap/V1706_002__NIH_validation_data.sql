--
-- Kuali Coeus, a comprehensive research administration system for higher education.
--
-- Copyright 2005-2015 Kuali, Inc.
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

alter table NIH_VALIDATION_MAPPING MODIFY COLUMN PAGE_ID VARCHAR(50);

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.3', 'Please correct the DUNS number on the submitting organization maintenace record',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.11', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.27', '',
'0', '1', 'PropDev-OpportunityPage', 'PropDev-OpportunityPage-Forms', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.28', '',
'0', '1', 'PropDev-OpportunityPage', 'PropDev-OpportunityPage-Forms', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.31', 'Your submitting institution will take action on the proposers behalf. No action is necessary.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.38', 'Please confirm that your selection of funding opportunity announcement is correct.',
'0', '1', 'PropDev-OpportunityPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.37', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.8', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.9', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.1', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.13', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.2', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.21', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.23', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-PersonnelSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.25', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.26', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.34', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '0.35', '',
'0', '1', 'PropDev-AttachmentsPage', 'PropDev-AttachmentsPage-ProposalSection', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '01.1.1', '',
'0', '1', 'PropDev-DetailsPage', 'PropDev-DetailsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.1.2', '',
'0', '1', 'PropDev-OpportunityPage', 'PropDev-OpportunityPage-General', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.1.3', 'Please review the Sponsor Proposal number and or Previous Grants.gov number .',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.1.5', '',
'0', '1', 'PropDev-OpportunityPage', 'PropDev-OpportunityPage-General', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.1.6', '',
'0', '1', 'PropDev-DetailsPage', 'PropDev-DetailsPage-Section', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.1.4', '',
'0', '1', 'PropDev-SponsorProgramInfoPage', '', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.1.6.2', '',
'0', '1', 'PropDev-SponsorProgramInfoPage', 'Sponsor Proposal ID', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.1.6.3', '',
'0', '1', 'PropDev-SponsorProgramInfoPage', 'Sponsor Proposal ID', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.1.6.4', '',
'0', '1', 'PropDev-SponsorProgramInfoPage', 'Sponsor Proposal ID', '1', 'admin', NOW(), '1', UUID());

insert into SEQ_NIH_VALIDATION values (null);
insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.6.5', 'If the Sponsor Proposal ID listed is correct, check the Questionnaire for Cover Page Supplement and the Key Personnel to ensure that the PD/PI listed is correct.',
'0', '1', 'PropDev-SponsorProgramInfoPage', '', '1', 'admin', NOW(), '1', UUID());
