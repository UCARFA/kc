<#--
   - Copyright © 2005-2018 Kuali, Inc.
   - All Rights Reserved
   - You may use and modify this code under the terms of the Kuali, Inc.
   - Pre-Release License Agreement. You may not distribute it.
   -
   - You should have received a copy of the Kuali, Inc. Pre-Release License
   - Agreement with this file. If not, please write to license@kuali.co.
-->
<#macro uif_medusaReact group>

    <noscript>
        JavaScript must be enabled to use the React Medusa interface.
    </noscript>
    <@krad.div component=group>
    </@krad.div>
    <script type="text/javascript">
        var reactContext = {};
        reactContext.appContext = "${ConfigProperties['app.context.name']}";
        reactContext.module = 'DP';
        reactContext.moduleId = ${KualiForm.developmentProposal.proposalNumber};
    </script>

</#macro>
