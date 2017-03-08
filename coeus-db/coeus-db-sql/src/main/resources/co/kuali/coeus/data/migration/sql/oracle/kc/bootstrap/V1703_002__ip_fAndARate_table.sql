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

RENAME proposal_idc_rate TO PROPOSAL_UNRECOVERED_FNA_RATE;

CREATE TABLE PROPOSAL_FNA_RATE (
  PROPOSAL_FNA_RATE_ID NUMBER(12,0) NOT NULL PRIMARY KEY,
  PROPOSAL_ID NUMBER(12,0) NOT NULL,
  RATE_CLASS_CODE VARCHAR2(3),
  RATE_TYPE_CODE VARCHAR2(3),
  FISCAL_YEAR CHAR(4),
  AMOUNT NUMBER(12,2),
  ON_OFF_CAMPUS_FLAG CHAR(1) NOT NULL,
  ACTIVITY_TYPE_CODE VARCHAR2(3) NOT NULL,
  START_DATE DATE,
  APPLICABLE_RATE NUMBER(5,2) NOT NULL,
  INSTITUTE_RATE NUMBER(5,2),
  UPDATE_TIMESTAMP DATE NOT NULL,
  UPDATE_USER VARCHAR2(60) NOT NULL,
  VER_NBR NUMBER(8) DEFAULT 1 NOT NULL ,
  OBJ_ID VARCHAR2(36) NOT NULL
  );

alter table PROPOSAL_FNA_RATE add constraint FK_FNA_RATE_PROPOSAL_ID foreign key (PROPOSAL_ID) references PROPOSAL(PROPOSAL_ID);

CREATE SEQUENCE SEQ_PROPOSAL_FNA_RATE_ID INCREMENT BY 1 START WITH 1 NOCACHE;
