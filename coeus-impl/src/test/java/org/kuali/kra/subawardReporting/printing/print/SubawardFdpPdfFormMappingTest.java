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
package org.kuali.kra.subawardReporting.printing.print;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.junit.Test;
import org.kuali.rice.core.api.util.ClassLoaderUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.Arrays;

public class SubawardFdpPdfFormMappingTest {

    @Test
    public void test_mapping() throws Exception {
        final Resource pdf = new DefaultResourceLoader(ClassLoaderUtils.getDefaultClassLoader()).getResource("classpath:org/kuali/kra/subawardReporting/printing/print/fdpAttachment2.pdf");
        try (PDDocument document = PDDocument.load(pdf.getInputStream())) {
            final PDDocumentCatalog docCatalog = document.getDocumentCatalog();
            final PDAcroForm acroForm = docCatalog.getAcroForm();

            Assert.notNull(acroForm, "pdf has no form");

            Arrays.stream(AbstractSubawardFdp.Pdf.Field.values()).forEach(f -> {
                PDField field = acroForm.getField(f.getfName());
                Assert.notNull(field, "field does not exist " + f.getfName());

                if (!f.getValues().isEmpty()) {
                    f.getValues().forEach(v -> {
                        try {

                            field.setValue(v);
                        } catch (IOException e) {
                            throw new RuntimeException("error setting value for field" + f.getfName(), e);
                        }
                    });
                } else {
                    try {
                        if (field instanceof PDCheckBox) {
                            field.setValue("Yes");
                        } else {
                            field.setValue(field.getPartialName());
                        }
                    } catch (IOException e) {
                        throw new RuntimeException("error setting value for field" + f.getfName(), e);
                    }
                }
            });
        }
    }
}
