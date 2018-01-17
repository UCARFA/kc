<%--
 Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 You may use and modify this code under the terms of the Kuali, Inc.
 Pre-Release License Agreement. You may not distribute it.
 You should have received a copy of the Kuali, Inc. Pre-Release License
 Agreement with this file. If not, please write to license@kuali.co.
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Medusa</title>
        <link rel="stylesheet" href="/${appContext}/themes/kboot/stylesheets/kboot.${riceVersion}.min.css" type="text/css" />
        <link rel="stylesheet" href="/${appContext}/css/medusa-react.css" type="text/css" />
    </head>
    <body>
        <noscript>
            JavaScript must be enabled to use the React Medusa interface.
        </noscript>
        <div id="medusaRoot"></div>
        <script type="text/javascript">
            var reactContext = {};
            reactContext.appContext = "${appContext}";
            reactContext.module = "${module}";
            reactContext.moduleId = ${moduleId};
        </script>
        <script src="/${appContext}/client/assets/medusaClient-${frontendTimestamp}.js"></script>
    </body>
</html>
