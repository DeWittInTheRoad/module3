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


    @Before
    public void setUp() throws Exception {
        dao = new JdbcWeatherDao(getDataSource());
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