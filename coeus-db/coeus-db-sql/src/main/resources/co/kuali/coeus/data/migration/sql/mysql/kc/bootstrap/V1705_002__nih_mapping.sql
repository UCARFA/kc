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

create table NIH_VALIDATION_MAPPING (
ID decimal(22,0),
RULE_NUMBER VARCHAR(20) NOT NULL,
CUSTOM_MSG VARCHAR(400),
FORCE_ERROR CHAR(1) NOT NULL,
APPEND_TO_ORIGINAL CHAR(1) NOT NULL,
PAGE_ID VARCHAR(50) NOT NULL,
SECTION_ID VARCHAR(50),
ACTIVE CHAR(1) NOT NULL,
UPDATE_USER VARCHAR(60) NOT NULL,
UPDATE_TIMESTAMP DATETIME NOT NULL,
VER_NBR DECIMAL (8,0) NOT NULL DEFAULT 1,
OBJ_ID VARCHAR(36) NOT NULL
);

ALTER TABLE NIH_VALIDATION_MAPPING
  ADD CONSTRAINT NIH_RULE_UQ
UNIQUE (RULE_NUMBER);

ALTER TABLE NIH_VALIDATION_MAPPING
  ADD CONSTRAINT NIH_VALIDATION_PK
PRIMARY KEY (ID);

create table SEQ_NIH_VALIDATION
(
  id bigint(19) not null auto_increment, primary key (id)
) ENGINE MyISAM;
