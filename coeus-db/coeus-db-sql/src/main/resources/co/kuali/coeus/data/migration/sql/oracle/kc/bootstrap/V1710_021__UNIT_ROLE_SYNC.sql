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

CREATE SEQUENCE SEQ_UNIT_ROLE_SYNC_ID INCREMENT BY 1 START WITH 1 NOCACHE;

CREATE TABLE UNIT_ROLE_SYNC (
  ID                 VARCHAR2(25)           NOT NULL,
  SYNC_BEHAVIOR_CODE VARCHAR2(15)           NOT NULL,
  ACTIVE             CHAR(1)                NOT NULL,
  UPDATE_TIMESTAMP   DATE                   NOT NULL,
  UPDATE_USER        VARCHAR2(60)           NOT NULL,
  VER_NBR            NUMBER(8, 0) DEFAULT 1 NOT NULL,
  OBJ_ID             VARCHAR2(36)           NOT NULL
);

ALTER TABLE UNIT_ROLE_SYNC
  ADD CONSTRAINT PK_UNIT_ROLE_SYNC
PRIMARY KEY (ID);

ALTER TABLE UNIT_ROLE_SYNC
  ADD CONSTRAINT UQ_UNIT_ROLE_SYNC
UNIQUE (OBJ_ID);


CREATE SEQUENCE SEQ_SOURCE_UNIT_ID INCREMENT BY 1 START WITH 1 NOCACHE;

CREATE TABLE SOURCE_UNIT (
  ID                VARCHAR2(25)           NOT NULL,
  UNIT_ROLE_SYNC_ID VARCHAR2(25)           NOT NULL,
  SOURCE_UNIT_CODE  VARCHAR2(15)           NOT NULL,
  UPDATE_TIMESTAMP  DATE                   NOT NULL,
  UPDATE_USER       VARCHAR2(60)           NOT NULL,
  VER_NBR           NUMBER(8, 0) DEFAULT 1 NOT NULL,
  OBJ_ID            VARCHAR2(36)           NOT NULL
);

ALTER TABLE SOURCE_UNIT
  ADD CONSTRAINT PK_SOURCE_UNIT
PRIMARY KEY (ID);

ALTER TABLE SOURCE_UNIT
  ADD CONSTRAINT UQ_SOURCE_UNIT
UNIQUE (OBJ_ID);

ALTER TABLE SOURCE_UNIT
  ADD CONSTRAINT FK_SU_UNIT_ROLE_SYNC
FOREIGN KEY (UNIT_ROLE_SYNC_ID) REFERENCES UNIT_ROLE_SYNC (ID);


CREATE SEQUENCE SEQ_TARGET_ROLE_ID INCREMENT BY 1 START WITH 1 NOCACHE;

CREATE TABLE TARGET_ROLE (
  ID                VARCHAR2(25)           NOT NULL,
  UNIT_ROLE_SYNC_ID VARCHAR(25)            NOT NULL,
  ROLE_ID           VARCHAR2(40)           NOT NULL,
  DESCENDS          CHAR(1)                NOT NULL,
  UPDATE_TIMESTAMP  DATE                   NOT NULL,
  UPDATE_USER       VARCHAR2(60)           NOT NULL,
  VER_NBR           NUMBER(8, 0) DEFAULT 1 NOT NULL,
  OBJ_ID            VARCHAR2(36)           NOT NULL
);

ALTER TABLE TARGET_ROLE
  ADD CONSTRAINT PK_TARGET_ROLE
PRIMARY KEY (ID);

ALTER TABLE TARGET_ROLE
  ADD CONSTRAINT UQ_TARGET_ROLE
UNIQUE (OBJ_ID);

ALTER TABLE TARGET_ROLE
  ADD CONSTRAINT FK_TR_UNIT_ROLE_SYNC
FOREIGN KEY (UNIT_ROLE_SYNC_ID) REFERENCES UNIT_ROLE_SYNC (ID);
