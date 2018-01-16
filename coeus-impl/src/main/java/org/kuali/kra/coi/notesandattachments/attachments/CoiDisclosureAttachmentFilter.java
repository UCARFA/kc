/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.notesandattachments.attachments;

import java.io.Serializable;
import java.util.Comparator;

public class CoiDisclosureAttachmentFilter implements Serializable {


    private static final long serialVersionUID = -4725272230342475909L;
    private String filterBy;
    private String sortBy;
    
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getFilterBy() {
        return filterBy;
    }

    public String getSortBy() {
        return sortBy;
    }

    public Comparator<? super CoiDisclosureAttachment> getCoiDisclosureAttachmentComparator() {
        return new CoiDisclosureAttachmentComparatorFactory().getCoiDisclosureAttachmentComparator(getSortBy());
    }

    class CoiDisclosureAttachmentComparatorFactory {
        public Comparator<CoiDisclosureAttachment> getCoiDisclosureAttachmentComparator(String sortByCriteria) {
            if ("DESC".equalsIgnoreCase(sortByCriteria)) {
                return new CoiDisclosureAttachmentDescriptionComparator();
            } else if ("LAUP".equalsIgnoreCase(sortByCriteria)) {
                return new CoiDisclosureAttachmentLastUpdatedComparator();
            } else if ("UPBY".equalsIgnoreCase(sortByCriteria)) {
                return new CoiDisclosureAttachmentLastUpdatedByComparator();
            } else {
                return null;
            }
        }
    }

    private class CoiDisclosureAttachmentDescriptionComparator implements Comparator<CoiDisclosureAttachment> {
        @Override
        public int compare(CoiDisclosureAttachment arg0, CoiDisclosureAttachment arg1) {
            return arg0.getDescription().compareTo(arg1.getDescription());
        }
    }
    
    private class CoiDisclosureAttachmentLastUpdatedComparator implements Comparator<CoiDisclosureAttachment> {
        @Override
        public int compare(CoiDisclosureAttachment o1, CoiDisclosureAttachment o2) {
            return o2.getUpdateTimestamp().compareTo(o1.getUpdateTimestamp());
        }
    }
    
    private class CoiDisclosureAttachmentLastUpdatedByComparator implements Comparator<CoiDisclosureAttachment> {
        @Override
        public int compare(CoiDisclosureAttachment o1, CoiDisclosureAttachment o2) {
            return o1.getUpdateUser().compareTo(o2.getUpdateUser());
        }
    }
}
