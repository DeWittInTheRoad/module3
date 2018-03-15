package com.techelevator.npgeek.dao.jdbc;

import com.techelevator.npgeek.dao.SurveyDao;
import com.techelevator.npgeek.model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSurveyDao implements SurveyDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcSurveyDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Survey> getAllSurveys() {
        List<Survey> allSurveys = new ArrayList<>();
//        String sqlSelectAllSurveys = "SELECT * FROM survey_result";
        String sqlSelectAllSurveys = "SELECT COUNT(*), park.parkName FROM survey_result " +
                " JOIN park ON park.parkCode = survey_result.parkCode " +
        " GROUP BY park.parkName " +
        " ORDER BY COUNT DESC";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
        while(results.next()) {
            Survey survey = new Survey();
            survey.setSurveyid(results.getLong("surveyId"));
            survey.setParkCode(results.getString("parkCode"));
            survey.setEmailAddress(results.getString("emailAddress"));
            survey.setState(results.getString("state"));
            survey.setActivityLevel(results.getString("activityLevel"));
            allSurveys.add(survey);
        }
        return allSurveys;
    }

    @Override
    public void save(Survey survey) {
        Long surveyid = getNextSurveyId();
        String sqlInsertPost = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sqlInsertPost, surveyid, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
        survey.setSurveyid(surveyid);
    }

    private Long getNextSurveyId() {
        String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyid')";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
        Long surveyid = null;
        if(results.next()) {
            surveyid = results.getLong(1);
        } else {
            throw new RuntimeException("Something strange happened, unable to select next survey id from sequence");
        }
        return surveyid;
    }

}
