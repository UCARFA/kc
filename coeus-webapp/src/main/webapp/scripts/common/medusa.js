/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
var Kc = Kc || {};
Kc.Medusa = Kc.Medusa || {};
(function(namespace, $) {
	namespace.minimizeMedusaTrees = function() {
		$('section.medusa div.medusa-node').prev().off('click.medusa');
		$('section.medusa div.medusa-node').prev().on('click.medusa', function(){

            $(this).siblings('.medusa-node').toggle();

            //18px is the width of the jstree icon
            if (!$(this).siblings('.medusa-node').is(":hidden")) {
                $(this).siblings('.medusa-node').css('margin-left','18px');
            }
            return true;
        });
        $('section.medusa div.medusa-node').hide();
        $('section.medusa div.jstree').jstree('open_all');

	}

    namespace.externalMedusaLoader = function() {
    	namespace.lazyMedusaLoader();
    }
    
    namespace.lazyMedusaLoader = function() {
        //minimizeMedusaTrees gets called before the jstree functionality.  set a timer to wait for it to be added.
        var timer = undefined;

        timer = setInterval(function() {
            if ($('section.medusa div.jstree')){
                clearInterval(timer);
                namespace.minimizeMedusaTrees();
            }
        },10);
    }
})(Kc.Medusa, jQuery);
