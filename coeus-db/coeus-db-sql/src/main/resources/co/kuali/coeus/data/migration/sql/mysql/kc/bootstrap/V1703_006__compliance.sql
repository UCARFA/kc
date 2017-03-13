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

ALTER TABLE SUBAWARD_TEMPLATE_INFO ADD COLUMN (
  FCIO_SUBREC_POLICY_CD VARCHAR(3),
  ANIMAL_FLAG CHAR(1),
  ANIMAL_PTE_SEND_CD VARCHAR(3),
  ANIMAL_PTE_NR_CD VARCHAR(3),
  HUMAN_FLAG CHAR(1),
  HUMAN_PTE_SEND_CD VARCHAR(3),
  HUMAN_PTE_NR_CD VARCHAR(3),
  HUMAN_DATA_EXCHANGE_AGREE_CD VARCHAR(3),
  HUMAN_DATA_EXCHANGE_TERMS_CD VARCHAR(3));