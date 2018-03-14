package com.techelevator.npgeek.model;

public class Survey {
    private Long surveyid;
    String parkCode;
    String emailAddress;
    String state;
    String activityLevel;

    public Long getSurveyid() {
        return surveyid;
    }

    public void setSurveyid(Long surveyid) {
        this.surveyid = surveyid;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }
}
