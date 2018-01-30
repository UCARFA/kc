-- Copyright © 2005-2018 Kuali, Inc.
-- All Rights Reserved
-- You may use and modify this code under the terms of the Kuali, Inc.
-- Pre-Release License Agreement. You may not distribute it.
--
-- You should have received a copy of the Kuali, Inc. Pre-Release License
-- Agreement with this file. If not, please write to license@kuali.co.

ALTER TABLE COST_ELEMENT ADD UNIT_NUMBER VARCHAR2(8);
ALTER TABLE COST_ELEMENT ADD CONSTRAINT FK_UNIT_CE_UNIT_NUMBER FOREIGN KEY (UNIT_NUMBER) REFERENCES UNIT (UNIT_NUMBER);
update COST_ELEMENT set UNIT_NUMBER = (select UNIT_NUMBER from UNIT where PARENT_UNIT_NUMBER is null);
