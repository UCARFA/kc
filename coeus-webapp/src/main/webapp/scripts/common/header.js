/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

if (!window.location.origin) {
  window.location.origin = window.location.protocol + "//" + window.location.hostname + (window.location.port ? ':' + window.location.port: '');
}

var Kc = Kc || {};
Kc.Global = Kc.Global || {};
(function (namespace, $) {
	namespace.ensureOneHeaderAction = 'Kc.Global.EnsureOneHeaderMessageAction';
	namespace.receiveHeaderMessage = function(event) {
		var origin = event.origin || event.originalEvent.origin;
		if (origin === window.location.origin && event.data.action === namespace.ensureOneHeaderAction) {
			window.location = event.data.location;
		}
	};
	namespace.onHeaderLoad = function() {
		window.addEventListener("message", Kc.Global.receiveHeaderMessage, false);
		if (window.parent !== window) {
			window.parent.postMessage({action : Kc.Global.ensureOneHeaderAction, location : window.location.href}, '*');
			//posting to the parent's parent due to the extra XDM iframe in the KNS portal
			if (window.parent.parent && window.parent.parent !== window) {
				window.parent.parent.postMessage({action : Kc.Global.ensureOneHeaderAction, location : window.location.href}, '*');
			}
		}
	};
	namespace.onKnsHeaderLoad = function() {
		window.addEventListener("message", Kc.Global.receiveHeaderMessage, false);
	};
})(Kc.Global, jQuery);
