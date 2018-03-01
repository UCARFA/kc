insert into s2s_error (s2s_error_id, message_key, message, fix_link, update_timestamp, update_user, ver_nbr, obj_id)
values (seq_s2s_error_id.nextval,
        '/GrantApplication/Forms/NSF_CoverPage_1_8/NSFUnitConsideration/DivisionCode',
        'Agency division code must be specified', 'proposal.SponsorProgramInformation', SYSDATE, 'admin', 1, sys_guid());

insert into s2s_error (s2s_error_id, message_key, message, fix_link, update_timestamp, update_user, ver_nbr, obj_id)
values (seq_s2s_error_id.nextval,
        '/GrantApplication/Forms/NSF_CoverPage_1_8/NSFUnitConsideration/ProgramCode',
        'Agency program code must be specified', 'proposal.SponsorProgramInformation', SYSDATE, 'admin', 1, sys_guid());

insert into s2s_error (s2s_error_id, message_key, message, fix_link, update_timestamp, update_user, ver_nbr, obj_id)
values (seq_s2s_error_id.nextval,
        '/GrantApplication/Forms/NSF_CoverPage_1_8/PIInfo',
        'PI needs to be added to proposal', 'keyPersonnel', SYSDATE, 'admin', 1, sys_guid());

insert into s2s_error (s2s_error_id, message_key, message, fix_link, update_timestamp, update_user, ver_nbr, obj_id)
values (seq_s2s_error_id.nextval,
        '/GrantApplication/Forms/NSF_CoverPage_1_8/OtherInfo',
        'Please answer all questions on the NSF Cover Page Questionnaire prior to submission or printing',
        'questions', SYSDATE, 'admin', 1, sys_guid());

insert into s2s_error (s2s_error_id, message_key, message, fix_link, update_timestamp, update_user, ver_nbr, obj_id)
values (seq_s2s_error_id.nextval,
        '/GrantApplication/Forms/NSF_CoverPage_1_8/NSFID',
        'NSF ID must be specified and must be a 9-digit number',
        'keyPersonnel', SYSDATE, 'admin', 1, sys_guid());

insert into s2s_error (s2s_error_id, message_key, message, fix_link, update_timestamp, update_user, ver_nbr, obj_id)
values (seq_s2s_error_id.nextval,
        '/GrantApplication/Forms/NSF_CoverPage_1_8',
        'You must include all required data and answer all required questions for this form',
        'questions', SYSDATE, 'admin', 1, sys_guid());

insert into s2s_error (s2s_error_id, message_key, message, fix_link, update_timestamp, update_user, ver_nbr, obj_id)
values (seq_s2s_error_id.nextval,
        '/GrantApplication/Forms/NSF_KeyPersonExpanded_1_1/PDPI/Profile/BioSketchsAttached/BioSketchAttached',
        'Each investigator must have a BioSketch attachment. Upload the PDF on the Personnel Attachments panel, with "Biosketch" as the attachment type.',
        'abstractsAttachments', SYSDATE, 'admin', 1, sys_guid());

insert into s2s_error (s2s_error_id, message_key, message, fix_link, update_timestamp, update_user, ver_nbr, obj_id)
values (seq_s2s_error_id.nextval,
        '/GrantApplication/Forms/NSF_KeyPersonExpanded_1_1/PDPI/Profile/SupportsAttached/SupportAttached',
        'Each investigator must have a Current Pending attachment. Upload the PDF on the Personnel Attachments panel, with "Currentpending" as the attachment type.',
        'abstractsAttachments', SYSDATE, 'admin', 1, sys_guid());

insert into s2s_error (s2s_error_id, message_key, message, fix_link, update_timestamp, update_user, ver_nbr, obj_id)
values (seq_s2s_error_id.nextval,
        '/GrantApplication/Forms/NSF_KeyPersonExpanded_1_1/PDPI/Profile/CollaboratorsAttached/CollaboratorAttached',
        'Each investigator must have an NSF Collaborator attachment. Upload the PDF on the Personnel Attachments panel, with "NSF_Collaborator" as the attachment type.',
        'abstractsAttachments', SYSDATE, 'admin', 1, sys_guid());

insert into s2s_error (s2s_error_id, message_key, message, fix_link, update_timestamp, update_user, ver_nbr, obj_id)
values (seq_s2s_error_id.nextval,
        '/GrantApplication/Forms/NSF_KeyPersonExpanded_1_1/PDPI/Profile',
        'PI needs to be added to proposal', 'keyPersonnel', SYSDATE, 'admin', 1, sys_guid());
        
update questionnaire_usage set questionnaire_label = 'NSF 1-7 and 1-8 Cover Page Questionnaire'
where questionnaire_ref_id_fk = (
    select questionnaire_ref_id from questionnaire
    where (questionnaire_id, sequence_number) = (
        select questionnaire_id, max(sequence_number) from questionnaire
        where name = 'NSF cover page 1-7 - 1-8 supporting questions'
        group by questionnaire_id));
