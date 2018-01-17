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

UPDATE QUESTION q1
  INNER JOIN (SELECT QUESTION_REF_ID
              FROM QUESTION
              WHERE QUESTION_ID = '-10110' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                                  FROM QUESTION
                                                                  WHERE QUESTION_ID = '-10110')) q2 ON q1.QUESTION_REF_ID = q2.QUESTION_REF_ID
SET STATUS = 'A';

UPDATE QUESTION q1
  INNER JOIN (SELECT QUESTION_REF_ID
              FROM QUESTION
              WHERE QUESTION_ID = '-10111' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                                  FROM QUESTION
                                                                  WHERE QUESTION_ID = '-10111')) q2 ON q1.QUESTION_REF_ID = q2.QUESTION_REF_ID
SET STATUS = 'A';

UPDATE QUESTION q1
  INNER JOIN (SELECT QUESTION_REF_ID
              FROM QUESTION
              WHERE QUESTION_ID = '-10112' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                                  FROM QUESTION
                                                                  WHERE QUESTION_ID = '-10112')) q2 ON q1.QUESTION_REF_ID = q2.QUESTION_REF_ID
SET STATUS = 'A';

UPDATE QUESTION q1
  INNER JOIN (SELECT QUESTION_REF_ID
              FROM QUESTION
              WHERE QUESTION_ID = '-10120' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                                  FROM QUESTION
                                                                  WHERE QUESTION_ID = '-10120')) q2 ON q1.QUESTION_REF_ID = q2.QUESTION_REF_ID
SET STATUS = 'A';

UPDATE QUESTION q1
  INNER JOIN (SELECT QUESTION_REF_ID
              FROM QUESTION
              WHERE QUESTION_ID = '-10131' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                                  FROM QUESTION
                                                                  WHERE QUESTION_ID = '-10131')) q2 ON q1.QUESTION_REF_ID = q2.QUESTION_REF_ID
SET STATUS = 'A';

UPDATE QUESTION q1
  INNER JOIN (SELECT QUESTION_REF_ID
              FROM QUESTION
              WHERE QUESTION_ID = '-10132' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                                  FROM QUESTION
                                                                  WHERE QUESTION_ID = '-10132')) q2 ON q1.QUESTION_REF_ID = q2.QUESTION_REF_ID
SET STATUS = 'A';

UPDATE QUESTION q1
  INNER JOIN (SELECT QUESTION_REF_ID
              FROM QUESTION
              WHERE QUESTION_ID = '-10133' AND SEQUENCE_NUMBER = (SELECT max(SEQUENCE_NUMBER)
                                                                  FROM QUESTION
                                                                  WHERE QUESTION_ID = '-10133')) q2 ON q1.QUESTION_REF_ID = q2.QUESTION_REF_ID
SET STATUS = 'A';
