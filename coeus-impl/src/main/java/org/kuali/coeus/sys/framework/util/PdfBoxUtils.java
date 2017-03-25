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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public final class PdfBoxUtils {

    private static final Log LOG = LogFactory.getLog(PdfBoxUtils.class);
    private static final String DEFAULT_APPEARANCE = "/TimesNewRoman 0 Tf 0 0 0 rg";
    private static final String SEPARATOR = ".";
    private static final String TOP_LEVEL = "|--";
    private static final String CHILD_LEVEL = "|  ";
    private static final String FIELD_VAL_SEPARATOR = " = ";
    private static final String TYPE_STR = "type=";
    private static final String NO_FORM_FIELDS_MSG = " top-level fields were found on the form";
    private static final String COMMA_SEPARATOR = ",  ";
    private static final String VAL_START = "<";
    private static final String VAL_END = ">";

    private PdfBoxUtils() {
        throw new UnsupportedOperationException("do not call");
    }

    /**
     * Shows a form field on a PDF Document.  If a field is not found nothing happens.
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @param name the field name. Cannot be blank.
     * @throws IllegalArgumentException if document is null or name is blank.
     */
    public static void showField(PDDocument pdfDocument, String name) {
        toggleFieldVisibility(pdfDocument, name, false);
    }

    /**
     * Hides a form field on a PDF Document.  If a field is not found nothing happens.
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @param name the field name. Cannot be blank.
     * @throws IllegalArgumentException if document is null or name is blank.
     */
    public static void hideField(PDDocument pdfDocument, String name) {
        toggleFieldVisibility(pdfDocument, name, true);
    }

    /**
     * Toggles the visibility of a form field on a PDF Document.  If a field is not found nothing happens.
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @param name the field name. Cannot be blank.
     * @param visibility true is NOT visible, false is visible
     * @throws IllegalArgumentException if document is null or name is blank.
     */
    public static void toggleFieldVisibility(PDDocument pdfDocument, String name, boolean visibility) {
        if (pdfDocument == null) {
            throw new IllegalArgumentException("pdfDocument is null");
        }

        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("name is blank");
        }

        final PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        final PDAcroForm acroForm = docCatalog.getAcroForm();
        final PDField field = acroForm.getField(name);

        if (field != null) {
            if (field.getWidgets() != null) {
                field.getWidgets().forEach(w -> {
                    w.setInvisible(visibility);
                    w.setHidden(visibility);
                });
            }
        } else {
            LOG.error("No field found with name:" + name);
        }
    }

    /**
     * Sets a form field value on a PDF Document.  If a field is not found nothing happens.
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @param name the field name. Cannot be blank.
     * @param value the value to set the field to.  Cannot be null of contain null values.
     * @throws IllegalArgumentException if document is null or name is blank or the value is null or contains null values.
     */
    public static void setField(PDDocument pdfDocument, String name, List<String> value) {
        setF(pdfDocument, name, value);
    }

    /**
     * Sets a form field value on a PDF Document.  If a field is not found nothing happens.
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @param name the field name. Cannot be blank.
     * @param value the value to set the field to.
     * @throws IllegalArgumentException if document is null or name is blank.
     */
    public static void setField(PDDocument pdfDocument, String name, boolean value) {
        setF(pdfDocument, name, value);
    }

    /**
     * Sets a form field value on a PDF Document.  If a field is not found nothing happens.
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @param name the field name. Cannot be blank.
     * @param value the value to set the field to.  Cannot be null.
     * @throws IllegalArgumentException if document is null or name is blank or value is null.
     */
    public static void setField(PDDocument pdfDocument, String name, String value) {
        setF(pdfDocument, name, value);
    }

    //purposely named different to avoid overloading with an Object type
    private static void setF(PDDocument pdfDocument, String name, Object value) {

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
            setField(field, value);
        } else {
            LOG.error("No field found with name:" + name);
        }
    }

    private static void setField(PDField field, Object value) {

        if (field == null) {
            throw new IllegalArgumentException("field is null");
        }

        if (value == null) {
            throw new IllegalArgumentException("value is null");
        }

        try {
            if (field instanceof PDTextField || field instanceof PDComboBox || field instanceof PDListBox || field instanceof PDRadioButton || field instanceof PDCheckBox) {
                if (value instanceof Boolean) {
                    field.setValue(booleanToStr((Boolean) value));
                } else if (value instanceof String) {
                    field.setValue((String) value);
                } else if (value instanceof List && field instanceof PDChoice) {
                    final List<String> converted = ((List<Object>) value).stream().map(v -> {
                        if (v instanceof String) {
                            return (String) v;
                        } else if (v instanceof Boolean) {
                            return booleanToStr((Boolean) v);
                        } else {
                            throw new IllegalArgumentException("Invalid value type in List " + (v != null ? v.getClass().getName() : "(null)"));
                        }
                    }).collect(Collectors.toList());

                    ((PDChoice) field).setValue(converted);
                } else {
                    throw new IllegalArgumentException(field.getFullyQualifiedName() + " of type " + field.getClass().getName() + " cannot be set with value of type " + value.getClass().getName());
                }
            }

            if (field instanceof PDVariableText) {
                //for some reason flattened pdfs have invisible text unless you explicitly set the text and background color
                //then the document must be flattened with refreshAppearances=true in order for these changes to apply
                ((PDVariableText) field).setDefaultAppearance(DEFAULT_APPEARANCE);
                if (field.getWidgets() != null) {
                    field.getWidgets().forEach(w -> w.getAppearanceCharacteristics().setBackground(new PDColor(new float[]{255,255,255}, PDDeviceRGB.INSTANCE)));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String booleanToStr(boolean value) {
        return value ? "Yes" : "Off";
    }

    /**
     * Flattens a PDF document effectively making it read only and non-interactive.  Not that the passed in Pdf document
     * must be closed and saved after flattening.
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @throws IllegalArgumentException if document is null.
     */
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

    /**
     * Sets the value of all fields on a PDF document to the name of the field filtering by predicate.  This currently
     * does not work for Checkboxes and Radio buttons.
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @param predicate a predicate for filtering.
     * @throws IllegalArgumentException if document is null or the predicate is null.
     */
    public static void markFields(PDDocument pdfDocument, Predicate<? super PDField> predicate) {
        if (pdfDocument == null) {
            throw new IllegalArgumentException("pdfDocument is null");
        }

        if (predicate == null) {
            throw new IllegalArgumentException("predicate is null");
        }

        final PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        final PDAcroForm acroForm = docCatalog.getAcroForm();
        final List<PDField> fields = acroForm.getFields();
        fields.forEach(field -> processMarkField(field, field.getPartialName(), predicate));
    }

    /**
     * Sets the value of all fields on a PDF document to the name of the field.  This currently
     * does not work for Checkboxes and Radio buttons.
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @throws IllegalArgumentException if document is null.
     */
    public static void markFields(PDDocument pdfDocument) {
        markFields(pdfDocument, f -> true);
    }

    private static void processMarkField(PDField field, String sParent, Predicate<? super PDField> predicate) {
        final String partialName = field.getPartialName();

        if (field instanceof PDNonTerminalField) {
            if (!sParent.equals(field.getPartialName())) {
                if (partialName != null) {
                    sParent = sParent + SEPARATOR + partialName;
                }
            }
            for (PDField child : ((PDNonTerminalField)field).getChildren()) {
                processMarkField(child, sParent, predicate);
            }
        } else {
            if (predicate.test(field) && !(field instanceof PDButton)) {
                final StringBuilder outputString = new StringBuilder(VAL_START);
                outputString.append(sParent);
                if (partialName != null) {
                    outputString.append(SEPARATOR).append(partialName);
                }
                outputString.append(VAL_END);

                if (field instanceof PDChoice) {
                    List<String> options = new ArrayList<>(((PDChoice) field).getOptions());
                    options.add(outputString.toString());
                }

                setField(field, outputString.toString());
            }
        }
    }

    /**
     * Logs information about all fields on a PDF document filtering by predicate.
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @param predicate a predicate for filtering.
     * @throws IllegalArgumentException if document is null or the predicate is null.
     */
    public static void logFields(PDDocument pdfDocument, Predicate<? super PDField> predicate) {
        if (pdfDocument == null) {
            throw new IllegalArgumentException("pdfDocument is null");
        }

        if (!LOG.isInfoEnabled()) {
            return;
        }

        final PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        final PDAcroForm acroForm = docCatalog.getAcroForm();
        final List<PDField> fields = acroForm.getFields();
        LOG.info(fields.size() + NO_FORM_FIELDS_MSG);
        fields.forEach(field -> processLogField(field, TOP_LEVEL, field.getPartialName(), predicate));
    }

    /**
     * Logs information about all fields on a PDF document.
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @throws IllegalArgumentException if document is null or the predicate is null.
     */
    public static void logFields(PDDocument pdfDocument) {
        logFields(pdfDocument, x -> true);
    }

    private static void processLogField(PDField field, String sLevel, String sParent, Predicate<? super PDField> predicate) {
        final String partialName = field.getPartialName();

        if (field instanceof PDNonTerminalField) {
            if (!sParent.equals(field.getPartialName())) {
                if (partialName != null) {
                    sParent = sParent + SEPARATOR + partialName;
                }
            }
            LOG.info(sLevel + sParent);
            for (PDField child : ((PDNonTerminalField)field).getChildren()) {
                processLogField(child, CHILD_LEVEL + sLevel, sParent, predicate);
            }
        } else {
            if (predicate.test(field)) {
                final String fieldValue = field.getValueAsString();
                final StringBuilder outputString = new StringBuilder(sLevel);
                outputString.append(sParent);
                if (partialName != null) {
                    outputString.append(SEPARATOR).append(partialName);
                }
                outputString.append(FIELD_VAL_SEPARATOR).append(fieldValue).append(COMMA_SEPARATOR);
                outputString.append(TYPE_STR).append(field.getClass().getName());
                LOG.info(outputString);
            }
        }
    }
}
