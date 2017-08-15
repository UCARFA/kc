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

update KRCR_PARM_T t, KRCR_PARM_T u set t.VAL = replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(replace(upper(u.val), 'FDP_ARO;', ''), 'FDP_AFOSR;', ''), 'FDP_EPA;', ''), 'FDP_AMRMC;', ''), 'FDP_AMRAA;', ''), 'FDP_USDA;', ''), 'FDP_ARO', ''), 'FDP_AFOSR', ''), 'FDP_EPA', ''), 'FDP_AMRMC', ''), 'FDP_AMRAA', ''), 'FDP_USDA', '')
WHERE t.NMSPC_CD = u.NMSPC_CD and t.CMPNT_CD = u.CMPNT_CD and t.PARM_NM = u.PARM_NM and t.APPL_ID = u.APPL_ID and t.NMSPC_CD = 'KC-GEN' and t.CMPNT_CD = 'All' and t.PARM_NM = 'FORCED_XSL_FORMS' and t.APPL_ID = 'KC';
