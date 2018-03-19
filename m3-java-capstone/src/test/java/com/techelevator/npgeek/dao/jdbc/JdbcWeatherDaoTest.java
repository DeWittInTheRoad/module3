package com.techelevator.npgeek.dao.jdbc;

import com.techelevator.DAOIntegrationTest;
import com.techelevator.npgeek.model.Weather;
import org.junit.*;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcWeatherDaoTest extends DAOIntegrationTest{
    private static SingleConnectionDataSource dataSource;
    private JdbcWeatherDao dao;

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
        dao = new JdbcWeatherDao(dataSource);
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
    public void getWeatherByParkCode() {

        List<Weather> testWeatherList = dao.getWeatherByParkCode("GTNP");

        assertEquals(46, testWeatherList.get(0).getHigh());
        assertEquals(27, testWeatherList.get(0).getLow());
        assertEquals("cloudy", testWeatherList.get(0).getForecast());
        assertEquals(1, testWeatherList.get(0).getFiveDayForecastValue());

    }

}