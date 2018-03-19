package com.techelevator.npgeek.dao.jdbc;

import com.techelevator.npgeek.dao.SurveyDao;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyResult;
import org.junit.*;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.util.List;

public class JdbcSurveyDaoTest {
    private static SingleConnectionDataSource dataSource;
    private SurveyDao dao;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);

    }

    @Before
    public void setUp() throws Exception {
        dao = new JdbcSurveyDao(dataSource);
    }

    @After
    public void tearDown() throws Exception {
        dataSource.getConnection().rollback();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        dataSource.destroy();
    }

    @Test
    public void getAllSurveys() {


    }

    @Test
    public void save() {


        Survey testSurvey = new Survey();
        testSurvey.setSurveyid(98L);
        testSurvey.setParkCode("TEST");
        testSurvey.setEmailAddress("test@test.com");
        testSurvey.setState("Ohio");
        testSurvey.setActivityLevel("inactive");

        dao.save(testSurvey);


        SurveyResult testSurveyResult = new SurveyResult();
        testSurveyResult.setParkCode("TEST");
        testSurveyResult.setParkName("TEST PARK");
        testSurveyResult.setCount(5);

        List<SurveyResult> testResultList = dao.getAllSurveys();
        testResultList.add(testSurveyResult);


        Assert.assertEquals("TEST", testResultList.get(testResultList.size() - 1).getParkCode());
    }
}

