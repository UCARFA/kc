/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.Cfda;

public class CfdaUpdateResults {
    
    private int numberOfRecordsRetrievedFromWebSite;
    private int numberOfRecordsInKcDatabase;
    private int numberOfRecordsNotUpdatedForHistoricalPurposes;
    private int numberOfRecordsDeactivatedBecauseNoLongerOnWebSite;
    private int numberOfRecordsReActivated;
    private int numberOfRecordsNotUpdatedBecauseManual;
    private int numberOfRecordsUpdatedBecauseAutomatic;
    private int numberOfRecordsNewlyAddedFromWebSite;
    private String message;
    
    public CfdaUpdateResults() {
        setNumberOfRecordsDeactivatedBecauseNoLongerOnWebSite(0);
        setNumberOfRecordsInKcDatabase(0);
        setNumberOfRecordsNewlyAddedFromWebSite(0);
        setNumberOfRecordsNotUpdatedBecauseManual(0);
        setNumberOfRecordsReActivated(0);
        setNumberOfRecordsRetrievedFromWebSite(0);
        setNumberOfRecordsUpdatedBecauseAutomatic(0);
        setNumberOfRecordsNotUpdatedForHistoricalPurposes(0);
    }
    
    public int getNumberOfRecordsRetrievedFromWebSite() {
        return numberOfRecordsRetrievedFromWebSite;
    }
    public void setNumberOfRecordsRetrievedFromWebSite(int numberOfRecordsRetrievedFromWebSite) {
        this.numberOfRecordsRetrievedFromWebSite = numberOfRecordsRetrievedFromWebSite;
    }
  
    public int getNumberOfRecordsInKcDatabase() {
        return numberOfRecordsInKcDatabase;
    }
    public void setNumberOfRecordsInKcDatabase(int numberOfRecordsInKcDatabase) {
        this.numberOfRecordsInKcDatabase = numberOfRecordsInKcDatabase;
    } 
    
    public int getNumberOfRecordsNotUpdatedForHistoricalPurposes() {
        return numberOfRecordsNotUpdatedForHistoricalPurposes;
    }
    public void setNumberOfRecordsNotUpdatedForHistoricalPurposes(int numberOfRecordsNotUpdatedForHistoricalPurposes) {
        this.numberOfRecordsNotUpdatedForHistoricalPurposes = numberOfRecordsNotUpdatedForHistoricalPurposes;
    }
  
    public int getNumberOfRecordsDeactivatedBecauseNoLongerOnWebSite() {
        return numberOfRecordsDeactivatedBecauseNoLongerOnWebSite;
    }
    public void setNumberOfRecordsDeactivatedBecauseNoLongerOnWebSite(int numberOfRecordsDeactivatedBecauseNoLongerOnWebSite) {
        this.numberOfRecordsDeactivatedBecauseNoLongerOnWebSite = numberOfRecordsDeactivatedBecauseNoLongerOnWebSite;
    }  
    
    public int getNumberOfRecordsReActivated() {
        return numberOfRecordsReActivated;
    }
    public void setNumberOfRecordsReActivated(int numberOfRecordsReActivated) {
        this.numberOfRecordsReActivated = numberOfRecordsReActivated;
    }
   
    public int getNumberOfRecordsNotUpdatedBecauseManual() {
        return numberOfRecordsNotUpdatedBecauseManual;
    }
    public void setNumberOfRecordsNotUpdatedBecauseManual(int numberOfRecordsNotUpdatedBecauseManual) {
        this.numberOfRecordsNotUpdatedBecauseManual = numberOfRecordsNotUpdatedBecauseManual;
    }
    
    public int getNumberOfRecordsUpdatedBecauseAutomatic() {
        return numberOfRecordsUpdatedBecauseAutomatic;
    }
    public void setNumberOfRecordsUpdatedBecauseAutomatic(int numberOfRecordsUpdatedBecauseAutomatic) {
        this.numberOfRecordsUpdatedBecauseAutomatic = numberOfRecordsUpdatedBecauseAutomatic;
    }
    
    public int getNumberOfRecordsNewlyAddedFromWebSite() {
        return numberOfRecordsNewlyAddedFromWebSite;
    }
    public void setNumberOfRecordsNewlyAddedFromWebSite(int numberOfRecordsNewlyAddedFromWebSite) {
        this.numberOfRecordsNewlyAddedFromWebSite = numberOfRecordsNewlyAddedFromWebSite;
    }
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CfdaUpdateResults{" +
                "numberOfRecordsRetrievedFromWebSite=" + numberOfRecordsRetrievedFromWebSite +
                ", numberOfRecordsInKcDatabase=" + numberOfRecordsInKcDatabase +
                ", numberOfRecordsNotUpdatedForHistoricalPurposes=" + numberOfRecordsNotUpdatedForHistoricalPurposes +
                ", numberOfRecordsDeactivatedBecauseNoLongerOnWebSite=" + numberOfRecordsDeactivatedBecauseNoLongerOnWebSite +
                ", numberOfRecordsReActivated=" + numberOfRecordsReActivated +
                ", numberOfRecordsNotUpdatedBecauseManual=" + numberOfRecordsNotUpdatedBecauseManual +
                ", numberOfRecordsUpdatedBecauseAutomatic=" + numberOfRecordsUpdatedBecauseAutomatic +
                ", numberOfRecordsNewlyAddedFromWebSite=" + numberOfRecordsNewlyAddedFromWebSite +
                ", message='" + message + '\'' +
                '}';
    }
}
