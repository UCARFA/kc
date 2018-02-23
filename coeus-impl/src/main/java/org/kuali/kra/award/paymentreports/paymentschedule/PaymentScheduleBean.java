/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.paymentschedule;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.AwardForm;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.paymentreports.awardreports.AwardReportTerm;
import org.kuali.kra.award.service.AwardScheduleGenerationService;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.KualiRuleService;
import org.kuali.rice.krad.util.ObjectUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.util.*;

/**
 * This class supports the AwardForm class
 */
public class PaymentScheduleBean implements Serializable {    
    

    private static final long serialVersionUID = -5513993757805685581L;
    private AwardPaymentSchedule newAwardPaymentSchedule;
    private transient KualiRuleService ruleService;
    private AwardForm form;
    
    /**
     * Constructs a PaymentScheduleBean
     * @param parent
     */
    public PaymentScheduleBean(AwardForm form) {
        this.form = form;
        init();
    }
    
    /**
     * This method is called when adding a new payment schedule item
     * @param formHelper
     * @return
     */
    public boolean addPaymentScheduleItem() {
        AddAwardPaymentScheduleRuleEvent event = generateAddEvent();
        boolean success = getRuleService().applyRules(event);
        if(success){
            getAward().add(getNewAwardPaymentSchedule());
            init();
        }
        return success;
    }

    /**
     * This method delets a selected payment schedule item
     * @param formHelper
     * @param deletedItemIndex
     */
    public void deletePaymentScheduleItem(int deletedItemIndex) {
        List<AwardPaymentSchedule> items = getAward().getPaymentScheduleItems();
        if(deletedItemIndex >= 0 && deletedItemIndex < items.size()) {
            items.remove(deletedItemIndex);
        }        
    }
    
    /**
     * This method generates the payment schedules by calling the <code>AwardScheduleGenerationService</code>
     *
     * @throws ParseException
     * @throws WorkflowException 
     */
    public void generatePaymentSchedules() throws ParseException{
        Map<AwardReportTerm, List<Date>> dateMap = new HashMap<>();
        for (AwardReportTerm art : getAward().getAwardReportTermItems()) {
            List<Date> dates = getAwardScheduleGenerationService().generateSchedules(getAward(), Collections.singletonList(art), false);
            if (dateMap.containsKey(art)) {
                List<Date> currentDates = dateMap.get(art);
                currentDates.addAll(dates);
                dateMap.put(art, currentDates);
            } else {
                dateMap.put(art, dates);
            }
        }

        dateMap.forEach((art, dates) -> dates.forEach(date -> {
            newAwardPaymentSchedule = new AwardPaymentSchedule();
            newAwardPaymentSchedule.setDueDate(new java.sql.Date(date.getTime()));
            newAwardPaymentSchedule.setAmount(ScaleTwoDecimal.ZERO);
            newAwardPaymentSchedule.setAwardReportTermDescription(getSummary(art));
            newAwardPaymentSchedule.setAwardReportTerm(art);
            getAward().add(newAwardPaymentSchedule);
        }));

        init();
    }

    public String getSummary(AwardReportTerm art) {
        art.refreshReferenceObject("frequency");
        art.refreshReferenceObject("report");
        art.refreshReferenceObject("distribution");
        art.refreshReferenceObject("frequencyBase");
        
        String description = "";
        description += art.getReport() != null && StringUtils.isNotEmpty(art.getReport().getDescription()) ?  art.getReport().getDescription() : "";
        description += art.getFrequency() != null && StringUtils.isNotEmpty(art.getFrequency().getDescription()) ?  "-" + art.getFrequency().getDescription() : "";
        description += art.getFrequencyBase() != null && StringUtils.isNotEmpty(art.getFrequencyBase().getDescription()) ?  "-" + art.getFrequencyBase().getDescription() : "";
        description += art.getDistribution() != null && StringUtils.isNotEmpty(art.getDistribution().getDescription()) ?  "-" + art.getDistribution().getDescription() : "";
        description += ObjectUtils.isNotNull(art.getDueDate()) ?  "-" + art.getDueDate() : "";

        return description;
    }
    

    public Award getAward() {
        return form.getAwardDocument().getAward();
    }


    public AwardDocument getAwardDocument() {
        return form.getAwardDocument();
    }
    

    public Object getData() {
        return getNewAwardPaymentSchedule();
    }
    
    /**
     * Initialize subform
     */
    public void init() {
        newAwardPaymentSchedule = new AwardPaymentSchedule(); 
    }
    
    /**
     * 
     * This is a helper method for the retrieval of KualiRuleService
     * @return
     */
    protected KualiRuleService getRuleService() {
        if(ruleService == null) {
            ruleService = (KualiRuleService) KcServiceLocator.getService(KualiRuleService.class);
        }
        return ruleService;
    }
    
    /**
     * 
     * @param ruleService
     */
    protected void setRuleService(KualiRuleService ruleService) {
        this.ruleService = ruleService;
    }
    

    AddAwardPaymentScheduleRuleEvent generateAddEvent() {        
        AddAwardPaymentScheduleRuleEvent event = new AddAwardPaymentScheduleRuleEvent(
                                                            "paymentScheduleBean.newAwardPaymentSchedule",
                                                            getAwardDocument(),
                                                            getAward(),
                                                            getNewAwardPaymentSchedule());
        return event;
    }

    /**
     * Gets the newAwardPaymentSchedule attribute. 
     * @return Returns the newAwardPaymentSchedule.
     */
    public AwardPaymentSchedule getNewAwardPaymentSchedule() {
        return newAwardPaymentSchedule;
    }

    /**
     * Sets the newAwardPaymentSchedule attribute value.
     * @param newAwardPaymentSchedule The newAwardPaymentSchedule to set.
     */
    public void setNewAwardPaymentSchedule(AwardPaymentSchedule newAwardPaymentSchedule) {
        this.newAwardPaymentSchedule = newAwardPaymentSchedule;
    }
    
    /**
     * 
     * This is a helper method to retrieve the AwardScheduleGenerationService.
     * @return
     */
    protected AwardScheduleGenerationService getAwardScheduleGenerationService(){
        return KcServiceLocator.getService(AwardScheduleGenerationService.class);
    }

}
