--
-- Kuali Coeus, a comprehensive research administration system for higher education.
--
-- Copyright 2005-2018 Kuali, Inc.
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

alter table award_report_tracking add award_id decimal(22);

update award_report_tracking art
	inner join (
		select *
		from award_report_terms
		where award_id in (
			select award_id from award
			where award_sequence_status in ('PENDING', 'ACTIVE'))) terms
	on art.award_number = terms.award_number
	and art.report_class_code = terms.report_class_code
	and art.report_code = terms.report_code
	and art.frequency_code = terms.frequency_code
	and (art.frequency_base_code = terms.frequency_base_code or
		(art.frequency_base_code is null and terms.frequency_base_code is null))
	and (art.osp_distribution_code = terms.osp_distribution_code or
		(art.osp_distribution_code is null and terms.osp_distribution_code is null))
	and (art.due_date = due_date or frequency_base_code in ('1', '2', '3', '4', '5'))
set art.award_id = terms.award_id,
	art.award_report_term_id = terms.award_report_terms_id;
