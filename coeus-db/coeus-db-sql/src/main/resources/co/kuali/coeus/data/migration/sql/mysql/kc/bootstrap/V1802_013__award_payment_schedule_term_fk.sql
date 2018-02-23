--
-- Copyright © 2005-2018 Kuali, Inc.
-- All Rights Reserved
-- You may use and modify this code under the terms of the Kuali, Inc.
-- Pre-Release License Agreement. You may not distribute it.
--
-- You should have received a copy of the Kuali, Inc. Pre-Release License
-- Agreement with this file. If not, please write to license@kuali.co.
--

alter table award_payment_schedule add column award_report_term_id decimal(12, 0) null;

alter table award_payment_schedule add constraint fk3_award_payment_schedule
foreign key (award_report_term_id) references award_report_terms(award_report_terms_id);
