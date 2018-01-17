/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
var RiceContrib = RiceContrib || {};
RiceContrib.MultiSelect = RiceContrib.MultiSelect || {};
(function(namespace, $) {
	namespace.init = function() {
		$('.selectpicker').selectpicker('refresh');
		$('select.advanced_select').each(function() {
			if ($(this).siblings('.bootstrap-select').length == 0) {
				var template = $(this).data('template');
				var defaultSettings = {
					selectedTextFormat : "count > 5",
					liveSearch : $(this).attr('multiple') ? true : false
				};
				
				$(this).selectpicker($.extend({}, defaultSettings, template));
			}
		});
	};
})(RiceContrib.MultiSelect, jQuery);

jQuery(document).ready(function() {
    RiceContrib.MultiSelect.init();
    jQuery("[data-role='View']").on(kradVariables.EVENTS.UPDATE_CONTENT, RiceContrib.MultiSelect.init);
});
