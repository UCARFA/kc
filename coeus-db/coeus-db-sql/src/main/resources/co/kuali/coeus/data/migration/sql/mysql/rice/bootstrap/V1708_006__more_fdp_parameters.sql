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

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_ARO_Policy', UUID(),1,'CONFG','http://www.arl.army.mil/www/default.cfm?page=29','The value entered here will populate the FDP form Attachment 2 for ARO for the General Terms and Conditions 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_ARO_Grants_Policy_Statement', UUID(),1,'CONFG','CFR 200, as modified and supplemented by the Department of Defense''s (DoD) interim implementation found at 2 CFR part 1103, (79 FR 76047, December 19, 2014), all of which are incorporated herein by reference.','The value entered here will populate the FDP form Attachment 2 for ARO for the General Terms and Conditions 3','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_ARO_Interim_Research_Terms', UUID(),1,'CONFG','http://www.onr.navy.mil/Contracts-Grants/submit-proposal/grants-proposal/~/media/Files/Contracts-Grants/docs/DoD-Research-Terms-Conditions-JUL2016.ashx','The value entered here will populate the FDP form Attachment 2 for ARO for the General Terms and Conditions 4 part 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_ARO_Agency_Requirements', UUID(),1,'CONFG','http://www.arl.army.mil/www/pages/8/ACC-APG-RTP_Division_Assistance_General_Terms_and_Conditions_AUG2016.pdf','The value entered here will populate the FDP form Attachment 2 for ARO for the General Terms and Conditions 4 part 2','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_ARO_FCOI_Guidance', UUID(),1,'CONFG','ARO - As stated in the solicitation','The value entered here will populate the FDP form Attachment 2 for ARO for the Promoting Objectivity in Research','A','KC');


INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AFOSR_Policy', UUID(),1,'CONFG','http://www.wpafb.af.mil/afrl/afosr','The value entered here will populate the FDP form Attachment 2 for AFOSR for the General Terms and Conditions 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AFOSR_Grants_Policy_Statement', UUID(),1,'CONFG','2 CFR 200, as modified and supplemented by the Department of Defense''s (DoD) interim implementation found at 2 CFR part 1103, (79 FR 76047, December 19, 2014), all of which are incorporated herein by reference.','The value entered here will populate the FDP form Attachment 2 for AFOSR for the General Terms and Conditions 3','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AFOSR_Interim_Research_Terms', UUID(),1,'CONFG','http://www.onr.navy.mil/Contracts-Grants/submit-proposal/grants-proposal/~/media/Files/Contracts-Grants/docs/DoD-Research-Terms-Conditions-JUL2016.ashx','The value entered here will populate the FDP form Attachment 2 for AFOSR for the General Terms and Conditions 4 part 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AFOSR_Agency_Requirements', UUID(),1,'CONFG','http://www.wpafb.af.mil/afrl/afosr','The value entered here will populate the FDP form Attachment 2 for AFOSR for the General Terms and Conditions 4 part 2','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AFOSR_FCOI_Guidance', UUID(),1,'CONFG','AFOSR - As stated in the solicitation','The value entered here will populate the FDP form Attachment 2 for AFOSR for the Promoting Objectivity in Research','A','KC');


INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_EPA_Policy', UUID(),1,'CONFG','https://www.epa.gov/grants','The value entered here will populate the FDP form Attachment 2 for EPA for the General Terms and Conditions 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_EPA_Grants_Policy_Statement', UUID(),1,'CONFG','2 CFR 1500 and 40 CFR Chapter I, Subchapter B – Grants & Other Federal Assistance','The value entered here will populate the FDP form Attachment 2 for EPA for the General Terms and Conditions 3','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_EPA_Interim_Research_Terms', UUID(),1,'CONFG','https://www.nsf.gov/awards/managing/rtc.jsp','The value entered here will populate the FDP form Attachment 2 for EPA for the General Terms and Conditions 4 part 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_EPA_Agency_Requirements', UUID(),1,'CONFG','http://www.nsf.gov/pubs/policydocs/rtc/agencyspecifics/epa_314.pdf','The value entered here will populate the FDP form Attachment 2 for EPA for the General Terms and Conditions 4 part 2','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_EPA_FCOI_Guidance', UUID(),1,'CONFG','EPA - CFR 200.112','The value entered here will populate the FDP form Attachment 2 for EPA for the Promoting Objectivity in Research','A','KC');


INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AMRAA_Policy', UUID(),1,'CONFG','http://www.usamraa.army.mil/index.cfm?ID=12&Type=3','The value entered here will populate the FDP form Attachment 2 for AMRAA for the General Terms and Conditions 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AMRAA_Grants_Policy_Statement', UUID(),1,'CONFG','2 CFR 200, as modified and supplemented by the Department of Defense''s (DoD) interim implementation found at 2 CFR part 1103, (79 FR 76047, December 19, 2014), all of which are incorporated herein by reference.','The value entered here will populate the FDP form Attachment 2 for AMRAA for the General Terms and Conditions 3','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AMRAA_Interim_Research_Terms', UUID(),1,'CONFG','http://www.onr.navy.mil/Contracts-Grants/submit-proposal/grants-proposal/~/media/Files/Contracts-Grants/docs/DoD-Research-Terms-Conditions-JUL2016.ashx','The value entered here will populate the FDP form Attachment 2 for AMRAA for the General Terms and Conditions 4 part 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AMRAA_Agency_Requirements', UUID(),1,'CONFG','http://www.usamraa.army.mil/pages/pdf/USAMRAA%20General%20Research%20T&Cs%20with%20IHEs,%20Hospitals,%20NPs.Nov%2020151.pdf','The value entered here will populate the FDP form Attachment 2 for AMRAA for the General Terms and Conditions 4 part 2','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AMRAA_FCOI_Guidance', UUID(),1,'CONFG','AMRAA - As stated in the solicitation','The value entered here will populate the FDP form Attachment 2 for AMRAA for the Promoting Objectivity in Research','A','KC');


INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AMRMC_Policy', UUID(),1,'CONFG','http://www.usamraa.army.mil/index.cfm?ID=12&Type=3','The value entered here will populate the FDP form Attachment 2 for AMRMC for the General Terms and Conditions 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AMRMC_Grants_Policy_Statement', UUID(),1,'CONFG','2 CFR 200, as modified and supplemented by the Department of Defense''s (DoD) interim implementation found at 2 CFR part 1103, (79 FR 76047, December 19, 2014), all of which are incorporated herein by reference.','The value entered here will populate the FDP form Attachment 2 for AMRMC for the General Terms and Conditions 3','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AMRMC_Interim_Research_Terms', UUID(),1,'CONFG','http://www.onr.navy.mil/Contracts-Grants/submit-proposal/grants-proposal/~/media/Files/Contracts-Grants/docs/DoD-Research-Terms-Conditions-JUL2016.ashx','The value entered here will populate the FDP form Attachment 2 for AMRMC for the General Terms and Conditions 4 part 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AMRMC_Agency_Requirements', UUID(),1,'CONFG','http://www.usamraa.army.mil/pages/pdf/USAMRAA%20General%20Research%20T&Cs%20with%20IHEs,%20Hospitals,%20NPs.Nov%2020151.pdf','The value entered here will populate the FDP form Attachment 2 for AMRMC for the General Terms and Conditions 4 part 2','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_AMRMC_FCOI_Guidance', UUID(),1,'CONFG','AMRMC - As stated in the solicitation','The value entered here will populate the FDP form Attachment 2 for AMRMC for the Promoting Objectivity in Research','A','KC');


INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_USDA_Policy', UUID(),1,'CONFG','https://nifa.usda.gov/regulations-and-guidelines','The value entered here will populate the FDP form Attachment 2 for USDA for the General Terms and Conditions 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_USDA_Grants_Policy_Statement', UUID(),1,'CONFG','http://nifa.usda.gov/resource/nifa-federal-assistance-policy-guide','The value entered here will populate the FDP form Attachment 2 for USDA for the General Terms and Conditions 3','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_USDA_Interim_Research_Terms', UUID(),1,'CONFG','https://www.nsf.gov/awards/managing/rtc.jsp','The value entered here will populate the FDP form Attachment 2 for USDA for the General Terms and Conditions 4 part 1','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_USDA_Agency_Requirements', UUID(),1,'CONFG','http://www.nsf.gov/pubs/policydocs/rtc/agencyspecifics/nifa_1014.pdf','The value entered here will populate the FDP form Attachment 2 for USDA for the General Terms and Conditions 4 part 2','A','KC');

INSERT INTO KRCR_PARM_T(NMSPC_CD,CMPNT_CD,PARM_NM,OBJ_ID,VER_NBR,PARM_TYP_CD,VAL,PARM_DESC_TXT,EVAL_OPRTR_CD,APPL_ID)
VALUES ('KC-SUBAWARD','Document','FDP_USDA_FCOI_Guidance', UUID(),1,'CONFG','USDA - If Applicable','The value entered here will populate the FDP form Attachment 2 for USDA for the Promoting Objectivity in Research','A','KC');
