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

UPDATE QUESTION
SET STATUS = 'A'
WHERE QUESTION_ID = '-10110' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                    FROM QUESTION
                                                    WHERE QUESTION_ID = '-10110');
UPDATE QUESTION
SET STATUS = 'A'
WHERE QUESTION_ID = '-10111' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                    FROM QUESTION
                                                    WHERE QUESTION_ID = '-10111');
UPDATE QUESTION
SET STATUS = 'A'
WHERE QUESTION_ID = '-10112' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                    FROM QUESTION
                                                    WHERE QUESTION_ID = '-10112');
UPDATE QUESTION
SET STATUS = 'A'
WHERE QUESTION_ID = '-10120' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                    FROM QUESTION
                                                    WHERE QUESTION_ID = '-10120');
UPDATE QUESTION
SET STATUS = 'A'
WHERE QUESTION_ID = '-10131' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                    FROM QUESTION
                                                    WHERE QUESTION_ID = '-10131');
UPDATE QUESTION
SET STATUS = 'A'
WHERE QUESTION_ID = '-10132' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                    FROM QUESTION
                                                    WHERE QUESTION_ID = '-10132');
UPDATE QUESTION
SET STATUS = 'A'
WHERE QUESTION_ID = '-10133' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                    FROM QUESTION
                                                    WHERE QUESTION_ID = '-10133');
