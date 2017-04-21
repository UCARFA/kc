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

update krcr_parm_t set VAL = concat('FieldOfStudy=DESCRIPTION; ProjectDiscipline=DESCRIPTION; ', VAL)
where NMSPC_CD = 'KC-GEN' and CMPNT_CD = 'All' and APPL_ID = 'KC' and PARM_NM = 'ARG_VALUE_VALUES_FINDER_ARG_CONFIG' and (val is not null and trim(VAL) <> '');

update krcr_parm_t set VAL = 'FieldOfStudy=DESCRIPTION; ProjectDiscipline=DESCRIPTION'
where NMSPC_CD = 'KC-GEN' and CMPNT_CD = 'All' and APPL_ID = 'KC' and PARM_NM = 'ARG_VALUE_VALUES_FINDER_ARG_CONFIG' and (val is null or trim(VAL) = '');
