package com.techelevator.npgeek.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
    private Long surveyid;
    private String parkCode;
    private String emailAddress;
    private String state;
    private String activityLevel;

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

    @NotBlank(message="Email address is required")
    @Email(message="Email must be a valid email address")
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
