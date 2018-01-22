/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.framework.person.signature;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
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
    private Set<PDFTextLocation> locations;

    public PrintTextLocator(PDDocument document, Set<String> searchStrings) throws IOException {
        super.setSortByPosition(true);
        this.document = document;
        this.searchStrings = searchStrings;
        this.output = NO_OP;
    }

    public Set<PDFTextLocation> doSearch() throws IOException {
        locations = new HashSet<>();
        processPages(document.getDocumentCatalog().getPages());
        return locations;
    }

    @Override
    protected void writeString(String text, List<TextPosition> textPositions) throws IOException {
        super.writeString(text);

        for (String searchString: searchStrings) {
            int start = text.indexOf(searchString);
            if (start != -1) {
                //textPositions will have an entry for every character in the String text.
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PDFTextLocation that = (PDFTextLocation) o;

            if (found != that.found) return false;
            if (page != that.page) return false;
            if (Float.compare(that.x, x) != 0) return false;
            if (Float.compare(that.y, y) != 0) return false;
            return text != null ? text.equals(that.text) : that.text == null;
        }

        @Override
        public int hashCode() {
            int result = (found ? 1 : 0);
            result = 31 * result + (text != null ? text.hashCode() : 0);
            result = 31 * result + page;
            result = 31 * result + (x != +0.0f ? Float.floatToIntBits(x) : 0);
            result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
            return result;
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