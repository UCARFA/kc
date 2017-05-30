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

INSERT INTO NOTIFICATION_TYPE (NOTIFICATION_TYPE_ID, MODULE_CODE, ACTION_CODE, DESCRIPTION, SUBJECT, MESSAGE, PROMPT_USER, SEND_NOTIFICATION, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID)
VALUES (SEQ_NOTIFICATION_TYPE_ID.NEXTVAL, 3, '910','Proposal Development record has been created.',
'Proposal No.{PROPOSAL_NUMBER} in Department {LEAD_UNIT} - {LEAD_UNIT_NAME} has been created by {PROPOSAL_INITIATOR_NAME}',
'Attention Office of Sponsored Programs <br/> Proposal No. {PROPOSAL_NUMBER} has been created in Kuali Research. <br/> Proposal No: {PROPOSAL_NUMBER} <br/> Proposal Initiator: {PROPOSAL_INITIATOR_NAME} <br/>Department: {LEAD_UNIT} - {LEAD_UNIT_NAME} </br>Sponsor: <br/>{SPONSOR_CODE} - {SPONSOR_NAME} <br/>Proposal Title:<br/>{PROPOSAL_TITLE}<br/>Due Date:<br/>{DEADLINE_DATE}',
'N', 'N', 'admin', SYSDATE, 1, SYS_GUID());

INSERT INTO NOTIFICATION_TYPE_RECIPIENT (NOTIFICATION_TYPE_RECIPIENT_ID, NOTIFICATION_TYPE_ID, ROLE_NAME, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID)
VALUES (SEQ_NOTIFICATION_TYPE_ID.NEXTVAL, (select NOTIFICATION_TYPE_ID from notification_type where MODULE_CODE = 3 and ACTION_CODE = '910'), 'KC-PD:All Unit Administrators', 'admin', SYSDATE, 1, SYS_GUID());

INSERT INTO NOTIFICATION_TYPE_RECIPIENT (NOTIFICATION_TYPE_RECIPIENT_ID, NOTIFICATION_TYPE_ID, ROLE_NAME, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID)
VALUES (SEQ_NOTIFICATION_TYPE_ID.NEXTVAL, (select NOTIFICATION_TYPE_ID from notification_type where MODULE_CODE = 3 and ACTION_CODE = '910'),'KC-ADM:OSP Administrator', 'admin', SYSDATE, 1, SYS_GUID());

insert into NOTIFICATION_MODULE_ROLE (NOTIFICATION_MODULE_ROLE_ID, MODULE_CODE, ROLE_NAME, OBJ_ID, VER_NBR, UPDATE_TIMESTAMP, UPDATE_USER)
VALUES (SEQ_NTFCTN_MODULE_ROLE_ID.NEXTVAL, 3, 'KC-ADM:OSP Administrator', SYS_GUID(), 1, SYSDATE, 'admin');