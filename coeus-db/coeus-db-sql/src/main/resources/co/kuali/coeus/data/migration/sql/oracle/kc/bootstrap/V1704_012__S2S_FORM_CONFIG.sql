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

CREATE SEQUENCE SEQ_S2S_FORM_CONFIG_ID INCREMENT BY 1 START WITH 1 NOCACHE;

CREATE TABLE S2S_FORM_CONFIG (
    S2S_FORM_CONFIG_ID VARCHAR2(25) NOT NULL,
    FORM_NAME VARCHAR2(50) NOT NULL,
    ACTIVE_FLAG CHAR(1) NOT NULL,
    INACTIVE_MESSAGE VARCHAR2(200),
    UPDATE_TIMESTAMP DATE NOT NULL,
    UPDATE_USER VARCHAR2(60) NOT NULL,
    VER_NBR NUMBER(8,0) DEFAULT 1 NOT NULL,
    OBJ_ID VARCHAR2(36) NOT NULL);

ALTER TABLE S2S_FORM_CONFIG
ADD CONSTRAINT PK_S2S_FORM_CONFIG
PRIMARY KEY (S2S_FORM_CONFIG_ID);

ALTER TABLE S2S_FORM_CONFIG
ADD CONSTRAINT UQ_S2S_FORM_CONFIG
UNIQUE (FORM_NAME);

ALTER TABLE S2S_FORM_CONFIG
    ADD CONSTRAINT UQ_S2S_FORM_CONFIG2
UNIQUE (OBJ_ID);

