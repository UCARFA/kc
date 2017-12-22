package edu.ucar.fanda.kuali.kra.external.Cfda.service.impl;

import edu.ucar.fanda.kuali.util.UcarHttpUtil;
import org.kuali.kra.award.home.CFDA;
import org.kuali.kra.external.Cfda.CfdaUpdateResults;
import org.kuali.kra.external.Cfda.service.impl.CfdaServiceImpl;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.core.framework.persistence.jdbc.sql.SQLUtils;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

/*
Required Kuali Configuration Parameters:
    Create and enable HTTPPOST_CFDA_INFO Parameter in Kuali.
    Example:
        Namespace: KC-AWARD
        Component: All
        Application ID: KC
        Parameter Name: HTTPPOST_CFDA_INFO
        Parameter Value: true
        Parameter Description: Enable sending of new award information to message queue
        Parameter Type Code: Config
        Parameter Constraint Code: Allowed

    Create ACTIVEMQ_KEYPARTS_URL Parameter in Kuali.
        Example:
        Namespace: KC-GEN
        Component: All
        Application ID: KC
        Parameter Name: ACTIVEMQ_KEYPARTS_URL
        Paramter Value: http://localhost:8161/api/message?destination=KUALIIFASKEYPARTS&type=queue
        Parameter Description: ActiveMQ IFAS Key Parts URL
        Parameter Type Code: Config
        Parameter Constraint Code: Allowed
 */

public class UcarCfdaServiceImpl extends CfdaServiceImpl{

    private BusinessObjectService businessObjectService;

    /**
     * This method updates the CFDA table with the values received from the
     * gov site.
     * @see org.kuali.kra.external.Cfda.CfdaService#updateCfda()
     */
    @Override
    public CfdaUpdateResults updateCfda() {
        CfdaUpdateResults updateResults = new CfdaUpdateResults();
        StringBuilder message = new StringBuilder();
        Map<String, CFDA> govCfdaMap;

        try {
            govCfdaMap = retrieveGovCodes();
        } catch (IOException ioe) {
            message.append("Problem encountered while retrieving cfda numbers, "
                    + "the database was not updated." + ioe.getMessage());
            updateResults.setMessage(message.toString());
            return updateResults;
        }

        SortedMap<String, CFDA> kcMap = getCfdaValuesInDatabase();
        updateResults.setNumberOfRecordsInKcDatabase(kcMap.size());
        updateResults.setNumberOfRecordsRetrievedFromWebSite(govCfdaMap.size());

        for (String key : kcMap.keySet()) {
            CFDA kcCfda = kcMap.get(key);
            CFDA govCfda = govCfdaMap.get(key);


            if (kcCfda.getCfdaMaintenanceTypeId().equalsIgnoreCase(Constants.CFDA_MAINT_TYP_ID_MANUAL)) {
                // Leave it alone. It's maintained manually.
                updateResults.setNumberOfRecordsNotUpdatedBecauseManual(1 + updateResults.getNumberOfRecordsNotUpdatedBecauseManual());
            }
            else if (kcCfda.getCfdaMaintenanceTypeId().equalsIgnoreCase(Constants.CFDA_MAINT_TYP_ID_AUTOMATIC)) {

                if (govCfda == null) {
                    if (kcCfda.getActive()) {
                        kcCfda.setActive(false);
                        businessObjectService.save(kcCfda);
                        updateResults.setNumberOfRecordsDeactivatedBecauseNoLongerOnWebSite(updateResults.getNumberOfRecordsDeactivatedBecauseNoLongerOnWebSite() + 1);
                    }
                    else {
                        // Leave it alone for historical purposes
                        updateResults.setNumberOfRecordsNotUpdatedForHistoricalPurposes(updateResults.getNumberOfRecordsNotUpdatedForHistoricalPurposes() + 1);
                    }
                }
                else {
                    if (kcCfda.getActive()) {
                       /*if (!kcCfda.getCfdaProgramTitleName().equalsIgnoreCase(govCfda.getCfdaProgramTitleName())) {
                            message.append("The program title for CFDA " + kcCfda.getCfdaNumber() + " changed from "
                                            + kcCfda.getCfdaProgramTitleName() + " to " + govCfda.getCfdaProgramTitleName() + ".<BR>");
                        }*/
                        updateResults.setNumberOfRecordsUpdatedBecauseAutomatic(updateResults.getNumberOfRecordsUpdatedBecauseAutomatic() + 1);
                    }
                    else {
                        kcCfda.setActive(true);
                        updateResults.setNumberOfRecordsReActivated(updateResults.getNumberOfRecordsReActivated() + 1);
                    }

                    kcCfda.setCfdaProgramTitleName(govCfda.getCfdaProgramTitleName());
                    businessObjectService.save(kcCfda);
                }
            }

            // Remove it from the govMap so the remaining codes are new
            govCfdaMap.remove(key);
        }
        // New CFDA number from govt, added to the db
        updateResults.setMessage(message.toString());
        addNew(govCfdaMap);
        updateResults.setNumberOfRecordsNewlyAddedFromWebSite(govCfdaMap.size() + 1);
        return updateResults;
    }

    /**
     * This method adds new cfda numbers to the cfda table
     * @param newCfdas
     */
    @Override
    protected void addNew(Map<String, CFDA> newCfdas) {
        for (String cfdaKey : newCfdas.keySet()) {
            CFDA cfda = newCfdas.get(cfdaKey);

            String cfdaProgramTitleName = trimProgramTitleName(cfda.getCfdaProgramTitleName());
            // all new cfda numbers are set to automatic and active
            cfda.setCfdaProgramTitleName(SQLUtils.cleanString(cfdaProgramTitleName));
            cfda.setActive(true);
            cfda.setCfdaMaintenanceTypeId(Constants.CFDA_MAINT_TYP_ID_AUTOMATIC);
            getBusinessObjectService().save(cfda);
            Boolean httpPostCFDAInfo = getParameterService().getParameterValueAsBoolean("KC-AWARD", "All", "HTTPPOST_CFDA_INFO");
            if (httpPostCFDAInfo != null && httpPostCFDAInfo) {
                sendToMessageQueue(cfda);
            }
        }
    }

    @Override
    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }
    /**
     * Sets the businessObjectService. Injected by spring.
     * @return
     */
    @Override
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    /**
     * Prepare Json String and send to UcarHttpUtil HTTP Post
     * @param cfda
     */
    public void sendToMessageQueue(CFDA cfda) {
        UcarHttpUtil httpUtil = new UcarHttpUtil();
        HashMap<String, String> payload = new HashMap<String, String>();
        payload.put("keyPartType", "cfda");
        payload.put("keyPartCode", cfda.getCfdaNumber());
        payload.put("keyPartDesc", cfda.getCfdaProgramTitleName());
        httpUtil.httpPost(payload, "ACTIVEMQ_KEYPARTS_URL");
    }
}
