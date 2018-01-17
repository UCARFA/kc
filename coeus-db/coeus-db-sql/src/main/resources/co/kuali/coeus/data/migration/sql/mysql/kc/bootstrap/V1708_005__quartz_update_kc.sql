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
alter table kc_qrtz_job_details add column is_nonconcurrent bool;
alter table kc_qrtz_job_details add column is_update_data bool;
update kc_qrtz_job_details set is_nonconcurrent = is_stateful;
update kc_qrtz_job_details set is_update_data = is_stateful;
alter table kc_qrtz_job_details drop column is_stateful;
alter table kc_qrtz_fired_triggers add column is_nonconcurrent bool;
alter table kc_qrtz_fired_triggers add column is_update_data bool;
update kc_qrtz_fired_triggers set is_nonconcurrent = is_stateful;
update kc_qrtz_fired_triggers set is_update_data = is_stateful;
alter table kc_qrtz_fired_triggers drop column is_stateful;

--
-- add new 'sched_name' column to all tables
--
alter table kc_qrtz_blob_triggers add column sched_name varchar(120) not null DEFAULT 'kcScheduler';
alter table kc_qrtz_calendars add column sched_name varchar(120) not null DEFAULT 'kcScheduler';
alter table kc_qrtz_cron_triggers add column sched_name varchar(120) not null DEFAULT 'kcScheduler';
alter table kc_qrtz_fired_triggers add column sched_name varchar(120) not null DEFAULT 'kcScheduler';
alter table kc_qrtz_fired_triggers add column sched_time bigint(13) not null;
alter table kc_qrtz_job_details add column sched_name varchar(120) not null DEFAULT 'kcScheduler';
alter table kc_qrtz_locks add column sched_name varchar(120) not null DEFAULT 'kcScheduler';
alter table kc_qrtz_paused_trigger_grps add column sched_name varchar(120) not null DEFAULT 'kcScheduler';
alter table kc_qrtz_scheduler_state add column sched_name varchar(120) not null DEFAULT 'kcScheduler';
alter table kc_qrtz_simple_triggers add column sched_name varchar(120) not null DEFAULT 'kcScheduler';
alter table kc_qrtz_triggers add column sched_name varchar(120) not null DEFAULT 'kcScheduler';


--
-- drop all primary and foreign key constraints, so that we can define new ones
--
alter table kc_qrtz_blob_triggers  drop foreign key FK_KC_QRTZ_BLOB_TRIGGERS;
alter table kc_qrtz_simple_triggers drop foreign key FK_KC_QRTZ_SIMPLE_TRIGGERS;
alter table kc_qrtz_cron_triggers drop foreign key FK_KC_QRTZ_CRON_TRIGGERS;
alter table kc_qrtz_job_details drop primary key, add primary key (job_name, job_group, sched_name);

--
-- add all primary and foreign key constraint s, based on new columns
--
alter table kc_qrtz_triggers drop primary key, add primary key (trigger_name, trigger_group, sched_name);
alter table kc_qrtz_blob_triggers drop primary key, add primary key (trigger_name, trigger_group, sched_name);
alter table KC_QRTZ_BLOB_TRIGGERS add  constraint  KC_QRTZ_BLOB_TRIGGERS_TR1 foreign key(trigger_name, trigger_group, sched_name) references KC_QRTZ_TRIGGERS (trigger_name, trigger_group, sched_name);
alter table kc_qrtz_cron_triggers drop primary key, add primary key (trigger_name, trigger_group, sched_name);
alter table kc_qrtz_cron_triggers add  constraint  KC_QRTZ_CRON_TRIGGERS_TR1 foreign key(trigger_name, trigger_group, sched_name) references kc_qrtz_triggers(trigger_name, trigger_group, sched_name);
alter table kc_qrtz_simple_triggers drop primary key, add primary key (trigger_name, trigger_group, sched_name);
alter table kc_qrtz_simple_triggers add  constraint  KC_QRTZ_SIMPLE_TRIGGERS_TR1 foreign key(trigger_name, trigger_group, sched_name) references kc_qrtz_triggers(trigger_name, trigger_group, sched_name);
alter table kc_qrtz_fired_triggers drop primary key, add primary key (entry_id, sched_name);
alter table kc_qrtz_calendars drop primary key, add primary key (calendar_name, sched_name);
alter table kc_qrtz_locks drop primary key, add primary key (lock_name, sched_name);
alter table kc_qrtz_paused_trigger_grps drop primary key, add primary key (trigger_group, sched_name);
alter table kc_qrtz_scheduler_state drop primary key, add primary key (instance_name, sched_name);

--
-- add new simprop_triggers table
--
CREATE TABLE kc_qrtz_simprop_triggers
(
  SCHED_NAME VARCHAR(120) NOT NULL,
  TRIGGER_NAME VARCHAR(200) NOT NULL,
  TRIGGER_GROUP VARCHAR(200) NOT NULL,
  STR_PROP_1 VARCHAR(512) NULL,
  STR_PROP_2 VARCHAR(512) NULL,
  STR_PROP_3 VARCHAR(512) NULL,
  INT_PROP_1 INT NULL,
  INT_PROP_2 INT NULL,
  LONG_PROP_1 BIGINT NULL,
  LONG_PROP_2 BIGINT NULL,
  DEC_PROP_1 NUMERIC(13,4) NULL,
  DEC_PROP_2 NUMERIC(13,4) NULL,
  BOOL_PROP_1 BOOL NULL,
  BOOL_PROP_2 BOOL NULL,
  primary key (SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP),
  constraint KC_QRTZ_SIMPROP_TRIGGERS_TR1 foreign key(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP)
  references kc_QRTZ_TRIGGERS(TRIGGER_NAME,TRIGGER_GROUP,SCHED_NAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


