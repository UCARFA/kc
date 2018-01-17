/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
    $jq(document).ready(function(){
      $jq.ajaxSettings.cache = false; 
      $jq("#medusaview").treeview({
                animated: "fast",
                collapsed: true,
                control: "#treecontrol"
              });

      $jq(document).ajaxStart(function(){
         $jq("#loading").show();
       });

      $jq(document).ajaxComplete(function(){
         $jq("#loading").hide();
       });
      $jq('#medusaview .medusaNode a').click(function() {
    	  var myDetails = getDetailsFromLink(this);
    	  if (myDetails.is(':visible')) {
    		  myDetails.slideUp(300);
    	  } else {
    		  //hide all other details
    		  $jq('#medusaview .medusaDetails').slideUp(300);
    		  //check to see if data has been loaded already
    		  if (!myDetails.is('.medusaDetailsLoaded')) {
    			  var moduleName = $jq(this).attr('name').split('-')[0];
    			  var moduleId = $jq(this).attr('name').split('-')[1];
    			  loadNodeFromModule(moduleName, moduleId, this);
    		  } else {
    			  myDetails.slideDown(300);
    		  }
    	  }
      });
      //hide any open links in details already loaded
      $jq('span.medusaNode a.hideOpen').each(function() { getDetailsFromLink(this).find('.medusaOpenLink').hide(); });
    });
         
    function processError(htmlObject, errorMessage, exception){
        alert('Error loading document. Please try again.');
     }
  
  function hasFormAlreadyBeenSubmitted() {
      // return false;
  }    
  
  function addDetails(context, data, textStatus, httpRequest) {
	  var myDetails = getDetailsFromLink(context);
	  myDetails.html(data).slideDown(300);
	  myDetails.addClass("medusaDetailsLoaded");
	  if ($jq(context).hasClass('hideOpen')) {
		 myDetails.find('.medusaOpenLink').hide();  
	  }
  }
  
  function getDetailsFromLink(link) {
	  return $jq(link).parent().parent().find("> .medusaDetails");
  }
  
  function loadNodeFromModule(moduleName, moduleId, myContext){ 
      
      $jq.ajax({
        url: 'medusaAjax.do',
        type: 'GET',
        dataType: 'html',
        cache: false,
        data:'medusaBean.moduleName=' + moduleName + '&medusaBean.moduleIdentifier=' + moduleId + '&csrfToken=' + $jq('[name=csrfToken]').val(),
        async:false,
        timeout: 15000,
        context: myContext,
        error:processError,
        success:function(data, textStatus) {
      	  return addDetails(myContext, data, textStatus);
        }
       });  
    }   
