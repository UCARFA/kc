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

CREATE TABLE SEQ_UNIT_ROLE_SYNC_ID (
  id BIGINT(19) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
)
  ENGINE MyISAM;

ALTER TABLE SEQ_UNIT_ROLE_SYNC_ID
  AUTO_INCREMENT = 1;

CREATE TABLE UNIT_ROLE_SYNC (
  ID                 VARCHAR(25)             NOT NULL,
  SYNC_BEHAVIOR_CODE VARCHAR(15)             NOT NULL,
  ACTIVE             CHAR(1)                 NOT NULL,
  UPDATE_TIMESTAMP   DATETIME                NOT NULL,
  UPDATE_USER        VARCHAR(60)             NOT NULL,
  VER_NBR            DECIMAL(8, 0) DEFAULT 1 NOT NULL,
  OBJ_ID             VARCHAR(36)             NOT NULL
);

ALTER TABLE UNIT_ROLE_SYNC
  ADD CONSTRAINT PK_UNIT_ROLE_SYNC
PRIMARY KEY (ID);

ALTER TABLE UNIT_ROLE_SYNC
  ADD CONSTRAINT UQ_UNIT_ROLE_SYNC
UNIQUE (OBJ_ID);


CREATE TABLE SEQ_SOURCE_UNIT_ID (
  id BIGINT(19) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
)
  ENGINE MyISAM;

ALTER TABLE SEQ_SOURCE_UNIT_ID
  AUTO_INCREMENT = 1;

CREATE TABLE SOURCE_UNIT (
  ID                VARCHAR(25)             NOT NULL,
  UNIT_ROLE_SYNC_ID VARCHAR(25)             NOT NULL,
  SOURCE_UNIT_CODE  VARCHAR(15)             NOT NULL,
  UPDATE_TIMESTAMP  DATETIME                NOT NULL,
  UPDATE_USER       VARCHAR(60)             NOT NULL,
  VER_NBR           DECIMAL(8, 0) DEFAULT 1 NOT NULL,
  OBJ_ID            VARCHAR(36)             NOT NULL
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


CREATE TABLE SEQ_TARGET_ROLE_ID (
  id BIGINT(19) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
)
  ENGINE MyISAM;

ALTER TABLE SEQ_TARGET_ROLE_ID
  AUTO_INCREMENT = 1;

CREATE TABLE TARGET_ROLE (
  ID                VARCHAR(25)             NOT NULL,
  UNIT_ROLE_SYNC_ID VARCHAR(25)             NOT NULL,
  ROLE_ID           VARCHAR(40)             NOT NULL,
  DESCENDS          CHAR(1)                 NOT NULL,
  UPDATE_TIMESTAMP  DATETIME                NOT NULL,
  UPDATE_USER       VARCHAR(60)             NOT NULL,
  VER_NBR           DECIMAL(8, 0) DEFAULT 1 NOT NULL,
  OBJ_ID            VARCHAR(36)             NOT NULL
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
