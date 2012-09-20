use krdev;
# EXPORT SQLS 
# Removed a bunch of last_updated_dt columns because it was causing issues in oracle
SELECT * INTO OUTFILE '/tmp/riceOverlay/KRCR_NMSPC_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n' FROM KRCR_NMSPC_T WHERE NMSPC_CD LIKE 'KC%';

# 
SELECT * INTO OUTFILE '/tmp/riceOverlay/KRCR_PARM_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n' FROM KRCR_PARM_T WHERE NMSPC_CD LIKE 'KC%';

## Added this in
SELECT * FROM KRIM_AFLTN_TYP_T WHERE AFLTN_TYP_CD NOT IN ('STDNT', 'FCLTY', 'STAFF', 'AFLT') INTO OUTFILE '/tmp/riceOverlay/KRIM_AFLTN_TYP_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

#Added this in
select * from KRIM_PHONE_TYP_T WHERE PHONE_TYP_CD = 'FAX' INTO OUTFILE '/tmp/riceOverlay/KRIM_PHONE_TYP_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ENTITY_ID) AS ENTITY_ID, OBJ_ID, VER_NBR, ACTV_IND FROM KRIM_ENTITY_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10094
UNION 
SELECT CONCAT('KC',ENTITY_ID) AS ENTITY_ID, OBJ_ID, VER_NBR, ACTV_IND FROM KRIM_ENTITY_T WHERE ENTITY_ID = (SELECT ENTITY_ID FROM KRIM_PRNCPL_T WHERE UPPER(PRNCPL_NM) = 'KC') INTO OUTFILE '/tmp/riceOverlay/KRIM_ENTITY_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ENTITY_ID) AS ENTITY_ID, ENT_TYP_CD, ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_ENTITY_ENT_TYP_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10094 
UNION 
SELECT CONCAT('KC',ENTITY_ID) AS ENTITY_ID, ENT_TYP_CD, ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_ENTITY_ENT_TYP_T WHERE ENTITY_ID = (SELECT ENTITY_ID FROM KRIM_PRNCPL_T WHERE UPPER(PRNCPL_NM) = 'KC') INTO OUTFILE '/tmp/riceOverlay/KRIM_ENTITY_ENT_TYP_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ENTITY_NM_ID) AS ENTITY_NM_ID, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, NM_TYP_CD, FIRST_NM, MIDDLE_NM, LAST_NM, SUFFIX_NM, TITLE_NM, DFLT_IND, ACTV_IND, OBJ_ID, VER_NBR, PREFIX_NM, NOTE_MSG, NM_CHNG_DT FROM KRIM_ENTITY_NM_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10094
UNION 
SELECT CONCAT('KC',ENTITY_NM_ID) AS ENTITY_NM_ID, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, NM_TYP_CD, FIRST_NM, MIDDLE_NM, LAST_NM, SUFFIX_NM, TITLE_NM, DFLT_IND, ACTV_IND, OBJ_ID, VER_NBR, PREFIX_NM, NOTE_MSG, NM_CHNG_DT FROM KRIM_ENTITY_NM_T WHERE ENTITY_ID = (SELECT ENTITY_ID FROM KRIM_PRNCPL_T WHERE UPPER(PRNCPL_NM) = 'KC') INTO OUTFILE '/tmp/riceOverlay/KRIM_ENTITY_NM_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ENTITY_ADDR_ID) AS ENTITY_ADDR_ID, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, ENT_TYP_CD, ADDR_TYP_CD, ADDR_LINE_1, ADDR_LINE_2, ADDR_LINE_3, CITY, STATE_PVC_CD, POSTAL_CD, POSTAL_CNTRY_CD, DFLT_IND, ACTV_IND, OBJ_ID, VER_NBR, LAST_UPDT_DT, ATTN_LINE, ADDR_FMT, MOD_DT, VALID_DT, VALID_IND, NOTE_MSG  FROM KRIM_ENTITY_ADDR_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10094
UNION 
SELECT CONCAT('KC',ENTITY_ADDR_ID) AS ENTITY_ADDR_ID, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, ENT_TYP_CD, ADDR_TYP_CD, ADDR_LINE_1, ADDR_LINE_2, ADDR_LINE_3, CITY, STATE_PVC_CD, POSTAL_CD, POSTAL_CNTRY_CD, DFLT_IND, ACTV_IND, OBJ_ID, VER_NBR, LAST_UPDT_DT, ATTN_LINE, ADDR_FMT, MOD_DT, VALID_DT, VALID_IND, NOTE_MSG  FROM KRIM_ENTITY_ADDR_T WHERE ENTITY_ID = (SELECT ENTITY_ID FROM KRIM_PRNCPL_T WHERE UPPER(PRNCPL_NM) = 'KC') INTO OUTFILE '/tmp/riceOverlay/KRIM_ENTITY_ADDR_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ENTITY_AFLTN_ID) AS ENTITY_AFLTN_ID, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_ENTITY_AFLTN_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10094
UNION
SELECT CONCAT('KC',ENTITY_AFLTN_ID) AS ENTITY_AFLTN_ID, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, AFLTN_TYP_CD, CAMPUS_CD, DFLT_IND, ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_ENTITY_AFLTN_T WHERE ENTITY_ID = (SELECT ENTITY_ID FROM KRIM_PRNCPL_T WHERE UPPER(PRNCPL_NM) = 'KC') INTO OUTFILE '/tmp/riceOverlay/KRIM_ENTITY_AFLTN_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';
## ??? why 2 entity_afltn_id
SELECT CONCAT('KC',ENTITY_EMP_ID) AS ENTITY_EMP_ID, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, CASE ENTITY_AFLTN_ID WHEN NULL THEN 'NULL' WHEN '' THEN 'NULL' ELSE CONCAT('KC', ENTITY_AFLTN_ID) END ENTITY_AFLTN_ID,  CASE EMP_STAT_CD WHEN NULL THEN 'NULL' WHEN '' THEN 'NULL' END AS EMP_STAT_CD, CASE EMP_TYP_CD
WHEN NULL THEN 'NULL' WHEN '' THEN 'NULL' END AS EMP_TYP_CD, PRMRY_IND, ACTV_IND, PRMRY_DEPT_CD, EMP_ID, EMP_REC_ID, OBJ_ID, VER_NBR, BASE_SLRY_AMT FROM KRIM_ENTITY_EMP_INFO_T WHERE ENTITY_ID > 10000 AND ENTITY_ID <10094
UNION 
SELECT CONCAT('KC',ENTITY_EMP_ID) AS ENTITY_EMP_ID, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, CASE ENTITY_AFLTN_ID WHEN  NULL THEN 'NULL' WHEN '' THEN 'NULL' ELSE CONCAT('KC',ENTITY_AFLTN_ID) END ENTITY_AFLTN_ID, CASE EMP_STAT_CD WHEN NULL THEN 'NULL' WHEN '' THEN 'NULL' END AS EMP_STAT_CD, CASE EMP_TYP_CD WHEN NULL THEN'NULL' WHEN '' THEN 'NULL' END AS EMP_TYP_CD, PRMRY_IND, ACTV_IND, PRMRY_DEPT_CD, EMP_ID, EMP_REC_ID, OBJ_ID, VER_NBR, BASE_SLRY_AMT FROM KRIM_ENTITY_EMP_INFO_T WHERE ENTITY_ID = (SELECT ENTITY_ID FROM KRIM_PRNCPL_T WHERE UPPER(PRNCPL_NM) = 'KC') INTO OUTFILE '/tmp/riceOverlay/KRIM_ENTITY_EMP_INFO_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ENTITY_EMAIL_ID) AS ENTITY_EMAIL_ID, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, ENT_TYP_CD, EMAIL_TYP_CD, EMAIL_ADDR, DFLT_IND, ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_ENTITY_EMAIL_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10094
UNION 
SELECT CONCAT('KC',ENTITY_EMAIL_ID) AS ENTITY_EMAIL_ID, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, ENT_TYP_CD, EMAIL_TYP_CD, EMAIL_ADDR, DFLT_IND, ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_ENTITY_EMAIL_T WHERE ENTITY_ID = (SELECT ENTITY_ID FROM KRIM_PRNCPL_T WHERE UPPER(PRNCPL_NM) = 'KC') INTO OUTFILE '/tmp/riceOverlay/KRIM_ENTITY_EMAIL_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ENTITY_PHONE_ID) AS ENTITY_PHONE_ID, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, ENT_TYP_CD, PHONE_TYP_CD, PHONE_NBR, PHONE_EXTN_NBR, POSTAL_CNTRY_CD, DFLT_IND, ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_ENTITY_PHONE_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10094 
UNION 
SELECT CONCAT('KC',ENTITY_PHONE_ID) AS ENTITY_PHONE_ID, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, ENT_TYP_CD, PHONE_TYP_CD, PHONE_NBR, PHONE_EXTN_NBR, POSTAL_CNTRY_CD, DFLT_IND, ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_ENTITY_PHONE_T WHERE ENTITY_ID = (SELECT ENTITY_ID FROM KRIM_PRNCPL_T WHERE UPPER(PRNCPL_NM) = 'KC') INTO OUTFILE '/tmp/riceOverlay/KRIM_ENTITY_PHONE_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT PRNCPL_ID AS PRNCPL_ID, CONCAT('kc',PRNCPL_NM) AS PRNCPL_NM, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, PRNCPL_PSWD, ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_PRNCPL_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10094 
UNION 
SELECT CONCAT('KC',PRNCPL_ID) AS PRNCPL_ID, PRNCPL_NM AS PRNCPL_NM, CONCAT('KC',ENTITY_ID) AS ENTITY_ID, PRNCPL_PSWD, ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_PRNCPL_T WHERE UPPER(PRNCPL_NM) = 'KC' INTO OUTFILE '/tmp/riceOverlay/KRIM_PRNCPL_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';


