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

--
-- drop columns that are no longer used
--
alter table kc_qrtz_job_details drop column is_volatile;
alter table kc_qrtz_triggers drop column is_volatile;
alter table kc_qrtz_fired_triggers drop column is_volatile;

--
-- add new columns that replace the 'is_stateful' column
--
alter table kc_qrtz_job_details add is_nonconcurrent VARCHAR2(1);
alter table kc_qrtz_job_details add is_update_data VARCHAR2(1);
update kc_qrtz_job_details set is_nonconcurrent = is_stateful;
update kc_qrtz_job_details set is_update_data = is_stateful;
alter table kc_qrtz_job_details drop column is_stateful;
alter table kc_qrtz_fired_triggers add is_nonconcurrent VARCHAR2(1);
alter table kc_qrtz_fired_triggers add is_update_data VARCHAR2(1);
update kc_qrtz_fired_triggers set is_nonconcurrent = is_stateful;
update kc_qrtz_fired_triggers set is_update_data = is_stateful;
alter table kc_qrtz_fired_triggers drop column is_stateful;

--
-- add new 'sched_name' column to all tables
--
alter table kc_qrtz_blob_triggers add sched_name varchar(120) DEFAULT 'kcScheduler' not null;
alter table kc_qrtz_calendars add sched_name varchar(120) DEFAULT 'kcScheduler' not null;
alter table kc_qrtz_cron_triggers add sched_name varchar(120) DEFAULT 'kcScheduler' not null;
alter table kc_qrtz_fired_triggers add sched_name varchar(120)  DEFAULT 'kcScheduler' not null;
alter table kc_qrtz_fired_triggers add sched_time number(13) NOT NULL;
alter table kc_qrtz_job_details add sched_name varchar(120)  DEFAULT 'kcScheduler' not null;
alter table kc_qrtz_locks add sched_name varchar(120) DEFAULT 'kcScheduler' not null;
alter table kc_qrtz_paused_trigger_grps add sched_name varchar(120)  DEFAULT 'kcScheduler' not null;
alter table kc_qrtz_scheduler_state add sched_name varchar(120)  DEFAULT 'kcScheduler' not null;
alter table kc_qrtz_simple_triggers add sched_name varchar(120)  DEFAULT 'kcScheduler' not null;
alter table kc_qrtz_triggers add sched_name varchar(120) DEFAULT 'kcScheduler' not null;

--
-- drop all primary and foreign key constraints, so that we can define new ones
--
ALTER TABLE kc_qrtz_blob_triggers
  DROP PRIMARY KEY DROP INDEX;
ALTER TABLE kc_qrtz_blob_triggers
  DROP CONSTRAINT FK_KC_QRTZ_BLOB_TRIGGERS DROP INDEX;
ALTER TABLE kc_qrtz_simple_triggers
  DROP PRIMARY KEY DROP INDEX;
ALTER TABLE kc_qrtz_simple_triggers
  DROP CONSTRAINT FK_KC_QRTZ_SIMPLE_TRIGGERS DROP INDEX;
ALTER TABLE kc_qrtz_cron_triggers
  DROP PRIMARY KEY DROP INDEX;
ALTER TABLE kc_qrtz_cron_triggers
  DROP CONSTRAINT FK_KC_QRTZ_CRON_TRIGGERS DROP INDEX;
ALTER TABLE kc_qrtz_job_details
  DROP PRIMARY KEY DROP INDEX;
ALTER TABLE kc_qrtz_triggers
  DROP PRIMARY KEY DROP INDEX;

