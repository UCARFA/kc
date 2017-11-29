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

INSERT INTO krms_func_t (func_id, nmspc_cd, nm, desc_txt, rtrn_typ, typ_id, actv, ver_nbr)
VALUES ('RES-BOOT10033', 'KC-PD', 's2sHumanSubjectExists', 'Is there an S2S opportunity and at least one human subjects special review',
        'java.lang.String', 'KC1006', 'Y', 1);
INSERT INTO krms_func_parm_t (func_parm_id, nm, desc_txt, typ, func_id, seq_no)
VALUES
  ('RES-BOOT10057', 'DevelopmentProposal', 'Development Proposal BO', 'org.kuali.coeus.propdev.impl.core.DevelopmentProposal', 'RES-BOOT10033', 1);
INSERT INTO krms_term_spec_t (term_spec_id, nm, typ, actv, ver_nbr, desc_txt, nmspc_cd)
VALUES ('RES-BOOT2116', 'RES-BOOT10033', 'java.lang.String', 'Y', 1, 'Is there an S2S opportunity and at least one human subjects special review',
        'KC-PD');
INSERT INTO krms_term_rslvr_t (term_rslvr_id, nmspc_cd, nm, typ_id, output_term_spec_id, actv, ver_nbr)
VALUES ('RES-BOOT10027', 'KC-PD', 'PD S2S Human Subject Exists Match Resolver', 'KC1001', 'RES-BOOT2116', 'Y', 1);
INSERT INTO krms_cntxt_vld_term_spec_t (cntxt_term_spec_prereq_id, cntxt_id, term_spec_id, prereq)
VALUES ('RES-BOOT1056', 'KC-PD-CONTEXT', 'RES-BOOT2116', 'Y');
INSERT INTO krms_term_spec_ctgry_t (term_spec_id, ctgry_id)
VALUES ('RES-BOOT2116', 'KC1001');

INSERT INTO krms_term_t (term_id, term_spec_id, ver_nbr, desc_txt)
VALUES ('RES-BOOT10021', 'RES-BOOT2116', 1, 'NIH Clinical Trial Questionnaire');

INSERT INTO krms_prop_t (prop_id, desc_txt, typ_id, dscrm_typ_cd, cmpnd_op_cd, rule_id, ver_nbr, cmpnd_seq_no)
VALUES ('RES-BOOT10021', 'NIH Clinical Trial Questionnaire', NULL, 'S', NULL, 'RES-BOOT10000', 1, NULL);

INSERT INTO krms_prop_parm_t (prop_parm_id, prop_id, parm_val, parm_typ_cd, seq_no, ver_nbr)
VALUES ('RES-BOOT10004', 'RES-BOOT10021', 'RES-BOOT10021', 'T', 0, 1);

INSERT INTO krms_prop_parm_t (prop_parm_id, prop_id, parm_val, parm_typ_cd, seq_no, ver_nbr)
VALUES ('RES-BOOT10005', 'RES-BOOT10021', '=', 'O', 2, 1);

INSERT INTO krms_prop_parm_t (prop_parm_id, prop_id, parm_val, parm_typ_cd, seq_no, ver_nbr)
VALUES ('RES-BOOT10006', 'RES-BOOT10021', 'true', 'C', 1, 1);

INSERT INTO krms_rule_t (rule_id, nmspc_cd, nm, desc_txt, typ_id, prop_id, actv, ver_nbr)
VALUES ('RES-BOOT10000', 'KC-PD', 'NIH Clinical Trial Questionnaire', 'NIH Clinical Trial Questionnaire', NULL, 'RES-BOOT10021', 'N', 1);

INSERT INTO krms_agenda_itm_t (agenda_itm_id, rule_id, sub_agenda_id, agenda_id, ver_nbr, when_true, when_false, always)
VALUES ('RES-BOOT10021', 'RES-BOOT10000', NULL, 'KC1000', 1, NULL, NULL, NULL);

UPDATE krms_agenda_itm_t
SET always = 'RES-BOOT10019'
WHERE agenda_itm_id = 'KC2011';
UPDATE krms_agenda_itm_t
SET always = 'RES-BOOT10020'
WHERE agenda_itm_id = 'RES-BOOT10019';
UPDATE krms_agenda_itm_t
SET always = 'RES-BOOT10021'
WHERE agenda_itm_id = 'RES-BOOT10020';
