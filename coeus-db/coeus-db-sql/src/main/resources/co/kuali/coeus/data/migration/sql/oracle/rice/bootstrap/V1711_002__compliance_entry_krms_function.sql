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

insert into krms_func_t (func_id, nmspc_cd, nm, desc_txt, rtrn_typ, typ_id, actv, ver_nbr)
values ('RES-BOOT10032', 'KC-PD', 'humanSubjectsSpecialReviewContainsPropertyValue', 'Is there a human subjects special review with matching property value', 'java.lang.String', 'KC1006', 'Y', 1);
insert into krms_func_parm_t (func_parm_id, nm, desc_txt, typ, func_id, seq_no)
values ('RES-BOOT10054', 'DevelopmentProposal', 'Development Proposal BO', 'org.kuali.coeus.propdev.impl.core.DevelopmentProposal',  'RES-BOOT10032', 1);
insert into krms_func_parm_t (func_parm_id, nm, desc_txt, typ, func_id, seq_no)
values ('RES-BOOT10055', 'specialReviewPropertyName', 'Special Review property to match against', 'java.lang.String', 'RES-BOOT10032', 2);
insert into krms_func_parm_t (func_parm_id, nm, desc_txt, typ, func_id, seq_no)
values ('RES-BOOT10056', 'specialReviewPropertyValue', 'value to compare the property to', 'java.lang.String', 'RES-BOOT10032', 3);
insert into krms_term_spec_t (term_spec_id, nm, typ, actv, ver_nbr, desc_txt, nmspc_cd)
values ('RES-BOOT2115', 'RES-BOOT10032', 'java.lang.String', 'Y', 1, 'Is there a human subjects special review with matching property value', 'KC-PD');
insert into krms_term_rslvr_t (term_rslvr_id, nmspc_cd, nm, typ_id, output_term_spec_id, actv, ver_nbr)
values ('RES-BOOT10026', 'KC-PD', 'PD Special Review Property Match Resolver', 'KC1001', 'RES-BOOT2115', 'Y', 1);
insert into krms_term_rslvr_parm_spec_t (term_rslvr_parm_spec_id, term_rslvr_id, nm, ver_nbr)
values ('RES-BOOT2092', 'RES-BOOT10026', 'specialReviewPropertyName', 1);
insert into krms_term_rslvr_parm_spec_t (term_rslvr_parm_spec_id, term_rslvr_id, nm, ver_nbr)
values ('RES-BOOT2093', 'RES-BOOT10026', 'specialReviewPropertyValue', 1);
insert into krms_cntxt_vld_term_spec_t (cntxt_term_spec_prereq_id, cntxt_id, term_spec_id, prereq)
values ('RES-BOOT1055', 'KC-PD-CONTEXT', 'RES-BOOT2115', 'Y');
insert into krms_term_spec_ctgry_t (term_spec_id, ctgry_id)
values ('RES-BOOT2115', 'KC1001');
