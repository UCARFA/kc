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

update VALID_NARR_FORMS set FORM_NAME = 'NSF_CoverPage_1_7-V1.7', NARRATIVE_TYPE_CODE = '-1' where FORM_NAME = 'GOALILetter';
update VALID_NARR_FORMS set FORM_NAME = 'NSF_CoverPage_1_7-V1.7', NARRATIVE_TYPE_CODE = '-2' where FORM_NAME = 'RAISEEmails';

-- funding mechanism question
update question set question_id = '10115' where QUESTION = 'Select a Funding Mechanism' and LOOKUP_RETURN = 'FundingMechanism_CoverPage_1.7';
