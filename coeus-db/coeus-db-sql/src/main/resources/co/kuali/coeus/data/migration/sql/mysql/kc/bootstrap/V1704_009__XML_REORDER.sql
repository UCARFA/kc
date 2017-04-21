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

CREATE TABLE FORMS_XML_REORDER
(
		ID DECIMAL(12,0) NOT NULL,
        NODE_TO_MOVE VARCHAR(60) NOT NULL
        , TARGET_NODE VARCHAR(60) NOT NULL
        , MOVE_AFTER CHAR(1) NOT NULL
        , UPDATE_USER VARCHAR(60) NOT NULL
        , UPDATE_TIMESTAMP DATETIME NOT NULL
        , VER_NBR DECIMAL(8) default 1 NOT NULL
        , OBJ_ID VARCHAR(36)

    , CONSTRAINT ID_PK PRIMARY KEY(ID)
    , CONSTRAINT UQ_NODES UNIQUE(NODE_TO_MOVE, TARGET_NODE)
);

CREATE TABLE SEQ_FORMS_XML_REORDER
(
	id bigint(19) not null auto_increment, primary key (id)
) ENGINE MyISAM;

INSERT INTO SEQ_FORMS_XML_REORDER VALUES(NULL);
INSERT INTO forms_xml_reorder VALUES ((SELECT (MAX(ID)) FROM SEQ_FORMS_XML_REORDER), 'SFLLL_1_2:FederalProgramName',
'SFLLL_1_2:FederalAgencyDepartment', 'Y', 'admin', NOW(), '1', UUID());

INSERT INTO SEQ_FORMS_XML_REORDER VALUES(NULL);
INSERT INTO forms_xml_reorder VALUES ((SELECT (MAX(ID)) FROM SEQ_FORMS_XML_REORDER),
'SF424_Short_1_1:SameAsProjectDirector', 'SF424_Short_1_1:ProjectDirectorGroup', 'Y', 'admin', NOW(), '1', UUID());

INSERT INTO SEQ_FORMS_XML_REORDER VALUES(NULL);
INSERT INTO forms_xml_reorder VALUES ((SELECT (MAX(ID)) FROM SEQ_FORMS_XML_REORDER),
'SF424_Short_1_1:ContactPersonGroup', 'SF424_Short_1_1:ApplicationCertification', 'N', 'admin', NOW(), '1', UUID());
