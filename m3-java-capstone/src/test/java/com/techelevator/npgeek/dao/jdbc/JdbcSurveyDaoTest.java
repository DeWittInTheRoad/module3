package com.techelevator.npgeek.dao.jdbc;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.npgeek.dao.ParkDao;
import com.techelevator.npgeek.dao.SurveyDao;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcSurveyDaoTest extends DAOIntegrationTest {

    private SurveyDao dao;
    private ParkDao parkDao;


    @Before
    public void setUp() throws Exception {
        dao = new JdbcSurveyDao(getDataSource());
        parkDao = new JdbcParkDao(getDataSource());
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());


        String sqlInsertParkTest1 = "INSERT INTO park VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sqlInsertParkTest1, "TEST", "Test Park Name", "Test State",
                400, 8000, 2.2, 5, "test climate", 1949, 1000, "inspirational quote test",
                "the one and only me", "awesome park description test", 5, 100);

    }


    @Test
    public void save() {


        Survey testSurvey = new Survey();

        testSurvey.setParkCode("TEST");
        testSurvey.setEmailAddress("test@test.com");
        testSurvey.setState("Ohio");
        testSurvey.setActivityLevel("inactive");

        dao.save(testSurvey);

        List<SurveyResult> testResultList = dao.getAllSurveys();

        Assert.assertEquals("TEST", testResultList.get(testResultList.size() - 1).getParkCode());
    }
}