--
--
-- add all primary and foreign key constraints, based on new columns
--
alter table kc_qrtz_job_details add constraint KC_QRTZ_JOB_DETAILSP1 primary key (job_name, job_group, sched_name);
alter table kc_qrtz_triggers add constraint KC_QRTZ_TRIGGERSP1 primary key (trigger_name, trigger_group, sched_name);
alter table kc_qrtz_triggers add constraint KC_QRTZ_TRIGGERS_TR1 foreign key (job_name, job_group, sched_name) references kc_qrtz_job_details(job_name, job_group, sched_name);
alter table kc_qrtz_blob_triggers add constraint KC_QRTZ_BLOB_TRIGGERSP1 primary key (trigger_name, trigger_group, sched_name);
alter table kc_qrtz_blob_triggers add constraint KC_QRTZ_BLOB_TRIGGERS_TR1 foreign key (trigger_name, trigger_group, sched_name) references kc_qrtz_triggers(trigger_name, trigger_group, sched_name);
alter table kc_qrtz_cron_triggers add constraint KC_QRTZ_CRON_TRIGGERSP1 primary key (trigger_name, trigger_group, sched_name);
alter table kc_qrtz_cron_triggers add constraint KC_QRTZ_CRON_TRIGGERS_TR1 foreign key (trigger_name, trigger_group, sched_name) references kc_qrtz_triggers(trigger_name, trigger_group, sched_name);
alter table kc_qrtz_simple_triggers add constraint KC_QRTZ_SIMPLE_TRIGGERSP1 primary key (trigger_name, trigger_group, sched_name);
alter table kc_qrtz_simple_triggers add constraint KC_QRTZ_SIMPLE_TRIGGERS_TR1 foreign key (trigger_name, trigger_group, sched_name) references kc_qrtz_triggers(trigger_name, trigger_group, sched_name);
ALTER TABLE kc_qrtz_fired_triggers
  DROP CONSTRAINT KC_QRTZ_FIRED_TRIGGERSP1 DROP INDEX;
alter table kc_qrtz_fired_triggers add constraint KC_QRTZ_FIRED_TRIGGERSP1 primary key (entry_id, sched_name);
ALTER TABLE kc_qrtz_calendars
  DROP CONSTRAINT KC_QRTZ_CALENDARSP1 DROP INDEX;
alter table kc_qrtz_calendars add constraint KC_QRTZ_CALENDARSP1 primary key (calendar_name, sched_name);
ALTER TABLE kc_qrtz_locks
  DROP CONSTRAINT KC_QRTZ_LOCKSP1 DROP INDEX;
alter table kc_qrtz_locks add constraint KC_QRTZ_LOCKSP1 primary key (lock_name, sched_name);
ALTER TABLE kc_qrtz_paused_trigger_grps
  DROP CONSTRAINT KC_QRTZ_PAUSED_TRIGGER_GRP1 DROP INDEX;
alter table kc_qrtz_paused_trigger_grps add constraint KC_QRTZ_PAUSED_TRIGGER_GRP1 primary key (trigger_group, sched_name);
ALTER TABLE kc_qrtz_scheduler_state
  DROP CONSTRAINT KC_QRTZ_SCHEDULER_STATEP1 DROP INDEX;
alter table kc_qrtz_scheduler_state add constraint KC_QRTZ_SCHEDULER_STATEP1 primary key (instance_name, sched_name);

--
-- add new simprop_triggers table
--
CREATE TABLE kc_qrtz_simprop_triggers
(
  SCHED_NAME VARCHAR2(120) NOT NULL,
  TRIGGER_NAME VARCHAR2(200) NOT NULL,
  TRIGGER_GROUP VARCHAR2(200) NOT NULL,
  STR_PROP_1 VARCHAR2(512) NULL,
  STR_PROP_2 VARCHAR2(512) NULL,
  STR_PROP_3 VARCHAR2(512) NULL,
  INT_PROP_1 NUMBER(10) NULL,
  INT_PROP_2 NUMBER(10) NULL,
  LONG_PROP_1 NUMBER(13) NULL,
  LONG_PROP_2 NUMBER(13) NULL,
  DEC_PROP_1 NUMERIC(13,4) NULL,
  DEC_PROP_2 NUMERIC(13,4) NULL,
  BOOL_PROP_1 VARCHAR2(1) NULL,
  BOOL_PROP_2 VARCHAR2(1) NULL,
  constraint KC_QRTZ_SIMPROP_TRIGGERSP1 primary key (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
  constraint KC_QRTZ_SIMPROP_TRIGGERS_TR1 foreign key (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
  references KC_QRTZ_TRIGGERS(TRIGGER_NAME,TRIGGER_GROUP, SCHED_NAME)
);

