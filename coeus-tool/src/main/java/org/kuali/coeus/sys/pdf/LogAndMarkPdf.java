/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.sys.pdf;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.kuali.coeus.sys.framework.util.PdfBoxUtils;

import java.io.File;

public class LogAndMarkPdf {

    public static void main(String[] args) throws Exception {

        if (args == null || args.length < 1 || StringUtils.isEmpty(args[0])) {
            System.err.println("Please provide a path to a valid pdf file.");
            return;
        }

        final File source = new File(args[0]);
        if(!source.exists() && !source.isFile()) {
            System.err.println("Please provide a path to a valid pdf file. Path: " + args[0]);
            return;
        }

        try(PDDocument pdfDocument = PDDocument.load(source)) {

            PdfBoxUtils.logFields(pdfDocument);
            PdfBoxUtils.markFields(pdfDocument);
            pdfDocument.save(source.getParent() + File.separator + source.getName() + "-MARKED.pdf");
        }
    }
}
