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

insert into krim_perm_t (perm_id, obj_id, ver_nbr, perm_tmpl_id, nmspc_cd, nm, desc_txt, actv_ind)
values ('RESBOOT-1003', sys_guid(), 1, (select perm_tmpl_id from krim_perm_tmpl_t where nmspc_cd = 'KC-IDM' and nm = 'Perform Document Action'),
        'KC-AWARD', 'Send Award Notice', 'Allows users to send Award Notices from the Award Actions print tab', 'Y');

insert into krim_perm_attr_data_t (attr_data_id, obj_id, ver_nbr, perm_id, attr_val, kim_typ_id, kim_attr_defn_id)
values ('RESBOOT-1001', sys_guid(), 1, 'RESBOOT-1003', 'AwardDocument',
		    (select kim_typ_id from krim_perm_tmpl_t where nmspc_cd = 'KC-IDM' and nm = 'Perform Document Action'),
		    (select kim_attr_defn_id from krim_attr_defn_t where nmspc_cd = 'KR-WKFLW' and nm = 'documentTypeName'));

insert into krim_perm_attr_data_t (attr_data_id, obj_id, ver_nbr, perm_id, attr_val, kim_typ_id, kim_attr_defn_id)
values ('RESBOOT-1002', sys_guid(), 1, 'RESBOOT-1003', 'sendAwardNotice',
		    (select kim_typ_id from krim_perm_tmpl_t where nmspc_cd = 'KC-IDM' and nm = 'Perform Document Action'),
		    (select kim_attr_defn_id from krim_attr_defn_t where nmspc_cd = 'KC-SYS' and nm = 'documentAction'));

insert into krim_role_perm_t (role_perm_id, obj_id, ver_nbr, perm_id, role_id, actv_ind)
values ('RESBOOT-1000', sys_guid(), 1, 'RESBOOT-1003',
        (select role_id from krim_role_t where nmspc_cd = 'KC-AWARD' and role_nm = 'Award Viewer'), 'Y');

insert into krim_role_perm_t (role_perm_id, obj_id, ver_nbr, perm_id, role_id, actv_ind)
values ('RESBOOT-1001', sys_guid(), 1, 'RESBOOT-1003',
        (select role_id from krim_role_t where nmspc_cd = 'KC-AWARD' and role_nm = 'Award Modifier'), 'Y');
