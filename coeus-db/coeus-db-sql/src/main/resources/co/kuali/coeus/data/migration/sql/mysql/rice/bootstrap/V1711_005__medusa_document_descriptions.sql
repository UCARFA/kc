insert into KRCR_PARM_T (NMSPC_CD, CMPNT_CD, PARM_NM, OBJ_ID, VER_NBR, PARM_TYP_CD, VAL, PARM_DESC_TXT, EVAL_OPRTR_CD, APPL_ID)
values ('KC-GEN', 'All', 'Show_Document_Descriptions_In_Medusa', uuid(), 1, 'CONFG', '', 'A semicolon-delimited list of module codes that will display document descriptions in the Medusa tree view, or a wildcard (*) to display document descriptions for all modules.', 'A', 'KC');

update KRCR_PARM_T set NMSPC_CD = 'KC-GEN', CMPNT_CD = 'All', PARM_DESC_TXT = 'Determines whether Medusa will use the new React-based UI (true) rather than the original KRAD or KNS UI (false)'
where PARM_NM = 'Enable_Improved_Medusa_UI' and NMSPC_CD = 'KC-PD';
