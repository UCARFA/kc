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

-- the following query produces duplicate question records in our bootstrap data. This reassigns the next available sequence number
-- to these records
-- SELECT QUESTION_ID, SEQUENCE_NUMBER, COUNT(*) FROM QUESTION GROUP BY QUESTION_ID, SEQUENCE_NUMBER HAVING COUNT(*) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
  (SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 52) + 1
where T1.QUESTION_REF_ID =
  (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 52 and SEQUENCE_NUMBER = 1) AND
  (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 52 and SEQUENCE_NUMBER = 1) > 1;


update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 53) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 53 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 53 and SEQUENCE_NUMBER = 1) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 54) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 54 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 54 and SEQUENCE_NUMBER = 1) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 55) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 55 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 55 and SEQUENCE_NUMBER = 1) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 56) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 56 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 56 and SEQUENCE_NUMBER = 1) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 57) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 57 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 57 and SEQUENCE_NUMBER = 1) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 58) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 58 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 58 and SEQUENCE_NUMBER = 1) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 59) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 59 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 59 and SEQUENCE_NUMBER = 1) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 60) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 60 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 60 and SEQUENCE_NUMBER = 1) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 61) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 61 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 61 and SEQUENCE_NUMBER = 1) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 62) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 62 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 62 and SEQUENCE_NUMBER = 1) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 63) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 63 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 63 and SEQUENCE_NUMBER = 1) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 65) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 65 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 65 and SEQUENCE_NUMBER = 1) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 99) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 99 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 99 and SEQUENCE_NUMBER = 1) > 1;

update question T1 SET T1.SEQUENCE_NUMBER =
(SELECT max(SEQUENCE_NUMBER) FROM question WHERE QUESTION_ID = 100) + 1
where T1.QUESTION_REF_ID =
      (SELECT max(QUESTION_REF_ID) FROM question WHERE QUESTION_ID = 100 and SEQUENCE_NUMBER = 1) AND
      (select COUNT(*) as DUP_COUNT FROM QUESTION WHERE QUESTION_ID = 100 and SEQUENCE_NUMBER = 1) > 1;