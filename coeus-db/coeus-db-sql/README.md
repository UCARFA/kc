# Import DDL into database
**------------------------**

# Directory Structure

* java - custom java migrator code
* resources - versioned and sequenced sql files

Within the resources package structure there are a series of folders for various configurations of the Kuali Coeus database.  There are three primary definitions to understand for this data: bootstrap, demo, stage.  

Bootstrap data contains things like required parameters, roles, kc code tables that are expected to be present in order for the application to function

Demo data contains things like example Kim principals, Role memberships, Units, Sponsors.  This represents a fully populated KC system without any transactional or document data.

Stage data contains things like document workflow data, proposals, awards, and other complex transactional data.  This represents a fully populated KC system that has been used for some period of time.

In most cases stage data will be separate from demo data which will be separate from bootstrap data.  In rare cases we may want to modify bootstrap data in either a demo or stage script or we might want to modify demo data in a stage script.

* grm - contains custom grm specific sql files.  Internal to KualiCo
* kc
  * bootstrap - bootstrap sql files. This will contain only files related to KC tables and data.
  * demo - this contains a set of demo data.  This will contain only files related to KC tables and data.
  * stage - this contains a set of staging data.  This will contain only files related to KC tables and data.
  * embedded_client_scripts - rice client side sql files when running rice in embedded mode.  This may contain rice or kc data but only for rice client side tables.
* rice
  * bootstrap - bootstrap sql files for the rice tables.  This may contain rice or kc data but only for rice tables.  Includes client side tables as well.
  * demo - this contains a set of demo data.  This may contain rice or kc data but only for rice tables.
  * stage - this contains a set of staging data.  This may contain rice or kc data but only for rice tables.

* rice_data_only
  * bootstrap - this contains the rice bootstrap sql files but only the DML files related to KC.  This is used for when you are managing the rice server separates in a standalone configuration where the rice server has already been upgraded.

* rice_server
  * bootstrap - bootstrap sql files for the rice tables.  This may contain rice or kc data but only for rice tables.  Does not includes client side tables.  This is used for when you are managing the rice server separates in a standalone configuration where the rice server has not been upgraded.

# File Naming

KC's sql process is using the file naming structure, which will always be of the form V601_005__File_Name.sql. Additionally our convention is to use the current version of KC followed by a unique number within that version. So the 8th script to be added for version 6.0.1 of KC would be called V601_008__File_name.sql. After that number you must ensure there are two(2) underscores. '__'. Without this the process will throw an exception and the KC server(with process enabled) will fail to start. Also we are using the sql process for in-order processing only. If a script with a later version, V601_159__, is applied to a database, but afterwards a file with a lower verison, V601_158__, is added, the sql process will throw an exception on startup.

Additionaly KC and Rice share a common schema version. This means that when running in bundled mode each file must have a unique version number across all associated directories. This is an annoying aspect to the current process, but one which will hopefully be fixed in time by a separate CI job that will rename files after successfully being merged. But for now you should add the file to the kc-sql file as documented and then verify that your application still starts up without error.

And further, to add more complications, we also have custom Java based conversions. Currently there are 2 such conversions
```
src/main/java/co/kuali/coeus/data/migration/custom/coeus/V600_084__PropAwardPersonRoleConversion.java
/src/main/java/co/kuali/coeus/data/migration/custom/coeus/V600_085__ProposalRoleConversion.java
```
And as you can see those are similar version numbers and also compete with the existing SQL version numbers. So be aware of that if you get an error about a version you can't find amongst the sql files.

# SQL Standards

The Kuali Research team should be mindful of declared SQL standards when manipulating data.  These standards help with 
consistency, data integrity, and the stability of our database process.

## Primary Keys
  When creating a new SQL record, we should follow a process to determine how to assign primary keys values.
  
  If the primary key for a table does not use a sequence and is a part of a code table, pick a value that is not likely
  to conflict with customer instances.  
  
  If the primary key for a table uses a sequence do not use the sequence unless there is no other choice.
  If the primary key column is a varchar type, hardcode the primary key in the following format RESBOOTxxx where xxx is 
  some unique number.  If the primary key is a numeric type, see if we have a reserved range in use already or if you can
  reserve a new range.  For example: in some cases we use negative numbers to avoid collisions with customer data.  
  If it is impossible to hardcode a value for a primary key, then use the sequence for the table.
  
  Note: that when choosing a negative value make sure negatives are supported within our application in places such as 
  DataDictionary and validation rules.

## References
  When referring to an existing record in a SQL script, always use a primary key when hardcoded.  If this is not possible
  then refer to some other unique criteria keeping in mind that these records could have been updated in customer instances.
  Also, be sure to refer to an entire primary key in the case of compound primary keys.

