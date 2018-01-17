/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.util;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.form.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public final class PdfBoxUtils {

    private static final Log LOG = LogFactory.getLog(PdfBoxUtils.class);
    private static final String SEPARATOR = ".";
    private static final String TOP_LEVEL = "|--";
    private static final String CHILD_LEVEL = "|  ";
    private static final String FIELD_VAL_SEPARATOR = " = ";
    private static final String TYPE_STR = "type=";
    private static final String NO_FORM_FIELDS_MSG = " top-level fields were found on the form";
    private static final String COMMA_SEPARATOR = ",  ";
    private static final String VAL_START = "<";
    private static final String VAL_END = ">";
    private static final COSName ARIAL_MT = COSName.getPDFName("ArialMT");
    private static final COSName HELVETICA = COSName.getPDFName("Helvetica");

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
     * @param value the value to set the field to.  If null does nothing.  Cannot contain null values.
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
     * @param value the value to set the field to.  If null does nothing.
     * @throws IllegalArgumentException if document is null or name is blank or value is null.
     */
    public static void setField(PDDocument pdfDocument, String name, String value) {
        setF(pdfDocument, name, value);
    }

    /**
     * Sets a form field value on a PDF Document.  If a field is not found nothing happens.  The value if not null is
     * set as a string in a type aware way.
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @param name the field name. Cannot be blank.
     * @param value the value to set the field to.  If null does nothing.
     * @throws IllegalArgumentException if document is null or name is blank or value is null.
     */
    public static void setFieldAsStr(PDDocument pdfDocument, String name, Object value) {
        if (value instanceof BigDecimal) {
            setF(pdfDocument, name, ((BigDecimal) value).toPlainString());
        } else if (value != null) {
            setF(pdfDocument, name, value.toString());
        }
    }

    //purposely named different to avoid overloading with an Object type
    private static void setF(PDDocument pdfDocument, String name, Object value) {

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
            if (value != null) {
                setField(field, value);
            }
        } else {
            LOG.error("No field found with name:" + name);
        }
    }

    private static void setField(PDField field, Object value) {

        if (field == null) {
            throw new IllegalArgumentException("field is null");
        }

        if (value == null) {
            return;
        }

        try {
            if (field instanceof PDTextField || field instanceof PDListBox || field instanceof PDRadioButton || field instanceof PDCheckBox) {
                if (value instanceof Boolean) {
                    field.setValue(booleanToStr((Boolean) value));
                } else if (value instanceof String) {
                    field.setValue((String) value);
                }
            } else if (field instanceof PDComboBox) {
                if (value instanceof Boolean) {
                    field.setValue(convertToDisplayValue((PDComboBox) field, booleanToStr((Boolean) value)));
                } else if (value instanceof String) {
                    field.setValue(convertToDisplayValue((PDComboBox) field, (String) value));
                } else if (value instanceof List) {
                    final List<String> converted = ((List<Object>) value).stream().map(v -> {
                        if (v instanceof String) {
                            return (String) v;
                        } else if (v instanceof Boolean) {
                            return booleanToStr((Boolean) v);
                        } else {
                            throw new IllegalArgumentException("Invalid value type in List " + (v != null ? v.getClass().getName() : "(null)"));
                        }
                    }).map(v -> convertToDisplayValue((PDComboBox) field, v))
                            .collect(Collectors.toList());

                    ((PDChoice) field).setValue(converted);
                } else {
                    throw new IllegalArgumentException(field.getFullyQualifiedName() + " of type " + field.getClass().getName() + " cannot be set with value of type " + value.getClass().getName());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String convertToDisplayValue(PDChoice field, String value) {
        if (org.apache.commons.collections4.CollectionUtils.isNotEmpty(field.getOptionsDisplayValues()) && org.apache.commons.collections4.CollectionUtils.isNotEmpty(field.getOptionsExportValues())) {
            final int index = field.getOptionsExportValues().indexOf(value);
            if (index != -1) {
                return field.getOptionsDisplayValues().get(index);
            }
        }

        return value;
    }

    /**
     * for some reason flattened pdfs have a font of ArialMT and Helvetica which is not available in the default resources.
     */
    private static void doMissingDefaultResourcesWorkaround(PDResources resources) {
        resources.put(ARIAL_MT, PDType1Font.HELVETICA);
        resources.put(HELVETICA, PDType1Font.HELVETICA);
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

        if (pdfDocument.getDocumentCatalog().getAcroForm().getDefaultResources() != null) {
            doMissingDefaultResourcesWorkaround(pdfDocument.getDocumentCatalog().getAcroForm().getDefaultResources());
        }

        try {
            pdfDocument.getDocumentCatalog().getAcroForm().flatten(pdfDocument.getDocumentCatalog().getAcroForm().getFields(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Removes usage rights
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @throws IllegalArgumentException if document is null.
     */
    public static void removeUsageRights(PDDocument pdfDocument) {

        if (pdfDocument == null) {
            throw new IllegalArgumentException("pdfDocument is null");
        }

        final COSDictionary dictionary = pdfDocument.getDocumentCatalog().getCOSObject();
        dictionary.removeItem(COSName.PERMS);
        dictionary.setNeedToBeUpdated(true);
    }

    /**
     * Removes Xfa Form
     * @param pdfDocument the Pdf Document.  Cannot be null.
     * @throws IllegalArgumentException if document is null.
     */
    public static void removeXfaForm(PDDocument pdfDocument) {

        if (pdfDocument == null) {
            throw new IllegalArgumentException("pdfDocument is null");
        }

        final COSDictionary dictionary = pdfDocument.getDocumentCatalog().getCOSObject();
        final COSDictionary formDictionary = (COSDictionary) dictionary.getDictionaryObject(COSName.ACRO_FORM);
        formDictionary.removeItem(COSName.XFA);
        formDictionary.setNeedToBeUpdated(true);
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

                if (partialName != null) {
                    outputString.append(partialName);
                } else {
                    outputString.append(sParent);
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
