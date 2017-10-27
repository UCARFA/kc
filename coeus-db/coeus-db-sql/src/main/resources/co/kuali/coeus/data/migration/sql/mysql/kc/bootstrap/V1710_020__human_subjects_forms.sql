--
-- Kuali Coeus, a comprehensive research administration system for higher education.
--
-- Copyright 2005-2017 Kuali, Inc.
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

CREATE TABLE eps_prop_spl_review_attachment (
	PROPOSAL_SPECIAL_REVIEW_ATT_ID decimal(12,0) NOT NULL,
	FILE_NAME varchar(150) DEFAULT NULL,
	CONTENT_TYPE varchar(255)DEFAULT NULL,
	STUDY_TITLE varchar(600),
	IS_ATTACHMENT_DELAYED_ONSET char(1),
	CLINICAL_TRIAL char(1),
	UPDATE_USER varchar(60) NOT NULL,
	UPDATE_TIMESTAMP datetime NOT NULL,
	VER_NBR decimal(8,0) NOT NULL DEFAULT '1',
	OBJ_ID varchar(36) NOT NULL,
	FILE_DATA_ID varchar(36) NOT NULL,
	UPLOAD_TIMESTAMP datetime NOT NULL,
	UPLOAD_USER varchar(100) NOT NULL,
	PRIMARY KEY (PROPOSAL_SPECIAL_REVIEW_ATT_ID),
	CONSTRAINT FK_SPL_RVW_FILE_ID FOREIGN KEY (FILE_DATA_ID) REFERENCES file_data (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE SEQ_EPS_PROP_SPL_RVW_ATT_ID
(
    id bigint(19) not null auto_increment, primary key (id)
) ENGINE MyISAM;

alter table EPS_PROP_SPECIAL_REVIEW add PROPOSAL_SPECIAL_REVIEW_ATT_ID decimal(12,0);

INSERT INTO SEQ_S2S_FORM_CONFIG_ID VALUES (NULL);
INSERT INTO S2S_FORM_CONFIG(S2S_FORM_CONFIG_ID,FORM_NAME,ACTIVE_FLAG,INACTIVE_MESSAGE,VER_NBR,OBJ_ID,UPDATE_TIMESTAMP,UPDATE_USER) VALUES
    ((SELECT MAX(id) FROM SEQ_S2S_FORM_CONFIG_ID),'PHS_HumanSubjectsAndClinicalTrialsInfo_V1.0','N','The form is still undergoing testing. Expect it to be available soon.','1',UUID(),NOW(),'admin');