## Constraints
  When creating new tables, always add constraints to a table.  This includes FK, PK, non-null and unique constraints.  
  Exceptions to this rule include FK constraints across modules.  

## Questionnaire:

  When adding new Question or Questionnaire records, use the proper sequences for each record; however, it is important to hardcode 
  Question ID/Questionnaire ID numbers. We have reserved a negative range for our bootstrap data for Question ID/Questionnaire ID
  for new records.  Be aware that older bootstrap question and questionnaire records are not using negative IDs. 
  When referring to existing bootstrap Question/Questionnaire records, always refer to the hardcoded Question ID/Questionnaire ID 
  and the max(sequence_number).  Do not assume that the sequence number used in the bootstrap data is the max(sequence_number) in
  a customer environment.  In other words, the Question ID/Questionnaire ID and max(sequence_number) provides
  a unique combination that can be used safely in SQL scripts.
  
  The following is an example referencing a question and questionnaire using Question ID/Questionnaire ID columns and max(sequence_number):
```  
INSERT INTO QUESTIONNAIRE_QUESTIONS (QUESTIONNAIRE_QUESTIONS_ID,QUESTIONNAIRE_REF_ID_FK,QUESTION_REF_ID_FK,QUESTION_NUMBER,PARENT_QUESTION_NUMBER,QUESTION_SEQ_NUMBER,CONDITION_FLAG,CONDITION_TYPE,CONDITION_VALUE,UPDATE_USER,UPDATE_TIMESTAMP,OBJ_ID,VER_NBR,RULE_ID)
VALUES (SEQ_QUESTIONNAIRE_REF_ID.nextval,
  (SELECT QUESTIONNAIRE_REF_ID FROM QUESTIONNAIRE WHERE QUESTIONNAIRE_ID = 5 AND SEQUENCE_NUMBER = 
    (select max(SEQUENCE_NUMBER) from QUESTIONNAIRE WHERE QUESTIONNAIRE_ID = 5)),
  (SELECT QUESTION_REF_ID FROM QUESTION WHERE QUESTION_ID = 100 AND SEQUENCE_NUMBER = 
    (select max(SEQUENCE_NUMBER) from QUESTION WHERE QUESTION_ID = 100)),
  295,0,1,'N',null,null,'admin',sysdate,SYS_GUID(),1,'KC152');
```

## Valid Narrative Forms:

  We should hardcode the primary key of new entries in valid_narr_forms using a negative number.  Also be mindful that currently our bootstrap
  data contains duplicate entries in regards to the combination of FORM_NAME and NARRATIVE_TYPE_CODE.
  
  See the following query that detects duplicates
  ```  
select * from (SELECT FORM_NAME, NARRATIVE_TYPE_CODE, count(*) as cnt FROM valid_narr_forms group by FORM_NAME, NARRATIVE_TYPE_CODE) t where cnt > 1;
  ```

## Parameters:

When adding new Parameters, use the format Foo_Bar_Baz as the parameter name.  Be sure to have a good description that
will make sense to technical administrators.

For boolean values, please use true/false rather than 0/1 or On/Off.

For new parameters, choose a sensible default value.

For updating existing parameters with a new value, keep in mind that a customer may have already updated the parameter.
Take this into consideration when developing the update statement so as to not change the customer's preferred configuration.

For a parameter that signifies a list of values, use semi-colon delimited values. 
See ParameterRepositoryService.getParameterValuesAsString() for more information.

For a parameter that contains a list of sub parameters, use semi-colon delimited sub parameter values. 
See ParameterRepositoryService.getSubParameterValueAsString() for more information.

## NIH Validation Mapping

For NIH Validation Mapping records, we may provide bootstrap records but customers may also add their own records.  In
order to safely add records to this table, we need to ensure that a record with the unique RULE_NUMBER does not already exist.
This will require a unique solution per DB platform.

For mysql:

```
insert into SEQ_NIH_VALIDATION values (null);
insert ignore into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
((select max(ID) from SEQ_NIH_VALIDATION), '001.16.1', 'A custom Message.',
'0', '1', '', '', '1', 'admin', NOW(), '1', UUID());

```

For oracle:

```
BEGIN
  insert into NIH_VALIDATION_MAPPING (ID, RULE_NUMBER, CUSTOM_MSG, FORCE_ERROR, APPEND_TO_ORIGINAL, PAGE_ID,
  SECTION_ID, ACTIVE, UPDATE_USER, UPDATE_TIMESTAMP, VER_NBR, OBJ_ID) values
  (SEQ_NIH_VALIDATION.nextval, '001.16.1', 'A custom Message.', '0', '1', '', '', '1', 'admin', SYSDATE, '1', SYS_GUID());
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('Ignore insert for RULE_NUMBER 001.16.1');
END;
/
```