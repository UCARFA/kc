package org.kuali.coeus.common.framework.person.signature;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

public class PrintTextLocator extends PDFTextStripper {

    private static final Writer NO_OP = new Writer() {
        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
        }

        @Override
        public void flush() throws IOException {
        }

        @Override
        public void close() throws IOException {
        }
    };

    private final Set<String> searchStrings;
    private List<PDFTextLocation> locations;

    public PrintTextLocator(PDDocument document, Set<String> searchStrings) throws IOException {
        super.setSortByPosition(true);
        this.document = document;
        this.searchStrings = searchStrings;
        this.output = NO_OP;
    }

    public List<PDFTextLocation> doSearch() throws IOException {
        locations = new ArrayList<>();
        processPages(document.getDocumentCatalog().getPages());
        return locations;
    }

    @Override
    protected void writeString(String text, List<TextPosition> textPositions) throws IOException {
        super.writeString(text);

        for (String searchString: searchStrings) {
            int start = text.indexOf(searchString);
            if (start!=-1) {
                final TextPosition pos = textPositions.get(start);
                final PDFTextLocation textLoc = new PDFTextLocation();
                textLoc.setText(text);
                textLoc.setFound(true);
                textLoc.setPage(getCurrentPageNo());
                textLoc.setX(pos.getX());
                textLoc.setY(pos.getY());
                locations.add(textLoc);
            }
        }

    }

    public static final class PDFTextLocation {
        private boolean found;
        private String text;
        private int page;
        private float x;
        private float y;

        public boolean isFound() {
            return found;
        }

        public void setFound(boolean found) {
            this.found = found;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "PDFTextLocation{" +
                    "found=" + found +
                    ", text='" + text + '\'' +
                    ", page=" + page +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}