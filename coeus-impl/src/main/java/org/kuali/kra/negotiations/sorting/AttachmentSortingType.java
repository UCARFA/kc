/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.sorting;

import org.kuali.kra.negotiations.bo.NegotiationActivityAttachment;

import java.util.Comparator;

/**
 * Enum that lists the various ways of sorting the list of attachments and includes the appropriate
 * comparator for sorting the list.
 */
public enum AttachmentSortingType {
    START("Activity Start Date", new ActivityStartDateAttachmentComparator()),
    FILE("File", new FilenameAttachmentComparator()),
    DESC("Attachment Description", new DescriptionAttachmentComparator()),
    LOC("Location", new LocationAttachmentComparator()),
    TYPE("Activity Type", new ActivityTypeAttachmentComparator());
    
    private String desc;
    private Comparator<NegotiationActivityAttachment> comparator;
    
    private AttachmentSortingType(String desc, Comparator<NegotiationActivityAttachment> comparator) {
        this.desc = desc;
        this.comparator = comparator;
    }
    
    public String getDesc() {
        return desc;
    }
    public Comparator<NegotiationActivityAttachment> getComparator() {
        return comparator;
    }

}

class ActivityStartDateAttachmentComparator implements Comparator<NegotiationActivityAttachment> {
    @Override
    public int compare(NegotiationActivityAttachment o1, NegotiationActivityAttachment o2) {
        return o1.getActivity().getStartDate().compareTo(o2.getActivity().getStartDate());
    }
}
class FilenameAttachmentComparator implements Comparator<NegotiationActivityAttachment> {
    @Override
    public int compare(NegotiationActivityAttachment o1, NegotiationActivityAttachment o2) {
        return o1.getFile().getName().compareToIgnoreCase(o2.getFile().getName());
    }
}
class DescriptionAttachmentComparator implements Comparator<NegotiationActivityAttachment> {
    @Override
    public int compare(NegotiationActivityAttachment o1, NegotiationActivityAttachment o2) {
        return o1.getDescription().compareToIgnoreCase(o2.getDescription());
    }
}
class LocationAttachmentComparator implements Comparator<NegotiationActivityAttachment> {
    @Override
    public int compare(NegotiationActivityAttachment o1, NegotiationActivityAttachment o2) {
        return o1.getActivity().getLocation().getDescription().compareTo(o2.getActivity().getLocation().getDescription());
    }
}
class ActivityTypeAttachmentComparator implements Comparator<NegotiationActivityAttachment> {
    @Override
    public int compare(NegotiationActivityAttachment o1, NegotiationActivityAttachment o2) {
        return o1.getActivity().getActivityType().getDescription().compareTo(o2.getActivity().getActivityType().getDescription());
    }
}
