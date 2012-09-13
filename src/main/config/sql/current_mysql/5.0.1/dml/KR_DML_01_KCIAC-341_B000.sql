DELIMITER /
INSERT INTO KRIM_ROLE_RSP_ID_BS_S VALUES(NULL)
/

INSERT INTO KRIM_ROLE_RSP_T (ROLE_RSP_ID, OBJ_ID, VER_NBR, ROLE_ID, RSP_ID, ACTV_IND) VALUES
((SELECT (MAX(ID)) FROM KRIM_ROLE_RSP_ID_BS_S), UUID(), '1', (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE ROLE_NM = 'IACUC Administrator') ,
(SELECT RSP_ID FROM KRIM_RSP_T WHERE NM = 'IACUCReview'), 'Y')
/
INSERT INTO KRIM_ROLE_RSP_ACTN_ID_BS_S VALUES(NULL)
/

INSERT INTO krim_role_rsp_actn_t (ROLE_RSP_ACTN_ID, OBJ_ID, VER_NBR, ACTN_TYP_CD, PRIORITY_NBR, ACTN_PLCY_CD, ROLE_MBR_ID, ROLE_RSP_ID, FRC_ACTN) values
((SELECT (MAX(ID)) FROM KRIM_ROLE_RSP_ACTN_ID_BS_S), UUID(), '1', 'A', '1', 'F', '*', (SELECT ROLE_RSP_ID FROM KRIM_ROLE_RSP_T WHERE ROLE_ID = (SELECT ROLE_ID FROM KRIM_ROLE_T WHERE ROLE_NM = 'IACUC Administrator') AND RSP_ID = (SELECT RSP_ID FROM KRIM_RSP_T WHERE NM = 'IACUCReview')),
'Y')
/

DELIMITER ;
