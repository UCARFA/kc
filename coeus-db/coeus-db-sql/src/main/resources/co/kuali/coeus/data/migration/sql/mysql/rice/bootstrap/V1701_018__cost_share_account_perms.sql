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

update KRIM_PERM_T set NM = 'Create Account Document' where NM = 'Create Cost Share Source Account Document' and NMSPC_CD = 'KC-PD';
update KRIM_PERM_ATTR_DATA_T set ATTR_VAL = 'AccountMaintenanceDocument' where ATTR_VAL = 'CostShareSourceAccountMaintenanceDocument' and PERM_ID = (SELECT PERM_ID FROM KRIM_PERM_T WHERE NM = 'Create Account Document' AND NMSPC_CD='KC-PD');
