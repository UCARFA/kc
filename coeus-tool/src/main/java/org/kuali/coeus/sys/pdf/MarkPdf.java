package org.kuali.coeus.sys.pdf;

import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.kuali.coeus.sys.framework.util.PdfBoxUtils;

import java.io.File;

public class MarkPdf {

    public static void main(String[] args) throws Exception {

        if (args == null || args.length < 1 || StringUtils.isEmpty(args[0])) {
            System.err.println("Please provide a path to a valid pdf file.");
            return;
        }

        final File source = new File(args[0]);
        try(PDDocument pdfDocument = PDDocument.load(source)) {
            PdfBoxUtils.markFields(pdfDocument);
            pdfDocument.save(source.getParent() + File.separator + source.getName() + "-MARKED.pdf");
        }
    }
}
