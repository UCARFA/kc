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

insert into KRCR_PARM_T values ('KC-PD', 'Document', 'Display_Unrounded_Modular_FNA', uuid(), 1, 'CONFG', 'false', 'Determines whether to display the unrounded modular F&A amount in the PD budget module, in addition to the rounded amount.', 'A', 'KC');
insert into KRCR_PARM_T values ('KC-PD', 'Document', 'ModularBudget_Round_F_and_A_Base', uuid(), 1, 'CONFG', 'N', 'A Y selection will calculate the F&A base on the module direct about minus exclusions. N will calculate the F&A base on the detailed budget direct amount minus exclusions.', 'A', 'KC');
