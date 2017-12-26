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

update notification_module_role set role_name = 'KC-AWARD:All Personnel' where role_name = 'KC-AWARD:Investigators';
update notification_module_role set role_name = 'KC-IP:All Personnel' where role_name = 'KC-IP:Investigators';
update notification_module_role set role_name = 'KC-NEGOTIATION:All Personnel' where role_name = 'KC-NEGOTIATION:Investigators';

update notification_type_recipient set role_name = 'KC-AWARD:All Personnel' where role_name = 'KC-AWARD:Investigators';
update notification_type_recipient set role_name = 'KC-IP:All Personnel' where role_name = 'KC-IP:Investigators';
update notification_type_recipient set role_name = 'KC-NEGOTIATION:All Personnel' where role_name = 'KC-NEGOTIATION:Investigators';

update prop_role_template set role_name = 'KC-AWARD:All Personnel' where role_name = 'KC-AWARD:Investigators';
update prop_role_template set role_name = 'KC-IP:All Personnel' where role_name = 'KC-IP:Investigators';
update prop_role_template set role_name = 'KC-NEGOTIATION:All Personnel' where role_name = 'KC-NEGOTIATION:Investigators';
