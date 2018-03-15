package com.techelevator.npgeek.dao.jdbc;

import com.techelevator.npgeek.dao.ParkDao;
import com.techelevator.npgeek.dao.SurveyDao;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyResult;
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
    public List<SurveyResult> getAllSurveys() {
        List<SurveyResult> allSurveys = new ArrayList<>();

        String sqlSelectAllSurveys = "SELECT COUNT(*), park.parkName, park.parkCode FROM survey_result " +
                " JOIN park ON park.parkCode = survey_result.parkCode " +
        " GROUP BY park.parkCode" +
        " ORDER BY COUNT DESC, park.parkName ASC";


        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
        while(results.next()) {
            SurveyResult surveyResult = new SurveyResult();
            surveyResult.setParkCode(results.getString("parkCode"));
            surveyResult.setParkName(results.getString("parkName"));
            surveyResult.setCount(results.getInt("count"));
            allSurveys.add(surveyResult);
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
