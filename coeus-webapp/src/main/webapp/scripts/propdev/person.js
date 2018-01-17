/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
var Kc = Kc || {};
Kc.PropDev.Personnel = Kc.PropDev.Personnel || {};
(function(namespace, $) {
	$(document).on("ready", function() {
		$(document).on("shown.bs.tab", "#PropDev-PersonnelPage-Collection [data-type='Uif-TabGroup']", function(e) {
			var selectedTab = e.target;
			var index = $(selectedTab).parent().index();
			var tabContent = $(selectedTab).parents("[data-type='Uif-TabGroup']").find(".tab-content > :eq("+index+")");
			var placeHolder = tabContent.find("> span.uif-placeholder");
			if (placeHolder.length) {
				var id = placeHolder.attr("id");
				retrieveComponent(id);
			}
		});
	});

	namespace.unselectCollectionRadioButtons = function(selectedRadio, otherRadioSelector) {
		$(selectedRadio).parents('table:first').find(otherRadioSelector).each(function() {
			var inputField = $(this).parents('div:first');
			if (inputField[0] !== selectedRadio) {
				$(this).prop('checked', false);
			}
		});
	};
	namespace.verifyCollectionRadioButtons = function(parentId, radioSelector) {
		var selected = 0;
		selected = $('#' + parentId + " " + radioSelector + ":checked").length;
		if (selected != 1) {
			return false;
		} else {
			return true;
		}
	};
	namespace.validateWizard = function(wizardId) {
		messageSummariesShown = true;

		// Doing this custom because this is not functionality built in
		$('#' + wizardId).removeAttr('data-parent');

		var valid = $('#kualiLightboxForm').valid();
		messageSummariesShown = false;
		return valid;
	};
    namespace.selectFirstRadio = function(id) {
		if ($(id).find("input:checked").size() < 1) {
			$(id).find('input').not("input[disabled='disabled']").first().prop('checked', true);
		}
    };
})(Kc.PropDev.Personnel, jQuery);
