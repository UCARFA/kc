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

CREATE TABLE ORGANIZATION_AUDIT_ACC_TYPE (
  CODE VARCHAR(3) NOT NULL,
  DESCRIPTION VARCHAR(200) NOT NULL,
  ACTIVE_FLAG CHAR(1) NOT NULL,
  UPDATE_TIMESTAMP DATE NOT NULL,
  UPDATE_USER VARCHAR(60) NOT NULL,
  VER_NBR DECIMAL(8,0) DEFAULT 1 NOT NULL,
  OBJ_ID VARCHAR(36) NOT NULL) CHARACTER SET utf8 COLLATE utf8_bin;

ALTER TABLE ORGANIZATION_AUDIT_ACC_TYPE
ADD CONSTRAINT PK_ORGANIZATION_AUDIT_ACC_TYPE
PRIMARY KEY (CODE);

ALTER TABLE ORGANIZATION_AUDIT_ACC_TYPE
ADD CONSTRAINT UQ_ORGANIZATION_AUDIT_ACC_TYPE
UNIQUE (OBJ_ID);

INSERT INTO ORGANIZATION_AUDIT_ACC_TYPE (CODE,DESCRIPTION,ACTIVE_FLAG,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR)
VALUES (1,'Accepted','Y','admin',NOW(),UUID(),1);

INSERT INTO ORGANIZATION_AUDIT_ACC_TYPE (CODE,DESCRIPTION,ACTIVE_FLAG,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR)
VALUES (2,'Rejected','Y','admin',NOW(),UUID(),1);

INSERT INTO ORGANIZATION_AUDIT_ACC_TYPE (CODE,DESCRIPTION,ACTIVE_FLAG,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR)
VALUES (3,'Requested','Y','admin',NOW(),UUID(),1);

INSERT INTO ORGANIZATION_AUDIT_ACC_TYPE (CODE,DESCRIPTION,ACTIVE_FLAG,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR)
VALUES (4,'Reviewed','Y','admin',NOW(),UUID(),1);


ALTER TABLE ORGANIZATION_AUDIT MODIFY AUDIT_ACCEPTED VARCHAR(3);

UPDATE ORGANIZATION_AUDIT SET AUDIT_ACCEPTED = '1' WHERE AUDIT_ACCEPTED = 'Y';
UPDATE ORGANIZATION_AUDIT SET AUDIT_ACCEPTED = '2' WHERE AUDIT_ACCEPTED = 'N';

ALTER TABLE ORGANIZATION_AUDIT
ADD CONSTRAINT FK_ORGANIZATION_AUDIT_ACC
FOREIGN KEY (AUDIT_ACCEPTED)
REFERENCES ORGANIZATION_AUDIT_ACC_TYPE (CODE);
