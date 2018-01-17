/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
var Kc = Kc || {};
Kc.Iframe = Kc.Iframe || {};
(function (namespace, $) {
    $(document).on("ready", function () {
        Kc.Iframe.resizeIframe();
    });

    $(window).on("resize", function () {
        Kc.Iframe.resizeIframe();
    });

    namespace.resizeIframe = function () {
        var appHeight = jQuery(window).height();
        var appHeaderHeight = jQuery("#Uif-ApplicationHeader-Wrapper").height();
        var appFooterHeight = jQuery("#Uif-ApplicationFooter-Wrapper").height();

        jQuery("#Kc-Header-IframeView iframe").height(appHeight - appHeaderHeight - appFooterHeight);
        jQuery("#Uif-ApplicationFooter-Wrapper").css("margin-top", "0px");
    }

})(Kc.Iframe, jQuery);