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

var AJAX_LOCATION = "awardHierarchyTimeAndMoneyAjax.do";
var ROOT_AWARD_LOCATION = "document.rootAwardNumber";
var openAwards = [];
var prevScrollPosition;

const viewOption = {
    dates:            0,
    distributable:    1,
    totals:           2,
};

jQuery(document).ready(function(){
    jQuery('#awardHierarchyScrollable').scroll(function() {saveScrollPosition(this);});

    if (openAwards.length > 0) {
        forceLoading();
        queueToggle(null, openPreviousAwards);
    } else {
        queueToggle(null);
    }
});

function addOpenAward(award) {
    openAwards.push(award);
}

function setScrollPosition(scrollPos) {
    prevScrollPosition = scrollPos;
}

function saveScrollPosition(scroll) {
    var offset = jQuery(scroll).offset().top;
    debugLog('Current Position - ' + jQuery(scroll).scrollTop());
    var liList = jQuery(scroll).find('li.awardhierarchy').toArray();
    var li = null;
    for (var i = 1; i < liList.length; i++) {
        if (jQuery(liList[i]) != null && jQuery(liList[i]).offset() != null
            && jQuery(liList[i-1]) != null
            && jQuery(liList[i]).offset().top > offset
            && (jQuery(liList[i-1]).offset() == null || jQuery(liList[i-1]).offset().top < offset)) {
            li = liList[i];
            break;
        }
    }
    if (li != null) {
        debugLog('Scrolling to ' + getAwardNumber(li) + ' next time.');
        jQuery('input[name*=awardHierarchyScrollPosition]').attr('value', getAwardNumber(li));
    } else {
        jQuery('input[name*=awardHierarchyScrollPosition]').attr('value', '');
    }
}

function treeViewToggle(item) {
    if (!jQuery(item).is('.loaded')) {
        queueToggle(item);
    }
    if (jQuery(item).is('.collapsable')) {
        debugLog('Setting award to open next time ' + getAwardNumber(item));
        jQuery(item).find("input[name*='awardHierarchyToggle']").first().attr('value', 'true');
    } else {
        jQuery(item).find("input[name*='awardHierarchyToggle']").first().attr('value', 'false');
    }
}

function openPreviousAwards(requestTracker) {
    if (requestTracker.liNode != null) {
        jQuery(requestTracker.liNode).find('div.expandable-hitarea:first').click();
    }
    jQuery(requestTracker.children).each(function() {
        var awardNumber = getAwardNumber(this);
        var idx = jQuery.inArray(awardNumber, openAwards);
        debugLog(idx + ' -- ' + awardNumber + ' -- ' + openAwards);
        if (idx != -1) {
            queueToggle(this, openPreviousAwards);
            openAwards.splice(idx, 1);
        }
    });
    if (activeRequest == null && pendingRequests.length == 0) {
        clearForceLoading();
        //make sure loading is hidden so we can get the offset of the div and the selected award
        jQuery('#loading').hide();
        debugLog('Scroll height ' + jQuery('#awardHierarchyScrollable > ul').outerHeight() + ", " + prevScrollPosition + " position is " + jQuery('#li' + prevScrollPosition).position().top);
        jQuery('#awardHierarchyScrollable').scrollTop(
            jQuery('#li' + prevScrollPosition).position().top
        );
    }
}

function addAwardToHierarchy(info, parent) {
    var awardNumber = info['awardNumber'];
    //build the line description - will include the award number, pi, lead unit and
    //editable and/or summary fields for time and money.
    var idDiv = jQuery('<div class="awardHierarchy"></div>').html(builduUi(info, awardNumber));
    //add the div to the link
    var tag = jQuery('<a class="awardHierarchy"></a>').html(idDiv);

    var listitem = jQuery('<li class="closed awardhierarchy" id="li' + awardNumber +'"></li>').html(tag);

    // need this ultag to force to display folder.
    var childUlTag = jQuery('<ul></ul>');
    childUlTag.appendTo(listitem);
    listitem.appendTo(jQuery(parent));
    // also need this to show 'folder' icon
    jQuery('#awardhierarchy').treeview({
        add: listitem
    });
    return listitem;
}

/*
 * Utility function to get code from 'code : description' This need to be
 * refined because if code contains ':', then this is not working correctly.
 */
