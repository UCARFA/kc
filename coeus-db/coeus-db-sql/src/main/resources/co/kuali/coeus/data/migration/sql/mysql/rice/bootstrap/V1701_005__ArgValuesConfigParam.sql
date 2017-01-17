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

update krcr_parm_t set VAL = 'DESCRIPTION'
where NMSPC_CD = 'KC-GEN' and CMPNT_CD = 'All' and APPL_ID = 'KC' and PARM_NM = 'ARG_VALUE_VALUES_FINDER_PREFER_DESCRIPTION' and lower(VAL) in ('true', 'yes', 'y', 'on', '1', 't', 'enabled');

update krcr_parm_t set VAL = 'VALUE'
where NMSPC_CD = 'KC-GEN' and CMPNT_CD = 'All' and APPL_ID = 'KC' and PARM_NM = 'ARG_VALUE_VALUES_FINDER_PREFER_DESCRIPTION' and lower(VAL) not in ('true', 'yes', 'y', 'on', '1', 't', 'enabled');

update krcr_parm_t set PARM_NM = 'ARG_VALUE_VALUES_FINDER_DEFAULT_CONFIG',
	PARM_DESC_TXT = 'When set to "DESCRIPTION", Argument Values will display the description.
	When set to "VALUE", Argument Values will display the value.
	When set to "BOTH", Argument Values will display the value and the description.
	Valid values are: (DESCRIPTION, VALUE, BOTH)'
where NMSPC_CD = 'KC-GEN' and CMPNT_CD = 'All' and APPL_ID = 'KC' and PARM_NM = 'ARG_VALUE_VALUES_FINDER_PREFER_DESCRIPTION';

INSERT INTO krcr_parm_t(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-GEN','All','ARG_VALUE_VALUES_FINDER_ARG_CONFIG',UUID(),1,'CONFG','',
  'Configures a specific argumentName to determine whether to display the description, value or both.
  It is configured like the following: argumentName1=VALUE; argumentName2=BOTH; argumentName3=DESCRIPTION.
  See the related parameter, ARG_VALUE_VALUES_FINDER_DEFAULT_CONFIG for more information.',
  'A','KC');
