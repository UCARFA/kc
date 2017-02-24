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

update award_approved_foreign_travel set TRAVELER_NAME = replace(trim(TRAVELER_NAME), '  ', ' ') where TRAVELER_NAME is not null;
update award_persons set FULL_NAME = replace(trim(FULL_NAME), '  ', ' ') where FULL_NAME is not null;
update award_report_tracking set PI_NAME = replace(trim(PI_NAME), '  ', ' ') where PI_NAME is not null;
update award_report_tracking set PREPARER_NAME = replace(trim(PREPARER_NAME), '  ', ' ') where PREPARER_NAME is not null;
update award_sponsor_contacts set FULL_NAME = replace(trim(FULL_NAME), '  ', ' ') where FULL_NAME is not null;
update award_unit_contacts set FULL_NAME = replace(trim(FULL_NAME), '  ', ' ') where FULL_NAME is not null;
update budget_persons set PERSON_NAME = replace(trim(PERSON_NAME), '  ', ' ') where PERSON_NAME is not null;
update coi_disclosure_attachment set CONTACT_NAME = replace(trim(CONTACT_NAME), '  ', ' ') where CONTACT_NAME is not null;
update comm_memberships set PERSON_NAME = replace(trim(PERSON_NAME), '  ', ' ') where PERSON_NAME is not null;
update comm_schedule_attendance set PERSON_NAME = replace(trim(PERSON_NAME), '  ', ' ') where PERSON_NAME is not null;
update eps_prop_person set FULL_NAME = replace(trim(FULL_NAME), '  ', ' ') where FULL_NAME is not null;
update iacuc_protocol_attach_protocol set CONTACT_NAME = replace(trim(CONTACT_NAME), '  ', ' ') where CONTACT_NAME is not null;
update iacuc_protocol_persons set PERSON_NAME = replace(trim(PERSON_NAME), '  ', ' ') where PERSON_NAME is not null;
update iacuc_protocol_persons set FULL_NAME = replace(trim(FULL_NAME), '  ', ' ') where FULL_NAME is not null;
update iacuc_protocol_persons set PERSON_NAME = replace(trim(PERSON_NAME), '  ', ' ') where PERSON_NAME is not null;
update narrative set CONTACT_NAME = replace(trim(CONTACT_NAME), '  ', ' ') where CONTACT_NAME is not null;
update negotiation set NEGOTIATOR_FULL_NAME = replace(trim(NEGOTIATOR_FULL_NAME), '  ', ' ') where NEGOTIATOR_FULL_NAME is not null;
update negotiation_unassoc_detail set PI_NAME = replace(trim(PI_NAME), '  ', ' ') where PI_NAME is not null;
update proposal_log set PI_NAME = replace(trim(PI_NAME), '  ', ' ') where PI_NAME is not null;
update proposal_persons set FULL_NAME = replace(trim(FULL_NAME), '  ', ' ') where FULL_NAME is not null;
update proposal_unit_contacts set FULL_NAME = replace(trim(FULL_NAME), '  ', ' ') where FULL_NAME is not null;
update protocol_attachment_protocol set CONTACT_NAME = replace(trim(CONTACT_NAME), '  ', ' ') where CONTACT_NAME is not null;
update protocol_persons set PERSON_NAME = replace(trim(PERSON_NAME), '  ', ' ') where PERSON_NAME is not null;
update protocol_persons set FULL_NAME = replace(trim(FULL_NAME), '  ', ' ') where FULL_NAME is not null;
update tbn set PERSON_NAME = replace(trim(PERSON_NAME), '  ', ' ') where PERSON_NAME is not null;