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

update s2s_error set message = 'Research Strategy attachment is required for PHS Fellowship Supplemental form.'
where message_key = '/GrantApplication/Forms/PHS_Fellowship_Supplemental_3_1/ResearchTrainingPlan/ResearchStrategy';

update s2s_error set message = 'Research Contribution attachment is required for PHS Fellowship Supplemental form.'
where message_key = '/GrantApplication/Forms/PHS_Fellowship_Supplemental_3_1/ResearchTrainingPlan/RespectiveContribution';

update s2s_error set message = 'Specific Aims attachment is required for PHS Fellowship Supplemental form.'
where message_key = '/GrantApplication/Forms/PHS_Fellowship_Supplemental_3_1/ResearchTrainingPlan/SpecificAims';

update s2s_error set message = 'Sponsor and institution attachment is required for PHS Fellowship Supplemental form.'
where message_key = '/GrantApplication/Forms/PHS_Fellowship_Supplemental_3_1/ResearchTrainingPlan/SponsorandInstitution';

update s2s_error set message = 'Responsible Conduct of Research attachment is required for PHS Fellowship Supplemental form.'
where message_key = '/GrantApplication/Forms/PHS_Fellowship_Supplemental_3_1/ResearchTrainingPlan/TrainingInResponsibleConductOfResearch';

update s2s_error set message = 'Research Strategy attachment is required for PHS Fellowship Supplemental form.'
where message_key = '/GrantApplication/Forms/PHS_Fellowship_Supplemental_4_0/ResearchTrainingPlan/ResearchStrategy';

update s2s_error set message = 'Research Contribution attachment is required for PHS Fellowship Supplemental form.'
where message_key = '/GrantApplication/Forms/PHS_Fellowship_Supplemental_4_0/ResearchTrainingPlan/RespectiveContribution';

update s2s_error set message = 'Specific Aims attachment is required for PHS Fellowship Supplemental form.'
where message_key = '/GrantApplication/Forms/PHS_Fellowship_Supplemental_4_0/ResearchTrainingPlan/SpecificAims';

update s2s_error set message = 'Sponsor and institution attachment is required for PHS Fellowship Supplemental form.'
where message_key = '/GrantApplication/Forms/PHS_Fellowship_Supplemental_4_0/ResearchTrainingPlan/SponsorandInstitution';

update s2s_error set message = 'Responsible Conduct of Research attachment is required for PHS Fellowship Supplemental form.'
where message_key = '/GrantApplication/Forms/PHS_Fellowship_Supplemental_4_0/ResearchTrainingPlan/TrainingInResponsibleConductOfResearch';

insert into s2s_error (s2s_error_id, message_key, message, fix_link, update_timestamp, update_user, ver_nbr, obj_id)
values ((select max(id) from seq_s2s_error_id), '/GrantApplication/Forms/PHS_Fellowship_Supplemental_4_0/AdditionalInformation/CurrentPriorNRSASupportIndicator',
'The PHS Fellowship Supplemental 4.0 questionnaire must be completed on the Questions tab.', 'questions', now(), 'admin', 1, uuid());
