--
-- Kuali Coeus, a comprehensive research administration system for higher education.
--
-- Copyright 2005-2016 Kuali, Inc.
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


create table EPS_PROP_PERSON_CERT_DETAILS
(
	PROPOSAL_NUMBER VARCHAR2(12),
	PROP_PERSON_NUMBER NUMBER(12),
	CERTIFIED_BY VARCHAR2(60),
	CERTIFIED_TIME DATE,
	UPDATE_TIMESTAMP DATE NOT NULL,
	UPDATE_USER VARCHAR2(60) NOT NULL,
	VER_NBR NUMBER(8) default 1 NOT NULL,
	OBJ_ID VARCHAR2(36),
 CONSTRAINT EPS_PROP_PERSONP1 PRIMARY KEY(PROPOSAL_NUMBER,PROP_PERSON_NUMBER)
);

insert into EPS_PROP_PERSON_CERT_DETAILS (CERTIFIED_BY, CERTIFIED_TIME, PROPOSAL_NUMBER,PROP_PERSON_NUMBER, UPDATE_TIMESTAMP, UPDATE_USER)
(select CERTIFIED_BY, CERTIFIED_TIME, PROPOSAL_NUMBER,PROP_PERSON_NUMBER, UPDATE_TIMESTAMP, UPDATE_USER from EPS_PROP_PERSON);
update EPS_PROP_PERSON_CERT_DETAILS set OBJ_ID = SYS_GUID();
ALTER TABLE EPS_PROP_PERSON_CERT_DETAILS ADD CONSTRAINT FK_CERT_PROPOSAL_PROP_NBR FOREIGN KEY (PROPOSAL_NUMBER, PROP_PERSON_NUMBER) REFERENCES eps_prop_person(PROPOSAL_NUMBER, PROP_PERSON_NUMBER);
