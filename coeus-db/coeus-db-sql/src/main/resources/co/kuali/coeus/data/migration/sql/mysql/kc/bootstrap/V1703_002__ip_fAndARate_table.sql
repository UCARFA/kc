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
-- along with this program.  If not, see <http://www.gnu.org/lincenses/>.
--

RENAME TABLE proposal_idc_rate TO PROPOSAL_UNRECOVERED_FNA_RATE;

CREATE TABLE PROPOSAL_FNA_RATE (
  PROPOSAL_FNA_RATE_ID DECIMAL(12),
  PROPOSAL_ID DECIMAL(12,0) NOT NULL,
  RATE_CLASS_CODE VARCHAR(3),
  RATE_TYPE_CODE VARCHAR(3),
  FISCAL_YEAR CHAR(4),
  AMOUNT DECIMAL(12,2),
  ON_OFF_CAMPUS_FLAG CHAR(1) NOT NULL,
  ACTIVITY_TYPE_CODE VARCHAR(3) NOT NULL,
  START_DATE DATETIME,
  APPLICABLE_RATE DECIMAL(5,2) NOT NULL,
  INSTITUTE_RATE DECIMAL(5,2),
  UPDATE_TIMESTAMP DATETIME NOT NULL,
  UPDATE_USER VARCHAR(60) NOT NULL,
  VER_NBR DECIMAL(8) default 1 NOT NULL,
  OBJ_ID VARCHAR(36) NOT NULL,
  CONSTRAINT EPS_PROP_RATESP1 PRIMARY KEY(PROPOSAL_FNA_RATE_ID),
  CONSTRAINT FK_FNA_RATE_PROPOSAL_ID FOREIGN KEY (PROPOSAL_ID)
    REFERENCES PROPOSAL(PROPOSAL_ID)
  );

CREATE TABLE SEQ_PROPOSAL_FNA_RATE_ID
(
	id bigint(19) not null auto_increment, primary key (id)
) ENGINE MyISAM;

ALTER TABLE SEQ_PROPOSAL_FNA_RATE_ID auto_increment = 1;
