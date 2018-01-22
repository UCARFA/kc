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
import org.junit.Assert;
import org.junit.Test;
import org.kuali.rice.core.api.util.ClassLoaderUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SubawardFdpPdfFormMappingTest {

    @Test
    public void test_mapping_attachment_2() throws Exception {
        testMapping("classpath:org/kuali/kra/subawardReporting/printing/print/fdpAttachment2.pdf", AbstractSubawardFdp.Attachment2Pdf.Field.values());
    }

    @Test
    public void test_mapping_agreement() throws Exception {
        testMapping("classpath:org/kuali/kra/subawardReporting/printing/print/fdpAgreement.pdf", AbstractSubawardFdp.AgreementPdf.Field.values());
    }

    @Test
    public void test_mapping_agreement_certification() throws Exception {
        testMapping("classpath:org/kuali/kra/subawardReporting/printing/print/fdpAttachment1.pdf", AbstractSubawardFdp.AgreementCertificationPdf.Field.values());
    }

    @Test
    public void test_mapping_attachment_3a_() throws Exception {
        testMapping("classpath:org/kuali/kra/subawardReporting/printing/print/fdpAttachment3a.pdf", AbstractSubawardFdp.Attachment3aPdf.Field.values());
    }

    private void testMapping(String pdfFile, AbstractSubawardFdp.PdfField[] fields) throws IOException {
        final Resource pdf = new DefaultResourceLoader(ClassLoaderUtils.getDefaultClassLoader()).getResource(pdfFile);
        try (PDDocument document = PDDocument.load(pdf.getInputStream())) {
            final PDDocumentCatalog docCatalog = document.getDocumentCatalog();
            final PDAcroForm acroForm = docCatalog.getAcroForm();

            Assert.assertNotNull("pdf has no form", acroForm);
            final List<FieldException> exceptions = Arrays.stream(fields)
                    .map(f -> {
                        try {
                            setValue(acroForm, f);
                        } catch (FieldException e) {
                            return e;
                        }
                        return null;
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            Assert.assertTrue(exceptions.stream().map(Throwable::getMessage).collect(Collectors.joining("\n")), exceptions.isEmpty());
        }
    }

    private void setValue(PDAcroForm acroForm, AbstractSubawardFdp.PdfField pdfField) {
        PDField field = acroForm.getField(pdfField.getfName());
        if (field == null) {
            throw new FieldException("field does not exist " + pdfField.getfName());
        }

        if (!pdfField.isReadOnly()) {
            if (!pdfField.getValues().isEmpty()) {
                pdfField.getValues().forEach(v -> {
                    try {

                        field.setValue(v);
                    } catch (IOException e) {
                        throw new FieldException("error setting value for field" + pdfField.getfName(), e);
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
                    throw new FieldException("error setting value for field" + pdfField.getfName(), e);
                }
            }
        }
    }

    static class FieldException extends RuntimeException {
        FieldException(String message) {
            super(message);
        }

        FieldException(String message, Throwable t) {
            super(message, t);
        }
    }
}
