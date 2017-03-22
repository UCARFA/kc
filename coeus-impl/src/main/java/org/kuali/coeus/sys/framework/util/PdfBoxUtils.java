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
package org.kuali.coeus.sys.framework.util;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.annotation.*;
import org.apache.pdfbox.pdmodel.interactive.form.*;

import java.io.IOException;
import java.util.List;


public final class PdfBoxUtils {

    private static final Log LOG = LogFactory.getLog(PdfBoxUtils.class);
    private static final String DEFAULT_APPEARANCE = "/TimesNewRoman 0 Tf 0 0 0 rg";

    private PdfBoxUtils() {
        throw new UnsupportedOperationException("do not call");
    }

    public static void setField(PDDocument pdfDocument, String name, String value) {

        if (pdfDocument == null) {
            throw new IllegalArgumentException("pdfDocument is null");
        }

        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name is blank");
        }

        if (value == null) {
            throw new IllegalArgumentException("value is null");
        }

        final PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        final PDAcroForm acroForm = docCatalog.getAcroForm();
        final PDField field = acroForm.getField(name);

        if (field != null) {
            try {
                if (field instanceof PDCheckBox) {
                    field.setValue("Yes");
                } else if (field instanceof PDComboBox) {
                    field.setValue(value);
                } else if (field instanceof PDListBox) {
                    field.setValue(value);
                } else if (field instanceof PDRadioButton) {
                    field.setValue(value);
                } else if (field instanceof PDTextField) {
                    field.setValue(value);
                    //for some reason flattened pdfs have invisible text unless you explicitly set the text and background color
                    //then the document must be flattened with refreshAppearances=true in order for these changes to apply
                    ((PDTextField) field).setDefaultAppearance(DEFAULT_APPEARANCE);
                    if (field.getWidgets() != null) {
                        field.getWidgets().forEach(w -> w.getAppearanceCharacteristics().setBackground(new PDColor(new float[]{255,255,255}, PDDeviceRGB.INSTANCE)));
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            LOG.error("No field found with name:" + name);
        }
    }

    public static void flatten(PDDocument pdfDocument) {

        if (pdfDocument == null) {
            throw new IllegalArgumentException("pdfDocument is null");
        }

        //when flattening with refreshAppearances, a NPE will occur if each widget doesn't have a
        //PDAppearanceDictionary instance with a normal PDAppearanceEntry instance set
        pdfDocument.getDocumentCatalog().getAcroForm().getFields()
                .stream()
                .flatMap(f -> f.getWidgets().stream())
                .filter(w -> w.getAppearance() == null)
                .forEach(w -> {
                    final PDAppearanceDictionary appearance = new PDAppearanceDictionary(new COSDictionary());
                    appearance.setNormalAppearance(new PDAppearanceEntry(new COSDictionary()));
                    w.setAppearance(appearance);
                });

        try {
            pdfDocument.getDocumentCatalog().getAcroForm().flatten(pdfDocument.getDocumentCatalog().getAcroForm().getFields(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logFields(PDDocument pdfDocument) {

        if (pdfDocument == null) {
            throw new IllegalArgumentException("pdfDocument is null");
        }

        if (!LOG.isInfoEnabled()) {
            return;
        }

        final PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        final PDAcroForm acroForm = docCatalog.getAcroForm();
        final List<PDField> fields = acroForm.getFields();
        LOG.info(fields.size() + " top-level fields were found on the form");
        fields.forEach(field -> processField(field, "|--", field.getPartialName()));
    }

    private static void processField(PDField field, String sLevel, String sParent) {
        final String partialName = field.getPartialName();

        if (field instanceof PDNonTerminalField) {
            if (!sParent.equals(field.getPartialName())) {
                if (partialName != null) {
                    sParent = sParent + "." + partialName;
                }
            }
            LOG.info(sLevel + sParent);
            for (PDField child : ((PDNonTerminalField)field).getChildren()) {
                processField(child, "|  " + sLevel, sParent);
            }
        } else {
            final String fieldValue = field.getValueAsString();
            final StringBuilder outputString = new StringBuilder(sLevel);
            outputString.append(sParent);
            if (partialName != null) {
                outputString.append(".").append(partialName);
            }
            outputString.append(" = ").append(fieldValue);
            outputString.append(",  type=").append(field.getClass().getName());
            LOG.info(outputString);
        }
    }
}
