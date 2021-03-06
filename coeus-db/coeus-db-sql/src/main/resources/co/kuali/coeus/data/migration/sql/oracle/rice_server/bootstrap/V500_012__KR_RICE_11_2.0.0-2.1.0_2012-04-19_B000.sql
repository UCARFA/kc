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

CREATE TABLE KRNS_MAINT_DOC_ATT_LST_T  (
    ATT_ID      VARCHAR2(40) NOT NULL,
	DOC_HDR_ID	VARCHAR2(14) NOT NULL,
	ATT_CNTNT 	blob NOT NULL,
	FILE_NM   	VARCHAR2(150) NULL,
	CNTNT_TYP 	VARCHAR2(255) NULL,
	OBJ_ID    	VARCHAR2(36) NOT NULL,
	VER_NBR   	NUMBER(8) DEFAULT 0 NOT NULL,
	PRIMARY KEY(ATT_ID),
	CONSTRAINT KRNS_MAINT_DOC_ATT_LST_FK1 foreign key (DOC_HDR_ID) references KRNS_MAINT_DOC_T (DOC_HDR_ID)
);
ALTER TABLE KRNS_MAINT_DOC_ATT_LST_T
	ADD CONSTRAINT KRNS_MAINT_DOC_ATT_LST_TC0
	UNIQUE (OBJ_ID);
CREATE INDEX KRNS_MAINT_DOC_ATT_LST_TI1 on KRNS_MAINT_DOC_ATT_LST_T (DOC_HDR_ID);
CREATE SEQUENCE KRNS_MAINT_DOC_ATT_S INCREMENT BY 1 START WITH 10000 NOMAXVALUE NOCYCLE NOCACHE ORDER;