SELECT CONCAT('KC',KIM_ATTR_DEFN_ID) AS KIM_ATTR_DEFN_ID, NM, LBL, ACTV_IND, NMSPC_CD, CMPNT_NM, OBJ_ID, VER_NBR FROM KRIM_ATTR_DEFN_T WHERE NMSPC_CD LIKE 'KC%' INTO OUTFILE '/tmp/riceOverlay/KRIM_ATTR_DEFN_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',KIM_TYP_ID) AS KIM_TYP_ID, NM, SRVC_NM, ACTV_IND, NMSPC_CD, OBJ_ID, VER_NBR FROM KRIM_TYP_T WHERE NMSPC_CD LIKE 'KC%' INTO OUTFILE '/tmp/riceOverlay/KRIM_TYP_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',KIM_TYP_ATTR_ID) AS KIM_TYP_ATTR_ID, CONCAT('KC',KIM_TYP_ID) AS KIM_TYP_ID, 
   CASE WHEN KIM_ATTR_DEFN_ID IN (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',KIM_ATTR_DEFN_ID) 
   ELSE KIM_ATTR_DEFN_ID END AS KIM_ATTR_DEFN_ID,  
SORT_CD, ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_TYP_ATTR_T WHERE KIM_TYP_ID IN (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NMSPC_CD LIKE 'KC%') INTO OUTFILE '/tmp/riceOverlay/KRIM_TYP_ATTR_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',PERM_TMPL_ID) AS PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, 
   CASE WHEN KIM_TYP_ID IN (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',KIM_TYP_ID) 
   ELSE KIM_TYP_ID END AS KIM_TYP_ID,  
ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_PERM_TMPL_T WHERE NMSPC_CD LIKE 'KC%' INTO OUTFILE '/tmp/riceOverlay/KRIM_PERM_TMPL_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',PERM_ID) AS PERM_ID, NMSPC_CD, NM, DESC_TXT, 
   CASE WHEN PERM_TMPL_ID IN (SELECT PERM_TMPL_ID FROM KRIM_PERM_TMPL_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',PERM_TMPL_ID) 
   ELSE PERM_TMPL_ID END AS PERM_TMPL_ID, 
ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_PERM_T  WHERE NMSPC_CD LIKE 'KC%' INTO OUTFILE '/tmp/riceOverlay/KRIM_PERM_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ATTR_DATA_ID) AS ATTR_DATA_ID, CONCAT('KC',PERM_ID) AS PERM_ID, 
   CASE WHEN KIM_TYP_ID IN (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',KIM_TYP_ID) 
   ELSE KIM_TYP_ID END AS KIM_TYP_ID,  
   CASE WHEN KIM_ATTR_DEFN_ID IN (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',KIM_ATTR_DEFN_ID) 
   ELSE KIM_ATTR_DEFN_ID END AS KIM_ATTR_DEFN_ID,  
ATTR_VAL, OBJ_ID, VER_NBR FROM KRIM_PERM_ATTR_DATA_T WHERE PERM_ID IN (SELECT PERM_ID FROM KRIM_PERM_T WHERE NMSPC_CD LIKE 'KC%') INTO OUTFILE '/tmp/riceOverlay/KRIM_PERM_ATTR_DATA_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ROLE_ID) AS ROLE_ID, ROLE_NM, NMSPC_CD, DESC_TXT, 
   CASE WHEN KIM_TYP_ID IN (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',KIM_TYP_ID)
   ELSE KIM_TYP_ID END AS KIM_TYP_ID,  
ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%' INTO OUTFILE '/tmp/riceOverlay/KRIM_ROLE_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ROLE_MBR_ID) AS ROLE_MBR_ID, 
   CASE WHEN ROLE_ID IN (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',ROLE_ID) 
   ELSE ROLE_ID END AS ROLE_ID,  
   CASE 
   WHEN MBR_ID IN (SELECT PRNCPL_ID FROM KRIM_PRNCPL_T WHERE PRNCPL_NM IN ('kc'))  
   THEN CONCAT('KC',MBR_ID)  
   WHEN MBR_ID IN (SELECT GRP_ID FROM KRIM_GRP_T WHERE NMSPC_CD LIKE 'KC%')  
   THEN CONCAT('100',MBR_ID) 
   WHEN MBR_ID IN (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%')  
   THEN CONCAT('KC',MBR_ID) 
   ELSE MBR_ID END AS MBR_ID,     
MBR_TYP_CD, OBJ_ID, VER_NBR, ACTV_FRM_DT, ACTV_TO_DT FROM KRIM_ROLE_MBR_T  WHERE ROLE_ID IN (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%') INTO OUTFILE '/tmp/riceOverlay/KRIM_ROLE_MBR_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ATTR_DATA_ID) AS ATTR_DATA_ID, CONCAT('KC',ROLE_MBR_ID) AS ROLE_MBR_ID, 
   CASE WHEN KIM_TYP_ID IN (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',KIM_TYP_ID) 
   ELSE KIM_TYP_ID END AS KIM_TYP_ID,  
   CASE WHEN KIM_ATTR_DEFN_ID IN (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',KIM_ATTR_DEFN_ID) 
   ELSE KIM_ATTR_DEFN_ID END AS KIM_ATTR_DEFN_ID, ATTR_VAL, OBJ_ID, VER_NBR FROM KRIM_ROLE_MBR_ATTR_DATA_T WHERE ROLE_MBR_ID IN (SELECT DISTINCT ROLE_MBR_ID FROM KRIM_ROLE_MBR_T WHERE ROLE_ID IN (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%')) INTO OUTFILE '/tmp/riceOverlay/KRIM_ROLE_MBR_ATTR_DATA_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ROLE_PERM_ID) AS ROLE_PERM_ID, 
   CASE WHEN ROLE_ID IN (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',ROLE_ID) 
   ELSE ROLE_ID END AS ROLE_ID,  
   CASE WHEN PERM_ID IN (SELECT PERM_ID FROM KRIM_PERM_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',PERM_ID) 
   ELSE PERM_ID END AS PERM_ID,  
ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_ROLE_PERM_T WHERE ROLE_ID IN (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%') INTO OUTFILE '/tmp/riceOverlay/KRIM_ROLE_PERM_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('100',GRP_ID) AS GRP_ID, GRP_NM, NMSPC_CD, GRP_DESC, 
   CASE WHEN KIM_TYP_ID IN (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',KIM_TYP_ID) 
   ELSE KIM_TYP_ID END AS KIM_TYP_ID,  
ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_GRP_T WHERE NMSPC_CD LIKE 'KC%' INTO OUTFILE '/tmp/riceOverlay/KRIM_GRP_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',GRP_MBR_ID) AS GRP_MBR_ID, CONCAT('100',GRP_ID) AS GRP_ID, 
   CASE 
   WHEN MBR_ID IN (SELECT PRNCPL_ID FROM KRIM_PRNCPL_T WHERE PRNCPL_NM IN ('kc'))  
   THEN CONCAT('KC',MBR_ID)  
   WHEN MBR_ID IN (SELECT GRP_ID FROM KRIM_GRP_T WHERE NMSPC_CD LIKE 'KC%')  
   THEN CONCAT('100',MBR_ID)
   WHEN MBR_ID IN (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%')  
   THEN CONCAT('KC',MBR_ID) 
   ELSE MBR_ID END AS MBR_ID, 
MBR_TYP_CD, OBJ_ID, VER_NBR, ACTV_FRM_DT, ACTV_TO_DT, LAST_UPDT_DT FROM KRIM_GRP_MBR_T WHERE GRP_ID IN (SELECT GRP_ID FROM KRIM_GRP_T WHERE NMSPC_CD LIKE 'KC%') INTO OUTFILE '/tmp/riceOverlay/KRIM_GRP_MBR_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('100',RSP_ID) AS RSP_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND, RSP_TMPL_ID, OBJ_ID, VER_NBR FROM KRIM_RSP_T WHERE NMSPC_CD LIKE 'KC%' INTO OUTFILE '/tmp/riceOverlay/KRIM_RSP_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ROLE_RSP_ID) AS ROLE_RSP_ID, CONCAT('KC',ROLE_ID) AS ROLE_ID, CONCAT('100',RSP_ID) AS RSP_ID, ACTV_IND, OBJ_ID, VER_NBR FROM KRIM_ROLE_RSP_T WHERE (ROLE_ID IN (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%')) OR (RSP_ID IN (SELECT RSP_ID FROM KRIM_RSP_T WHERE NMSPC_CD LIKE 'KC%')) INTO OUTFILE '/tmp/riceOverlay/KRIM_ROLE_RSP_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ATTR_DATA_ID) AS ATTR_DATA_ID, CONCAT('100',RSP_ID) AS RSP_ID, 
   CASE WHEN KIM_TYP_ID IN (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',KIM_TYP_ID) 
   ELSE KIM_TYP_ID END AS KIM_TYP_ID,  
   CASE WHEN KIM_ATTR_DEFN_ID IN (SELECT KIM_ATTR_DEFN_ID FROM KRIM_ATTR_DEFN_T WHERE NMSPC_CD LIKE 'KC%') 
   THEN CONCAT('KC',KIM_ATTR_DEFN_ID) 
   ELSE KIM_ATTR_DEFN_ID END AS KIM_ATTR_DEFN_ID, ATTR_VAL, OBJ_ID, VER_NBR FROM KRIM_RSP_ATTR_DATA_T WHERE RSP_ID IN (SELECT RSP_ID FROM KRIM_RSP_T WHERE NMSPC_CD LIKE 'KC%') INTO OUTFILE '/tmp/riceOverlay/KRIM_RSP_ATTR_DATA_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CONCAT('KC',ROLE_RSP_ACTN_ID) AS ROLE_RSP_ACTN_ID, CONCAT('KC',ROLE_RSP_ID) AS ROLE_RSP_ID, CASE ROLE_MBR_ID WHEN '*' THEN ROLE_MBR_ID ELSE CONCAT('KC',ROLE_MBR_ID) END AS ROLE_MBR_ID, ACTN_TYP_CD, PRIORITY_NBR, ACTN_PLCY_CD, FRC_ACTN, OBJ_ID, VER_NBR FROM KRIM_ROLE_RSP_ACTN_T WHERE ROLE_RSP_ID IN (SELECT ROLE_RSP_ID FROM KRIM_ROLE_RSP_T WHERE RSP_ID IN (SELECT RSP_ID FROM KRIM_RSP_T WHERE NMSPC_CD LIKE 'KC%')) INTO OUTFILE '/tmp/riceOverlay/KRIM_ROLE_RSP_ACTN_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT CHNL_ID, NM, DESC_TXT, SUBSCRB_IND, VER_NBR, OBJ_ID FROM KREN_CHNL_T WHERE NM LIKE 'KC%' INTO OUTFILE '/tmp/riceOverlay/KREN_CHNL_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

SELECT PRODCR_ID, NM, DESC_TXT, CNTCT_INFO, VER_NBR, OBJ_ID FROM KREN_PRODCR_T WHERE NM LIKE 'KC%' INTO OUTFILE '/tmp/riceOverlay/KREN_PRODCR_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n'; # Notification System

SELECT CHNL_ID, PRODCR_ID FROM KREN_CHNL_PRODCR_T WHERE CHNL_ID IN (SELECT CHNL_ID FROM KREN_CHNL_T WHERE NM LIKE 'KC%') INTO OUTFILE '/tmp/riceOverlay/KREN_CHNL_PRODCR_T.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' ESCAPED BY '\\' LINES TERMINATED BY '\n';

# CLEANUP SQLS
/*
DELETE FROM KRCR_PARM_T WHERE NMSPC_CD LIKE 'KC%';
DELETE FROM KRNS_PARM_DTL_TYP_T WHERE NMSPC_CD LIKE 'KC%';
DELETE FROM KRCR_NMSPC_T WHERE NMSPC_CD LIKE 'KC%';
DELETE FROM KRIM_ENTITY_EMAIL_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10083;
DELETE FROM KRIM_ENTITY_EMP_INFO_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10083;
DELETE FROM KRIM_ENTITY_PHONE_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10083;
DELETE FROM KRIM_ENTITY_ADDR_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10083;
DELETE FROM KRIM_ENTITY_NM_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10083;
DELETE FROM KRIM_ENTITY_ENT_TYP_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10083;
DELETE FROM KRIM_PRNCPL_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10083;
DELETE FROM KRIM_ENTITY_T WHERE ENTITY_ID > 10000 AND ENTITY_ID < 10083;
DELETE FROM KRIM_PHONE_TYP_T WHERE PHONE_TYP_CD = 'FAX';
DELETE FROM KRIM_GRP_MBR_T WHERE GRP_ID IN (SELECT GRP_ID FROM KRIM_GRP_T WHERE NMSPC_CD LIKE 'KC%');
DELETE FROM KRIM_GRP_T WHERE NMSPC_CD LIKE 'KC%';
DELETE FROM KRIM_ROLE_PERM_T WHERE ROLE_ID IN (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%');
DELETE FROM KRIM_ROLE_MBR_ATTR_DATA_T WHERE ROLE_MBR_ID IN (SELECT DISTINCT ROLE_MBR_ID FROM KRIM_ROLE_MBR_T WHERE ROLE_ID IN (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%'));
DELETE FROM KRIM_ROLE_MBR_T  WHERE ROLE_ID IN (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%');
DELETE FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%';
DELETE FROM KRIM_ROLE_RSP_ACTN_T WHERE ROLE_RSP_ID IN (SELECT ROLE_RSP_ID FROM KRIM_ROLE_RSP_T WHERE RSP_ID IN (SELECT RSP_ID FROM KRIM_RSP_T WHERE NMSPC_CD LIKE 'KC%'));
DELETE FROM KRIM_ROLE_RSP_T WHERE (ROLE_ID IN (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE NMSPC_CD LIKE 'KC%')) OR (RSP_ID IN (SELECT RSP_ID FROM KRIM_RSP_T WHERE NMSPC_CD LIKE 'KC%'));
DELETE FROM KRIM_RSP_ATTR_DATA_T WHERE RSP_ID IN (SELECT RSP_ID FROM KRIM_RSP_T WHERE NMSPC_CD LIKE 'KC%');
DELETE FROM KRIM_RSP_T WHERE NMSPC_CD LIKE 'KC%';
DELETE FROM KRIM_PERM_ATTR_DATA_T WHERE PERM_ID IN (SELECT PERM_ID FROM KRIM_PERM_T WHERE NMSPC_CD LIKE 'KC%');
DELETE FROM KRIM_PERM_T  WHERE NMSPC_CD LIKE 'KC%';
DELETE FROM KRIM_PERM_TMPL_T WHERE NMSPC_CD LIKE 'KC%';
DELETE FROM KRIM_TYP_ATTR_T WHERE KIM_TYP_ID IN (SELECT KIM_TYP_ID FROM KRIM_TYP_T WHERE NMSPC_CD LIKE 'KC%');
DELETE FROM KRIM_TYP_T WHERE NMSPC_CD LIKE 'KC%';
DELETE FROM KRIM_ATTR_DEFN_T WHERE NMSPC_CD LIKE 'KC%';
DELETE FROM KREN_CHNL_PRODCR_T WHERE CHNL_ID IN (SELECT CHNL_ID FROM KREN_CHNL_T WHERE NM LIKE 'KC%');
DELETE FROM KREN_CHNL_T WHERE NM LIKE 'KC%';
COMMIT;
*/