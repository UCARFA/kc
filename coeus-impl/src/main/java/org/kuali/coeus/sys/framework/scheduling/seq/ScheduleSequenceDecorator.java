/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.scheduling.seq;


/**
 * This class implements decorator pattern for SheduleSequence.
 */
public abstract class ScheduleSequenceDecorator  implements ScheduleSequence {
    
    protected ScheduleSequence scheduleSequence; 
    
    public ScheduleSequenceDecorator(ScheduleSequence scheduleSequence) {
        this.scheduleSequence = scheduleSequence;
    }

}
