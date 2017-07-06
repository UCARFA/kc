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

INSERT INTO SEQ_S2S_FORM_CONFIG_ID VALUES (null);
INSERT INTO S2S_FORM_CONFIG
    (S2S_FORM_CONFIG_ID,
    FORM_NAME,
    ACTIVE_FLAG,
    INACTIVE_MESSAGE,
    VER_NBR,
    OBJ_ID,
    UPDATE_TIMESTAMP,
    UPDATE_USER) VALUES
    ((SELECT MAX(id) FROM SEQ_S2S_FORM_CONFIG_ID),
    'ED_SF424_Supplement_1_3-V1.3',
    'N',
    'The form is still undergoing testing. Expect it to be available soon.',
    '1',
    UUID(),
    NOW(),
    'admin');

INSERT INTO SEQ_S2S_FORM_CONFIG_ID VALUES (null);
INSERT INTO S2S_FORM_CONFIG
    (S2S_FORM_CONFIG_ID,
    FORM_NAME,
    ACTIVE_FLAG,
    INACTIVE_MESSAGE,
    VER_NBR,
    OBJ_ID,
    UPDATE_TIMESTAMP,
    UPDATE_USER) VALUES
    ((SELECT MAX(id) FROM SEQ_S2S_FORM_CONFIG_ID),
    'ED_524_Budget_1_3-V1.3',
    'N',
    'The form is still undergoing testing. Expect it to be available soon.',
    '1',
    UUID(),
    NOW(),
    'admin');