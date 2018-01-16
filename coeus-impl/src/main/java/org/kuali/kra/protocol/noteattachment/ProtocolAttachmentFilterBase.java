/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.noteattachment;

import java.io.Serializable;
import java.util.Comparator;

/**
 * 
 * This class is a business object which represents the 
 * ProtocolBase Attachment Filter.  This filter is used to limit
 * and sort protocol attachments.
 */
public abstract class ProtocolAttachmentFilterBase implements Serializable {

    private static final long serialVersionUID = 53138457226971783L;
    
    protected String filterBy;
    protected String sortBy;
    
    public String getFilterBy() {
        return filterBy;
    }
    public void setFilterBy(String filterBy) {
        this.filterBy = filterBy;
    }
    public String getSortBy() {
        return sortBy;
    }
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
    
    /**
     * 
     * This method returns a comparator used to sort protocol attachments
     * @return a comparator used to sort protocol attachments
     */
    public Comparator<ProtocolAttachmentProtocolBase> getProtocolAttachmentComparator() {
        return new ProtocolAttachmentComparatorFactory().getProtocolAttachmentComparator(getSortBy());
    }
    
    


class ProtocolAttachmentComparatorFactory {
    public Comparator<ProtocolAttachmentProtocolBase> getProtocolAttachmentComparator(String sortBy) {
        if ("DESC".equalsIgnoreCase(sortBy)) {
            return new ProtocolAttachmentDescriptionComparator();
        } else if ("ATTP".equalsIgnoreCase(sortBy)) {
            return new ProtocolAttachmentAttachmentTypeComparator();
        } else if ("LAUP".equalsIgnoreCase(sortBy)) {
            return new ProtocolAttachmentLastUpdatedComparator();
        } else if ("UPBY".equalsIgnoreCase(sortBy)) {
            return new ProtocolAttachmentLastUpdatedByComparator();
        } else {
            return null;
        }
    }
}

    private class ProtocolAttachmentDescriptionComparator implements Comparator<ProtocolAttachmentProtocolBase>
    {
    
        @Override
        public int compare(ProtocolAttachmentProtocolBase arg0, ProtocolAttachmentProtocolBase arg1) {
            return arg0.getDescription().compareTo(arg1.getDescription());
        }
        
    }
    
    private class ProtocolAttachmentAttachmentTypeComparator implements Comparator<ProtocolAttachmentProtocolBase>
    {
    
        @Override
        public int compare(ProtocolAttachmentProtocolBase o1, ProtocolAttachmentProtocolBase o2) {
            return o1.getType().getDescription().compareTo(o2.getType().getDescription());
        }
        
    }
    
    private class ProtocolAttachmentLastUpdatedComparator implements Comparator<ProtocolAttachmentProtocolBase>
    {
    
        @Override
        public int compare(ProtocolAttachmentProtocolBase o1, ProtocolAttachmentProtocolBase o2) {
            return o1.getUpdateTimestamp().compareTo(o2.getUpdateTimestamp());
        }
        
    }
    
    private class ProtocolAttachmentLastUpdatedByComparator implements Comparator<ProtocolAttachmentProtocolBase>
    {
    
        @Override
        public int compare(ProtocolAttachmentProtocolBase o1, ProtocolAttachmentProtocolBase o2) {
            return o1.getUpdateUserFullName().compareTo(o2.getUpdateUserFullName());
        }
        
    }

}
