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


UPDATE KRMS_TERM_PARM_T
SET VAL = 'RR_OtherProjectInfo_1_2-V1.2,RR_OtherProjectInfo_1_3-V1.3,RR_OtherProjectInfo_1_4-V1.4'
WHERE TERM_PARM_ID = 'KC2007' AND TERM_ID = 'KC2007' AND NM = 'GrantsGov Form Name';

UPDATE KRMS_RULE_T
SET NM     = 'RROtherProjectInfoV1_2, 1_3, 1_4 (Q IDs 125, 107) Historic place, explain',
  DESC_TXT = 'RROtherProjectInfoV1_2, 1_3, 1_4 (Q IDs 125, 107) Historic place, explain'
WHERE RULE_ID = 'KC147' AND NMSPC_CD = 'KC-PD' AND PROP_ID = 'KC2007';

UPDATE KRMS_PROP_T
SET DESC_TXT = 'RROtherProjectInfoV1_2, 1_3, 1_4'
WHERE PROP_ID = 'KC2007' AND RULE_ID = 'KC147';

UPDATE KRMS_TERM_PARM_T
SET VAL = 'RR_OtherProjectInfo-V1.1,RR_OtherProjectInfo_1_2-V1.2,RR_OtherProjectInfo_1_3-V1.3,RR_OtherProjectInfo_1_4-V1.4'
WHERE TERM_PARM_ID = 'KC2009' AND TERM_ID = 'KC2009' AND NM = 'GrantsGov Form Name';

UPDATE KRMS_PROP_T
SET DESC_TXT = 'RROtherProjectInfoV1_1, 1-2, 1-3, 1-4'
WHERE PROP_ID = 'KC2009' AND RULE_ID = 'KC149';
