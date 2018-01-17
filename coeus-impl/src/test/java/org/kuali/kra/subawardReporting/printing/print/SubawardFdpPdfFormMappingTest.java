/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
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
import java.util.Set;

public class SubawardFdpPdfFormMappingTest {

    @Test
    public void test_mapping_attachment_2() throws Exception {
        final Resource pdf = new DefaultResourceLoader(ClassLoaderUtils.getDefaultClassLoader()).getResource("classpath:org/kuali/kra/subawardReporting/printing/print/fdpAttachment2.pdf");
        try (PDDocument document = PDDocument.load(pdf.getInputStream())) {
            final PDDocumentCatalog docCatalog = document.getDocumentCatalog();
            final PDAcroForm acroForm = docCatalog.getAcroForm();

            Assert.notNull(acroForm, "pdf has no form");
            Arrays.stream(AbstractSubawardFdp.Attachment2Pdf.Field.values()).forEach(f -> setValue(acroForm, f.getfName(), f.getValues()));
        }
    }

    @Test
    public void test_mapping_agreement() throws Exception {
        final Resource pdf = new DefaultResourceLoader(ClassLoaderUtils.getDefaultClassLoader()).getResource("classpath:org/kuali/kra/subawardReporting/printing/print/fdpAgreement.pdf");
        try (PDDocument document = PDDocument.load(pdf.getInputStream())) {
            final PDDocumentCatalog docCatalog = document.getDocumentCatalog();
            final PDAcroForm acroForm = docCatalog.getAcroForm();

            Assert.notNull(acroForm, "pdf has no form");
            Arrays.stream(AbstractSubawardFdp.AgreementPdf.Field.values()).forEach(f -> setValue(acroForm, f.getfName(), f.getValues()));
        }
    }

    @Test
    public void test_mapping_agreement_certification() throws Exception {
        final Resource pdf = new DefaultResourceLoader(ClassLoaderUtils.getDefaultClassLoader()).getResource("classpath:org/kuali/kra/subawardReporting/printing/print/fdpAttachment1.pdf");
        try (PDDocument document = PDDocument.load(pdf.getInputStream())) {
            final PDDocumentCatalog docCatalog = document.getDocumentCatalog();
            final PDAcroForm acroForm = docCatalog.getAcroForm();

            Assert.notNull(acroForm, "pdf has no form");
            Arrays.stream(AbstractSubawardFdp.AgreementCertificationPdf.Field.values()).forEach(f -> setValue(acroForm, f.getfName(), f.getValues()));
        }
    }

    private void setValue(PDAcroForm acroForm, String fieldName, Set<String> values) {
        PDField field = acroForm.getField(fieldName);
        Assert.notNull(field, "field does not exist " + fieldName);

        if (!values.isEmpty()) {
            values.forEach(v -> {
                try {

                    field.setValue(v);
                } catch (IOException e) {
                    throw new RuntimeException("error setting value for field" + fieldName, e);
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
                throw new RuntimeException("error setting value for field" + fieldName, e);
            }
        }
    }
}
