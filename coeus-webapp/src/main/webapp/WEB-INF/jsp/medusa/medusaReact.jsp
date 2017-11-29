<%--
  ~ Kuali Coeus, a comprehensive research administration system for higher education.
  ~
  ~ Copyright 2005-2017 Kuali, Inc.
  ~
  ~ This program is free software: you can redistribute it and/or modify
  ~ it under the terms of the GNU Affero General Public License as
  ~ published by the Free Software Foundation, either version 3 of the
  ~ License, or (at your option) any later version.
  ~
  ~ This program is distributed in the hope that it will be useful,
  ~ but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~ MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  ~ GNU Affero General Public License for more details.
  ~
  ~ You should have received a copy of the GNU Affero General Public License
  ~ along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
