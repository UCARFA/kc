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

update KRCR_PARM_T t set t.VAL = (select replace(replace(replace(replace(upper(u.val), 'FDP_NASA;', ''), 'FDP_ONR;', ''), 'FDP_NASA', ''), 'FDP_ONR', '') from KRCR_PARM_T u WHERE u.NMSPC_CD = 'KC-GEN' and u.CMPNT_CD = 'All' and u.PARM_NM = 'FORCED_XSL_FORMS' and u.APPL_ID = 'KC') WHERE t.NMSPC_CD = 'KC-GEN' and t.CMPNT_CD = 'All' and t.PARM_NM = 'FORCED_XSL_FORMS' and t.APPL_ID = 'KC';
