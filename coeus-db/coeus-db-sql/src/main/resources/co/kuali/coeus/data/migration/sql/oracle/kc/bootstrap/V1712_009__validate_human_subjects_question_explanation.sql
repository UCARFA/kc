--
-- Kuali Coeus, a comprehensive research administration system for higher education.
--
-- Copyright 2005-2017 Kuali, Inc.
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

insert into s2s_error (s2s_error_id, message_key, message, fix_link, update_timestamp, update_user, ver_nbr, obj_id)
values (seq_s2s_error_id.nextval, '/GrantApplication/Forms/PHSHumanSubjectsAndClinicalTrialsInfo/Explanation',
  'Other Requested Information attachment is required for the Human Subjects Clinical Trials form when human specimens and/or data are involved.',
  'abstractsAttachments', SYSDATE, 'admin', 1, sys_guid());
