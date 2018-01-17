/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.awardreports.reporting.service;

import java.util.ArrayList;
import java.util.List;

public class ReportTrackingNotification {

    private String name;
    private String actionCode;
    private boolean overdue;
    private Integer days;
    private Integer scope;
    
    private List<ReportTrackingNotificationTask> tasks;
    
    public ReportTrackingNotification() {
        tasks = new ArrayList<>();
        scope = new Integer(30);
    }
    
    
    public ReportTrackingNotification(String name, String actionCode, boolean overdue, Integer days, Integer scope, String reportClassCode) {
        this();
        this.name = name;
        this.actionCode = actionCode;
        this.overdue = overdue;
        this.days = days;
        this.scope = scope;
        tasks.add(new ReportTrackingNotificationTask(reportClassCode));
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public List<ReportTrackingNotificationTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<ReportTrackingNotificationTask> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }
    
}
