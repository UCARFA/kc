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

CREATE INDEX AF_FILE_DATA_ID
  ON ATTACHMENT_FILE (FILE_DATA_ID);
CREATE INDEX PA_FILE_DATA_ID
  ON PROPOSAL_ATTACHMENTS (FILE_DATA_ID);
CREATE INDEX SA_FILE_DATA_ID
  ON SUBAWARD_ATTACHMENTS (FILE_DATA_ID);
CREATE INDEX SAI_FILE_DATA_ID
  ON SUBAWARD_AMOUNT_INFO (FILE_DATA_ID);
CREATE INDEX SFR_SUBAWARD_FFATA_REP
  ON SUBAWARD_FFATA_REPORTING (FILE_DATA_ID);
CREATE INDEX BSA_FILE_DATA_ID
  ON BUDGET_SUB_AWARDS (FILE_DATA_ID);
CREATE INDEX BSA_XML_DATA_ID
  ON BUDGET_SUB_AWARDS (XML_DATA_ID);