function getAwardNumber(node) {
    var liNode = node;
    if (!jQuery(liNode).is('li.awardhierarchy')) {
        alert('looking for parent');
        liNode = jQuery(node).parents('li.awardhierarchy:eq(0)');
    }
    return jQuery(liNode).attr('id').substring(2);
}

function getDetailString(info) {
    return info['awardNumber'] + " : " + info['accountNumber'] + " : " + info['principalInvestigatorName'] + " : " + info['leadUnitName'];
}

function hasFormAlreadyBeenSubmitted() {
    // return false;
}

function canceledOrFinalStatus() {
    return jQuery("#canceledOrFinalStatus").attr("value") === 1;
}

function currentViewOption(opt) {
    if (opt) return parseInt(jQuery("#controlForAwardHierarchyView").attr("value")) === opt;
    return parseInt(jQuery("#controlForAwardHierarchyView").attr("value"));
}

function directIndirectViewEnabled() {
    return jQuery("#directIndirectViewEnabled").attr("value") === 1;
}

function inSingleNodeHierarchy() {
    return jQuery("#inSingleNodeHierarchy").attr("value") === 1;
}

function builduUi(info, awardNumber) {
    var text1 = getDetailString(info);
    var text2 = info['currentFundEffectiveDate'];
    var text3 = info['obligationExpirationDate'];
    var text4 = info['finalExpirationDate'];
    var text5 = info['amountObligatedToDate'];
    var text6 = info['anticipatedTotalAmount'];
    var text7 = info['obliDistributableAmount'];
    var text8 = info['antDistributableAmount'];
    var text9 = info['distributedObligatedAmount'];
    var text10 = info['distributedAnticipatedAmount'];
    var text11 = info['awardStatusCode'];
    var text12 = info['obligatedTotalDirect'];
    var text13 = info['obligatedTotalIndirect'];
    var text14 = info['anticipatedTotalDirect'];
    var text15 = info['anticipatedTotalIndirect'];
    var text16 = info['projectStartDate'];
    var text17 = info['title'];
    var text18 = info['awardId'];
    var text19 = info['awardDocumentNumber'];

    var txtImage = (function(status) {
        var images = {
            1:      '<img src="static/images/award_active.gif" alt="Active" title="Active" />',
            2:      '<img src="static/images/award_inactive.gif" alt="Inactive" title="Inactive"/>',
            3:      '<img src="static/images/award_pending.gif" alt="Pending" title="Pending"/>',
            4:      '<img src="static/images/award_inactive.gif" alt="Terminated" title="Terminated"/>',
            5:      '<img src="static/images/award_inactive.gif" alt="Closed" title="Closed" />',
            6:      '<img src="static/images/award_holding.gif" alt="Hold" title="Hold"/>'
        };

        return images[status];
    })(text11);

    var index = awardNumber.indexOf("-");
    var awardNumber2 = parseInt(awardNumber.substring(index+1), 10);

    var disabledText='';
    if (document.getElementById("disableCurrentValues").value=='true') {
        disabledText=' disabled ';
    }

    // templates are deeply nested objects where the keys are the status or other selected UI options.
    // example:
    //    var template = templates[canceledOrFinalStatus()][currentViewOption()];
    // example when "totals" view option is selected:
    //    if (currentViewOption(viewOption.totals)) {
    //      var template = templates[canceledOrFinalStatus()][currentViewOption()][directIndirectViewEnabled()][inSingleNodeHierarchy()];
    //    }
    var templates = {
        // canceledOrFinalStatus
        true: {

            // dates
            0: "<table class='outer-table'><tbody><tr><td>" + txtImage + " " + text1 + "</td><td>" + text2 + "</td><td>" + text3 + "</td><td>" + text4 + "</td></tr></tbody></table>",

            // distributed/distributable
            1: "<table class='outer-table'><tbody><tr><td>" + txtImage + " " + text1 + "</td><td>${text2}</td><td>" + text3 + "</td><td>" + text4 + "</td>" +
            +"<td>Distributed:</td>"
            + "<td>" + text9 + "</td>"
            + "<td>" + text10 + "</td>"
            + "</tr></tbody></table>"
            + "<table class='dist-table'><tbody><tr>"
            + "<td>"
            + "<td class='static'>Distributable:</td>"
            + "<td>" + text7 + "</td>"
            + "<td>" + text8 + "</td>"
            + "</tr></tbody></table>"
            + "<table class='dist-table'><tbody><tr>"
            + "<td>"
            + "<td class='static'>Total:</td>"
            + "<td>" + text5 + "</td>"
            + "<td>" + text6 + "</td>"
            + "</tr></tbody></table>",

            // totals
            2: {

                // directIndirectViewEnabled
                true: {

                    // inSingleNodeHierarchy
                    true: "<table class='outer-table'>" + txtImage + " " + text1 + "</td>" +
                    "<td>" + text2 + "</td>" +
                    "<td>" + text3 + "</td>" +
                    "<td>" + text4 + "</td>" +
                    "<td>"
                    + "<input type=\"text\" class = 'input' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligatedTotalDirect\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligatedTotalDirect\"" + " value=\"" + text12 + "\"" + disabledText + "/></td>" +
                    "<td>"
                    + "<input type=\"text\" class = 'input' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligatedTotalIndirect\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligatedTotalIndirect\"" + " value=\"" + text13 + "\"" + disabledText + "/></td>" +
                    "<td>" + text5 + "</td>" +
                    "<td>"
                    + "<input type=\"text\" class = 'input' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].anticipatedTotalDirect\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].anticipatedTotalDirect\"" + " value=\"" + text14 + "\"" + disabledText + "/></td>" +
                    "<td>"
                    + "<input type=\"text\" class = 'input' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].anticipatedTotalIndirect\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].anticipatedTotalIndirect\"" + " value=\"" + text15 + "\"" + disabledText + "/></td>"
                    + "<td>" + text6 + "</td>"
                    + "</tr></tbody></table>",

                    // not inSingleNodeHierarchy
                    false: "<table class='outer-table'><tbody><tr><td>" + txtImage + "&nbsp;" + text1 + "</td>" +
                    "<td>" + text2 + "</td>" +
                    "<td>" + text3 + "</td>" +
                    "<td>" + text4 + "</td>"
                    + "<td>" + text12 + "</td>"
                    + "<td>" + text13 + "</td>"
                    + "<td>" + text5 + "</td>"
                    + "<td>" + text14 + "</td>"
                    + "<td>" + text15 + "</td>"
                    + "<td>" + text6 + "</td>" + "</tr></tbody></table>",
                },

                // not directIndirectViewEnabled
                false: {

                    // inSingleNodeHierarchy
                    true: "<table class='outer-table'>" + txtImage + "&nbsp;" + text1 + "</td>" +
                    "<td>" + text2 + "</td>" +
                    "<td>" + text3 + "</td>" +
                    "<td>" + text4 + "</td>" +
                    "<td>"
                    + "<input type=\"text\" class = 'input' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].amountObligatedToDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].amountObligatedToDate\"" + " value=\"" + text5 + "\"" + disabledText + "/></td>" +
                    "<td>"
                    + "<input type=\"text\" class = 'input' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].anticipatedTotalAmount\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].anticipatedTotalAmount\"" + " value=\"" + text6 + "\"" + disabledText + "/></td>"
                    + "</tr></tbody></table>",

                    // not inSingleNodeHierarchy
                    false: "<table class='outer-table'><tbody><tr><td>" + txtImage + "&nbsp;" + text1 + "</td>" +
                    "<td>" + text2 + "</td>" +
                    "<td>" + text3 + "</td>" +
                    "<td>" + text4 + "</td>" +
                    "<td>"
                    + text5 + "</td><td >"
                    + text6 + "</td>"
                    + "</tr></tbody></table>",
                }
            },
        },

        // not canceledOrFinalStatus
        false: {

            // dates
            0:
            "<table class='outer-table'><tbody><tr><td>" + txtImage + " " + text1 + "</td>"
            + "<td><input type='hidden' name='awardHierarchyNodeItems[" + awardNumber2 + "].populatedFromClient' id='awardHierarchyNodeItems[" + awardNumber2 + "].populatedFromClient' value='true'/>"
            + "<input type='text' class='datepicker' name='awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate' id='awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate' value='" + text2 + "'/></td>"
            + "<td><input type='text' class='datepicker' name='awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate' id='awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate' value='" + text3 +"'/></td>"
            + "<td nowrap><input type='text' class='datepicker' name='awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate' id='awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate' value='" + text4 + "'/></td>"
            + "</tr></tbody></table>",

            // distributed/distributable
            1: "<table class='outer-table'><tbody><tr><td>" + txtImage + " " + text1 + "</td>"
            + "<td><input type='hidden' name='awardHierarchyNodeItems[" + awardNumber2 + "].populatedFromClient' id='awardHierarchyNodeItems[" + awardNumber2 + "].populatedFromClient'" + " value='true'/>"
            + "<input type='text' class='datepicker' name='awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate' id='awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate' value='" + text2 + "'/>"
            + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate")
            + "</td><td>"
            + "<input type='text' name='awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate' id='awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate' value='" + text3 + "' class='datepicker'/>"
            + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate")
            + "</td><td>"
            + "<input type='text' class='datepicker' name='awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate' id='awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate' value='" + text4 + "'/>"
            + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate")
            + "</td><td>Distributed:</td>"
            + "<td>" + text9 + "</td>"
            + "<td>" + text10 + "</td>"
            + "</tr></tbody></table>"
            + "<table class='dist-table'><tbody><tr>"
            + "<td>"
            + "<td>Distributable:</td>"
            + "<td>" + text7 + "</td>"
            + "<td>" + text8 + "</td>"
            + "</tr></tbody></table>"
            + "<table class='dist-table'><tbody><tr>"
            + "<td>"
            + "<td>Total:</td>"
            + "<td>" + text5 + "</td>"
            + "<td>" + text6 + "</td>"
            + "</tr></tbody></table>",

            // totals
            2: {

                // directIndirectViewEnabled
                true: {

                    // inSingleNodeHierarchy
                    true: "<table class='outer-table'><tbody><tr><td>" + txtImage + "&nbsp;" + text1 + "</td><td>"
                    + "<input type='hidden' name='awardHierarchyNodeItems[" + awardNumber2 + "].populatedFromClient' id='awardHierarchyNodeItems[" + awardNumber2 + "].populatedFromClient'" + " value='true'/>"
                    + "<input type=\"text\" class = 'datepicker' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate\"" + " value=\"" + text2 + "\"/>"
                    + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate")
                    + "</td><td>"
                    + "<input type=\"text\" class = 'datepicker' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate\"" + " value=\"" + text3 + "\"/>"
                    + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate")
                    + "</td><td>"
                    + "<input type=\"text\" class = 'datepicker' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate\"" + " value=\"" + text4 + "\"/>"
                    + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate")
                    + "</td><td>"
                    + "<input type=\"text\" class = 'input' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligatedTotalDirect\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligatedTotalDirect\"" + " value=\"" + text12 + "\"" + disabledText + "/>"
                    + "</td><td>"
                    + "<input type=\"text\" class = 'input' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligatedTotalIndirect\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligatedTotalIndirect\"" + " value=\"" + text13 + "\"" + disabledText + "/>"
                    + "</td><td>" + text5 + "</td>"
                    + "<td>"
                    + "<input type=\"text\" class = 'input' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].anticipatedTotalDirect\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].anticipatedTotalDirect\"" + " value=\"" + text14 + "\"" + disabledText + "/>"
                    + "</td><td>"
                    + "<input type=\"text\" class = 'input' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].anticipatedTotalIndirect\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].anticipatedTotalIndirect\"" + " value=\"" + text15 + "\"" + disabledText + "/>"
                    + "</td><td>" + text6 + "</td>"
                    + "</tr></tbody></table>",

                    // not inSingleNodeHierarchy
                    false: "<table class='outer-table'><tbody><tr><td>" + txtImage + "&nbsp;" + text1 + "</td><td>"
                    + "<input type='hidden' name='awardHierarchyNodeItems[" + awardNumber2 + "].populatedFromClient' id='awardHierarchyNodeItems[" + awardNumber2 + "].populatedFromClient'" + " value='true'/>"
                    + "<input type=\"text\" class = 'datepicker' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate\"" + " value=\"" + text2 + "\" />"
                    + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate")
                    + "</td><td>"
                    + "<input type=\"text\" class = 'datepicker' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate\"" + " value=\"" + text3 + "\" />"
                    + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate")
                    + "</td><td>"
                    + "<input type=\"text\" class = 'datepicker' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate\"" + " value=\"" + text4 + "\"/></td>"
                    + "<td>" + text12 + "</td>"
                    + "<td>" + text13 + "</td>"
                    + "<td>" + text5 + "</td>"
                    + "<td>" + text14 + "</td>"
                    + "<td>" + text15 + "</td>"
                    + "<td>" + text6 + "</td>" + "</tr></tbody></table>",
                },

                // not directIndirectViewEnabled
                false: {

                    // inSingleNodeHierarchy
                    true: "<table class='outer-table'><tbody><tr><td>" + txtImage + "&nbsp;" + text1 + "</td><td>"
                    + "<input type='hidden' name='awardHierarchyNodeItems[" + awardNumber2 + "].populatedFromClient' id='awardHierarchyNodeItems[" + awardNumber2 + "].populatedFromClient'" + " value='true'/>"
                    + "<input type=\"text\" class = 'datepicker' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate\" value=\"" + text2 + "\"/>"
                    + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate")
                    + "</td><td>"
                    + "<input type=\"text\" class = 'datepicker' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate\" value=\"" + text3 + "\"/>"
                    + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate")
                    + "</td><td>"
                    + "<input type=\"text\" class = 'datepicker' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate\" value=\"" + text4 + "\"/>"
                    + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate")
                    + "</td>" + "<td>"
                    + "<input type=\"text\" class = 'input' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].amountObligatedToDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].amountObligatedToDate\" value=\"" + text5 + "\"" + disabledText + "/></td>" +
                    "<td>"
                    + "<input type=\"text\" class = 'input' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].anticipatedTotalAmount\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].anticipatedTotalAmount\" value=\"" + text6 + "\"" + disabledText + "/></td>"
                    + "</tr></tbody></table>",


                    // not inSingleNodeHierarchy
                    false: "<table class='outer-table'><tbody><tr><td>" + txtImage + "&nbsp;" + text1 + "</td><td>"
                    + "<input type='hidden' name='awardHierarchyNodeItems[" + awardNumber2 + "].populatedFromClient' id='awardHierarchyNodeItems[" + awardNumber2 + "].populatedFromClient'" + " value='true'/>"
                    + "<input type=\"text\" class = 'datepicker' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate\" value=\"" + text2 + "\"/>"
                    + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].currentFundEffectiveDate")
                    + "</td><td>"
                    + "<input type=\"text\" class = 'datepicker' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate\" value=\"" + text3 + "\"/>"
                    + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].obligationExpirationDate")
                    + "</td><td>"
                    + "<input type=\"text\" class = 'datepicker' name=\"awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate\" id=\"awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate\" value=\"" + text4 + "\"/>"
                    + displayErrorIconAsNeeded("awardHierarchyNodeItems[" + awardNumber2 + "].finalExpirationDate")
                    + "</td>"
                    + "<td>"
                    + text5 + "</td><td>"
                    + text6 + "</td>"
                    + "</tr></tbody></table>",
                }
            }
        }
    };

    var element = templates[canceledOrFinalStatus()][currentViewOption()];

    if (currentViewOption(viewOption.totals)) element = element[directIndirectViewEnabled()][inSingleNodeHierarchy()];

    element += "<input type='hidden' value='false' name='awardHierarchyToggle(" + awardNumber + ")'/>";
    return element;
}

function displayErrorIconAsNeeded(propertyFieldName) {
    var errorImage = "<img src=\"kr/images/errormark.gif\" alt=\"Error\" title=\"Error\" />";
    var fieldsInErrorElement = document.getElementById('formFieldsInError');
    if (fieldsInErrorElement.value.toLowerCase().indexOf(propertyFieldName.toLowerCase()) >= 0){
        return errorImage;
    } else {
        return "";
    }
}

function clickViaRadioButton() {
    var buttons = document.getElementsByName("methodToCall.refreshView");
    buttons[0].click();
}
