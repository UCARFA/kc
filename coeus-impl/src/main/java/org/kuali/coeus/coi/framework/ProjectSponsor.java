/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.coi.framework;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Map;

public class ProjectSponsor implements Serializable, ProjectMetadata {

    @Size(min = 1, max = 20)
    @NotNull
    private String sourceSystem;

    @Size(min = 1, max = 50)
    @NotNull
    private String sourceIdentifier;

    @Size(min = 1, max = 6)
    private String sponsorCode;

    @Size(min = 1, max = 200)
    private String sponsorName;

    private Map<String, String> metadata;

    public ProjectSponsor() {
        super();
    }

    public ProjectSponsor(String sourceSystem, String sourceIdentifier, String sponsorCode, String sponsorName, Map<String, String> metadata) {
        this.sourceSystem = sourceSystem;
        this.sourceIdentifier = sourceIdentifier;
        this.sponsorCode = sponsorCode;
        this.sponsorName = sponsorName;
        this.metadata = metadata;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getSourceIdentifier() {
        return sourceIdentifier;
    }

    public void setSourceIdentifier(String sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier;
    }

    public String getSponsorCode() {
        return sponsorCode;
    }

    public void setSponsorCode(String sponsorCode) {
        this.sponsorCode = sponsorCode;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    @Override
    public Map<String, String> getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "ProjectSponsor{" +
                "sourceSystem='" + sourceSystem + '\'' +
                ", sourceIdentifier='" + sourceIdentifier + '\'' +
                ", sponsorCode='" + sponsorCode + '\'' +
                ", sponsorName='" + sponsorName + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
