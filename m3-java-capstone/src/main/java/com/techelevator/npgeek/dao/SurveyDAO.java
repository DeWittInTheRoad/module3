package com.techelevator.npgeek.dao;

import com.techelevator.npgeek.model.Survey;

import java.util.List;

public interface SurveyDAO {

    public List<Survey> getAllSurveys();
    public void save(Survey survey);
}
