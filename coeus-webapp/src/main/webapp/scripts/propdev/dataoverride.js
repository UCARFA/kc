/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
var Kc = Kc || {};
Kc.PropDev.DataOverride = Kc.PropDev.DataOverride || {};
(function(namespace, $) {
    namespace.init = function() {
        $('#PropDev-DataOverride-ColumnName').on('change', function(e) {ajaxSubmitForm('prepareDataOverride');})
        $('#PropDev-DataOverride-Dialog').on(kradVariables.EVENTS.UPDATE_CONTENT, function(e) {
            $('#PropDev-DataOverride-ColumnName').on('change', function(e) {ajaxSubmitForm('prepareDataOverride');});
        })
        };
})(Kc.PropDev.DataOverride, jQuery);
