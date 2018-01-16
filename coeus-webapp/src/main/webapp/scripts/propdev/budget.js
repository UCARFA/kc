/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
var Kc = Kc || {};
Kc.PropDev = Kc.PropDev || {};
Kc.PropDev.Budget = Kc.PropDev.Budget || {};
(function(namespace, $) {
	namespace.copyBudget = function(budgetId, e) {
		$(e.currentTarget).find("input[name$='originalBudgetId']").val(budgetId);
	};
    namespace.totalUnallocatedFandA = function (values){
        return namespace.calculateTotalFromValues(values, $('#PropBudget-UnrecoveredFandAPage-Group').data('total_unrecovered'));
    };
    namespace.totalUnallocatedCostSharing = function (values){
        return namespace.calculateTotalFromValues(values, $('#PropBudget-CostSharingPage-CollectionGroup').data('total_costsharing'));
    };
    namespace.calculateTotalFromValues = function (values, total) {
        var calcTotal = String(total).replace(/[$,]/g, '') * 100;
        for (var i = 0; i < values.length; i++) {
            calcTotal -= (values[i] * 100);
        }
        return Kc.PropDev.Budget.formatMoney(new Number(calcTotal/100),2, '.', ',')
    };
	namespace.formatMoney = function(num, c, d, t){
		var n = num, c = isNaN(c = Math.abs(c)) ? 2 : c, d = d == undefined ? "," : d, t = t == undefined ? "." : t, s = n < 0 ? "-" : "", i = parseInt(n = Math.abs(+n || 0).toFixed(c)) + "", j = (j = i.length) > 3 ? j % 3 : 0;
		   return s + (j ? i.substr(0, j) + t : "") + i.substr(j).replace(/(\d{3})(?=\d)/g, "$1" + t) + (c ? d + Math.abs(n - i).toFixed(c).slice(2) : "");
	};
	namespace.calculateTotal = function(inputField) {
		var total = 0;
		$(inputField).parents('tr').first().find('.calculateTotal input.form-control').each(function() {
			var fieldValue = String($(this).val()).replace(/[$,]/g, '');
			if (fieldValue == '') fieldValue = 0;
			total = total + parseFloat(fieldValue);
		});
		if (!isNaN(total)) {
			var formattedTotal = this.formatMoney(new Number(total), 2, '.', ',');
			var amountSpan = $(inputField).parents('tr').first().find('.totalCost');
			if (amountSpan.children('input').length > 0) {
				amountSpan.children('input').first().val(formattedTotal);
			} else {
				amountSpan.html(formattedTotal);
			}
		}
	};
	namespace.refreshAddPersonnelDialog = function() {
		if ($("select[name='addProjectPersonnelHelper.lineType']").val() == "T") {
			retrieveComponent('PropBudget-ProjectPersonnelPage-Wizard');
		}
	};
})(Kc.PropDev.Budget, jQuery);

function totalUnallocatedCostSharing (values){
    return Kc.PropDev.Budget.totalUnallocatedCostSharing(values);
}

function totalUnallocatedFandA (values) {
    return Kc.PropDev.Budget.totalUnallocatedFandA(values);
}

/**
 * Override
 * KRAD calculation function - limit to 2 decimals
 * Get the sum of the values passed in
 *
 * @param values the values
 */
function sumValues(values) {
    var total = 0;
    for (var i = 0; i < values.length; i++) {
		var value = values[i];
		if (isNaN(value)) {
			value.replace(/,/g,"");
		}
        total += value;
    }
    return Kc.PropDev.Budget.formatMoney(new Number(total),2, '.', ',')
}

/**
 * Override
 * Fix to remove all commas from complex numbers not just the first
 * @param value
 * @returns {*}
 */
function convertComplexNumericValue(value) {
	if (!value) {
		return value;
	}

	return value.replace(/$/g, "").replace(/,/g, "").replace("&yen;", "").replace("&euro;",
		"").replace("&pound;", "").replace("&curren;", "").replace("%", "").replace("&#8355;",
		"").replace("&#8356;", "").replace("&#8359;", "").replace("&cent;", "");
}


