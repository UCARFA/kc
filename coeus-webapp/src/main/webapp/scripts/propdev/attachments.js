/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
var Kc = Kc || {};
Kc.PropDev.Attachments = Kc.PropDev.Attachments || {};
(function(namespace, $) {
    $(document).on("paste keypress", ".abstractDetails", function(e){
        if (!e.ctrlKey && !e.metaKey) {
            namespace.removeWarning(this);
            namespace.addWarning(this);
        }

    });
    namespace.addWarning = function(element) {
        setTimeout(function () {
            var value = $(element).val().replace(/(\r\n|\n|\r)/g, '--');
            if (value.length >= 49000) {
                $(element).closest("div").prepend("<span class='alert-warning'>Data entry for this field is limited to 49,000 characters (with spaces).</span>");
                $(element).closest("div").addClass("has-warning")
            }
        },10);
    }
    namespace.removeWarning = function(element) {
        $(element).closest("div").find("span.alert-warning").remove();
        $(element).closest("div").removeClass("has-warning")
    }
    namespace.initAttachmentCounts = function(){
        $("#PropDev-AttachmentsPage").ajaxSuccess(function() {
            var proposalAttachmentCount = $("#PropDev-AttachmentsPage-ProposalCollection-Collection").find("tbody").find("tr").size();
            var personnelAttachmentCount = $("#PropDev-AttachmentsPage-PersonnelCollection-Collection").find("tbody").find("tr").size();
            var abstractCount = $(".proposalAbstractCollection").find("tbody").find("tr").size();
            var internalAttachmentCount = $("#PropDev-AttachmentsPage-InternalCollection-Collection").find("tbody").find("tr").size();
            var noteCount = $(".proposalNoteCollection").find("tbody").find("tr").size();

            $(".proposalAttachmentCount").html(proposalAttachmentCount);
            $(".personnelAttachmentCount").html(personnelAttachmentCount);
            $(".abstractCount").html(abstractCount);
            $(".internalAttachmentCount").html(internalAttachmentCount);
            $(".noteCount").html(noteCount);

        });
    };
    namespace.checkforExistingAttachmentsOnParent = function(element) {
        var select = $(element).find("select");
        var previousValue = $(select).data("previousValue");
        if (typeof previousValue  === "undefined") {
            previousValue = "";
        }
        var currentValue = $(select).val();
        var propertyPath = $(select).attr("name");
        ajaxSubmitForm('checkForExistingNarratives',{currentValue:currentValue,previousValue:previousValue,propertyPath:propertyPath});
    }
    namespace.capturePreviousNarrativeType = function(element) {
        var select = $(element).find("select");
        $(select).data("previousValue",$(select).val());
    }
})(Kc.PropDev.Attachments, jQuery);
