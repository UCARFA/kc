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

CREATE TABLE VAL_SRC_ACNTS_COST_TYP(
CODE NUMBER(12,0) NOT NULL PRIMARY KEY,
COST_SHARE_TYPE_CODE NUMBER(3) NOT NULL,
SOURCE_ACCOUNT_CODE NUMBER(12,0) NOT NULL,
ACTIVE CHAR(1) NOT NULL,
UPDATE_USER VARCHAR2(60) NOT NULL,
UPDATE_TIMESTAMP DATE NOT NULL,
VER_NBR NUMBER (8,0) DEFAULT 1 NOT NULL,
OBJ_ID VARCHAR2(36) NOT NULL);

ALTER TABLE VAL_SRC_ACNTS_COST_TYP
ADD CONSTRAINT UQ_SEQ_VAL_SRC_ACNTS_COST
UNIQUE (COST_SHARE_TYPE_CODE, SOURCE_ACCOUNT_CODE);

CREATE SEQUENCE SEQ_VAL_SRC_ACNTS_COST_ID INCREMENT BY 1 START WITH 1 NOCACHE;