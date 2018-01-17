/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
$j = jQuery.noConflict();

function populateQualifier(roleSelect, qualifierSelect) {
	var role = jq(roleSelect).attr('value');
	callAjaxByPath('../jqueryAjax.do', 'getNotificationRoleSubQualifiers', role,
			function(data) {
				qualifiers = eval('(' + jq(data).find('#ret_value').html() + ')');
				jq(qualifierSelect).html('');
				if (qualifiers.length == 0) {
					jq(qualifierSelect).attr('disabled', 'disabled');
				} else {
					var options = '';
					for (var i = 0; i < qualifiers.length; i++) {
						var item = qualifiers[i];
						options += "<option value='" + item.key + "'>" + item.value + "</option>";
					}
					jq(qualifierSelect).html(options);
					jq(qualifierSelect).removeAttr('disabled');
				}
			},
			function(error) {
				alert(error);
			},$j('[name=csrfToken]').val()
	);
}

jq(document).ready(function() {
	jq('select[name*="roleName"]').each(function() {
		populateQualifier(this, 
				jq(this).parent().parent().next().find('select[name*="roleSubQualifier"]').first());
	});
	jq('select[name*="roleName"]').change(function() {
		populateQualifier(this, 
				jq(this).parent().parent().next().find('select[name*="roleSubQualifier"]').first());
	});
});
