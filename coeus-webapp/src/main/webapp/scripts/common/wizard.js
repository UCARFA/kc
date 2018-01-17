/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
var Kc = Kc || {};
Kc.Wizard = Kc.Wizard || {};
(function(namespace, $) {

    namespace.returnToFirstResultsPage = function() {
        $('.modal-body').find('a.first').click();
    };
})(Kc.Wizard, jQuery);
