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

insert into krim_role_t (role_id, obj_id, ver_nbr, role_nm, nmspc_cd, desc_txt, kim_typ_id, actv_ind, last_updt_dt)
values ('RESBOOT-1001', uuid(), 1, 'MPI', 'KC-PD', 'Proposal Development Multiple PI Derived Role', (select kim_typ_id from krim_typ_t where nmspc_cd = 'KC-PD' and nm = 'Derived Role: Investigators'), 'Y', now());

update krim_role_t set nmspc_cd = 'KC-PD', kim_typ_id = (select kim_typ_id from krim_typ_t where nmspc_cd = 'KC-PD' and nm = 'Derived Role: Investigators') where role_nm = 'PI' and nmspc_cd = 'KC-WKFLW';
update krim_role_t set nmspc_cd = 'KC-PD', kim_typ_id = (select kim_typ_id from krim_typ_t where nmspc_cd = 'KC-PD' and nm = 'Derived Role: Investigators') where role_nm = 'COI' and nmspc_cd = 'KC-WKFLW';
update krim_role_t set nmspc_cd = 'KC-PD', kim_typ_id = (select kim_typ_id from krim_typ_t where nmspc_cd = 'KC-PD' and nm = 'Derived Role: Investigators') where role_nm = 'KP' and nmspc_cd = 'KC-WKFLW';
update krim_role_t set role_nm = 'All Personnel' where role_nm = 'Investigators' and nmspc_cd = 'KC-PD';

update krim_typ_t set nm = concat('[DEPRECATED] ', nm) where srvc_nm = '{http://kc.kuali.org/core/v5_0}proposalRoleTypeService' and nm != 'Derived Role: Investigators';
