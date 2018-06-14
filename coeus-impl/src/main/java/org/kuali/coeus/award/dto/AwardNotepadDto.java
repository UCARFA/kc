package org.kuali.coeus.award.dto;

import java.sql.Timestamp;

public class AwardNotepadDto {

    private static final long serialVersionUID = 1L;

    private Long awardNotepadId;
    private String awardNumber;
    private Long awardId;
    private Integer entryNumber;
    private String comments;
    private String noteTopic;
    private boolean restrictedView;
    private String createUser;

    public Long getAwardNotepadId() {
        return awardNotepadId;
    }

    public void setAwardNotepadId(Long awardNotepadId) {
        this.awardNotepadId = awardNotepadId;
    }

    public Long getAwardId() {
        return awardId;
    }

    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }

    public Integer getEntryNumber() {
        return entryNumber;
    }

    public void setEntryNumber(Long entryNumber) {
        this.awardId = entryNumber;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getNoteTopic() {
        return noteTopic;
    }

    public void setNoteTopic(String noteTopic) {
        this.noteTopic = noteTopic;
    }

    public Boolean getRestrictedView() {
        return restrictedView;
    }

    public void setRestrictedView(Boolean restrictedView) {
        this.restrictedView = restrictedView;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) { this.createUser = createUser; }
}
