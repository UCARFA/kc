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
