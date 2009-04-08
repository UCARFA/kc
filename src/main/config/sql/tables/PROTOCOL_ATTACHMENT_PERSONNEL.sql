CREATE TABLE PROTOCOL_ATTACHMENT_PERSONNEL
   (PA_PERSONNEL_ID NUMBER(12,0) NOT NULL ENABLE, 
    PROTOCOL_ID NUMBER(12,0) NOT NULL ENABLE,
    TYPE_CD VARCHAR2(3) NOT NULL ENABLE,
    VERSION_NUMBER NUMBER(3,0) NOT NULL ENABLE,
    DOCUMENT_ID NUMBER(4,0) NOT NULL ENABLE,
    FILE_ID NUMBER(12,0) NOT NULL ENABLE,
    DESCRIPTION VARCHAR2(300) NOT NULL ENABLE, 
    PERSON_ID NUMBER(12,0) NOT NULL ENABLE,
    VER_NBR NUMBER(8,0) DEFAULT 1 NOT NULL ENABLE,
    OBJ_ID VARCHAR2(36) DEFAULT SYS_GUID()  NOT NULL ENABLE,
    UPDATE_TIMESTAMP DATE NOT NULL ENABLE,
    UPDATE_USER VARCHAR2(10) NOT NULL ENABLE);
);

ALTER TABLE PROTOCOL_ATTACHMENT_PERSONNEL
    ADD CONSTRAINT PK_PROTOCOL_ATTACH_PERSONNEL
    PRIMARY KEY (PA_PERSONNEL_ID);

ALTER TABLE PROTOCOL_ATTACHMENT_PERSONNEL
    ADD CONSTRAINT FK_PA_PERSONNEL_FILE 
    FOREIGN KEY (FILE_ID) 
    REFERENCES PROTOCOL_ATTACHMENT_FILE (PA_FILE_ID);
    
--ALTER TABLE PROTOCOL_ATTACHMENT_PERSONNEL
--    ADD CONSTRAINT FK_PA_PERSONNEL_PROTOCOL
--    FOREIGN KEY (PROTOCOL_ID)
--    REFERENCES PROTOCOL (PROTOCOL_ID);

--ALTER TABLE PROTOCOL_ATTACHMENT_PERSONNEL
--    ADD CONSTRAINT FK_PERSON 
--    FOREIGN KEY (PERSON_ID) 
--    REFERENCES PERSON (PERSON_ID);

ALTER TABLE PROTOCOL_ATTACHMENT_PERSONNEL
    ADD CONSTRAINT UQ_PA_PERSONNEL 
    UNIQUE (PROTOCOL_ID, TYPE_CD, VERSION_NUMBER, DOCUMENT_ID);
