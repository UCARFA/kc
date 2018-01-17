/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
var Kc = Kc || {};
Kc.PessimisticLock = Kc.PessimisticLock || {};
(function(namespace, $) {

    namespace.clearLock = function(id) {
        $.ajax('../kc-sys-krad/sys/pessimisticLock/'+ id, {type: 'DELETE'});
    };
})(Kc.PessimisticLock, jQuery);
