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

ALTER TABLE BUDGET_DETAILS_CAL_AMTS MODIFY LINE_ITEM_NUMBER DECIMAL (6) NOT NULL;
ALTER TABLE BUDGET_DETAILS MODIFY LINE_ITEM_NUMBER DECIMAL (6) NOT NULL;
ALTER TABLE BUDGET_PERSONNEL_CAL_AMTS MODIFY LINE_ITEM_NUMBER DECIMAL (6) NOT NULL;
ALTER TABLE BUDGET_RATE_AND_BASE MODIFY LINE_ITEM_NUMBER DECIMAL (6) NOT NULL;
ALTER TABLE BUDGET_PER_DET_RATE_AND_BASE MODIFY LINE_ITEM_NUMBER DECIMAL (6) NOT NULL;
ALTER TABLE BUDGET_PERSONNEL_DETAILS MODIFY LINE_ITEM_NUMBER DECIMAL (6) NOT NULL;
