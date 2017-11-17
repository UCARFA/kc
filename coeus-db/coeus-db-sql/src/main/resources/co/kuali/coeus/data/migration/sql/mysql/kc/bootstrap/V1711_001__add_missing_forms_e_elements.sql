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

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID), '/GrantApplication/Forms/PHS398_CoverPageSupplement_4_0/StemCells',
        'The PHS 398 Cover Page Supplement v4-0 questionnaire must be completed on the Questions tab.',
        'questions', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/PHS398_ResearchTrainingProgramPlan_4_0/ResearchTrainingProgramPlanAttachments',
        'Program Plan attachment is required for Research Training Program Plan.',
        'abstractsAttachments', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/PHS398_CareerDevelopmentAwardSup_4_0/CareerDevelopmentAwardAttachments/ResearchStrategy',
        'Research Strategy attachment is required for Career Development Award Supplement.',
        'abstractsAttachments', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/PHS398_CareerDevelopmentAwardSup_4_0/isNonUSCitizenship',
        'A PD/PI is required, please add a Principal Investigator to the proposal.',
        'keyPersonnel', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/PHS398_CareerDevelopmentAwardSup_4_0',
        'A PD/PI is required, please add a Principal Investigator to the proposal.',
        'keyPersonnel', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/PHS_Fellowship_Supplemental_4_0/FellowshipApplicant/BackgroundandGoals',
        'Background and Goals attachment is required for the PHS Fellowship Supplemental form.',
        'abstractsAttachments', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/PHS_Fellowship_Supplemental_4_0/AdditionalInformation/StemCells/isHumanStemCellsInvolved',
        'The PHS Fellowship Supplemental 4.0 questionnaire must be completed on the Questions tab.',
        'questions', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/PHS_Fellowship_Supplemental_4_0/AdditionalInformation/FieldOfTraining',
        'The PHS Fellowship Supplemental 4.0 questionnaire must be completed on the Questions tab.',
        'questions', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/PHS_Fellowship_Supplemental_4_0/AdditionalInformation/CurrentPriorNRSASupport',
        'The PHS Fellowship Supplemental 4.0 questionnaire must be completed on the Questions tab.',
        'questions', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/RR_SF424_2_0/PDPIContactInfo',
        'A PD/PI is required, please add a Principal Investigator to the proposal.',
        'keyPersonnel', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/RR_OtherProjectInfo_1_4/ProprietaryInformationIndicator',
        'Please answer the Proprietary Information question for this form within the Questions tab.',
        'questions', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/RR_OtherProjectInfo_1_4/EnvironmentalImpact/EnvironmentalImpactIndicator',
        'Please answer the Environmental Impact question for this form within the Questions tab.',
        'questions', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/RR_OtherProjectInfo_1_4/EnvironmentalImpact/EnvironmentalImpactExplanation',
        'Please explain the Environmental Exemption question for this form within the Questions tab.',
        'questions', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/RR_OtherProjectInfo_1_4/EnvironmentalImpact/EnvironmentalExemption/EnvironmentalExemptionExplanation',
        'Please explain the Environmental Exemption question for this form within the Questions tab.',
        'questions', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/RR_OtherProjectInfo_1_4/HistoricDesignation',
        'Please answer the Historic Designation question for this form within the Questions tab.',
        'questions', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/RR_OtherProjectInfo_1_4/AbstractAttachments',
        'The ProjectSummary proposal attachment is required for this form.',
        'abstractsAttachments', NOW(), 'admin', 1, UUID());

INSERT INTO SEQ_S2S_ERROR_ID VALUES (NULL);

INSERT INTO S2S_ERROR (S2S_ERROR_ID, MESSAGE_KEY, MESSAGE, FIX_LINK, UPDATE_TIMESTAMP, UPDATE_USER, VER_NBR, OBJ_ID)
VALUES ((SELECT (MAX(ID)) FROM SEQ_S2S_ERROR_ID),
        '/GrantApplication/Forms/RR_OtherProjectInfo_1_4/ProjectNarrativeAttachments',
        'The Narrative proposal attachment is required for this form.',
        'abstractsAttachments', NOW(), 'admin', 1, UUID());
