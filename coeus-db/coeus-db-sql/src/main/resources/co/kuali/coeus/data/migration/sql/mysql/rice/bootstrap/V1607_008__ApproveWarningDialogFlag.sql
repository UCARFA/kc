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
insert into krcr_parm_t (nmspc_cd, cmpnt_cd, parm_nm, obj_id, ver_nbr, parm_typ_cd, val, parm_desc_txt, eval_oprtr_cd, appl_id)
values ('KC-PD', 'Document', 'proposal.approval.dialog.enabled', UUID(), 1, 'CONFG', 'N', 'Used to test proposal approval warning dialog. deprecated and will be removed.', 'A', 'KC');
