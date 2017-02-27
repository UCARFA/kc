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

alter table AWARD_ACCOUNT ADD
(CREATED_BY_AWARD_ID DECIMAL(22,0) NOT NULL,
STATUS VARCHAR2(15) NOT NULL,
BUDGETED DECIMAL (12,2) NOT NULL,
PENDING DECIMAL (12,2) NOT NULL,
INCOME DECIMAL (12,2) NOT NULL,
EXPENSE DECIMAL (12,2) NOT NULL,
AVAILABLE DECIMAL (12,2) NOT NULL
);

alter table AWARD_ACCOUNT drop column IS_AVAILABLE;
alter table AWARD_ACCOUNT drop column AWARD_ID;

alter table AWARD_ACCOUNT modify (
   ACCOUNT_NUMBER varchar2(15)
);

alter table award_account RENAME COLUMN "COMMENT" TO AWARD_ACCOUNT_COMMENT;
