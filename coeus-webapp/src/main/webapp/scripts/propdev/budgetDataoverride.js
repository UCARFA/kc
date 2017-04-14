/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
var Kc = Kc || {};
Kc.PropBudget = Kc.PropBudget || {};
Kc.PropBudget.DataOverride = Kc.PropBudget.DataOverride || {};
(function(namespace, $) {
    namespace.init = function() {
        $('#PropBudget-DataOverride-ColumnName').on('change', function(e) {ajaxSubmitForm('prepareDataOverride');})
        $('#PropBudget-DataOverride-Dialog').on(kradVariables.EVENTS.UPDATE_CONTENT, function(e) {
            $('#PropBudget-DataOverride-ColumnName').on('change', function(e) {ajaxSubmitForm('prepareDataOverride');});
        })
    };
})(Kc.PropBudget.DataOverride, jQuery);
