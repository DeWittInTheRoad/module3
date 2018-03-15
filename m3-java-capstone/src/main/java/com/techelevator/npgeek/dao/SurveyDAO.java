package com.techelevator.npgeek.dao;

import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyResult;

import java.util.List;

public interface SurveyDao {

    public List<SurveyResult> getAllSurveys();
    public void save(Survey survey);
}
