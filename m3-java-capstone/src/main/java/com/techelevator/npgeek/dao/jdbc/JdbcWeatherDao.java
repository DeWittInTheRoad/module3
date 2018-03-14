package com.techelevator.npgeek.dao.jdbc;

import com.techelevator.npgeek.dao.WeatherDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWeatherDao implements WeatherDAO{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcWeatherDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Weather> getWeatherByParkCode(String parkCode) {
        List<Weather> allWeather = new ArrayList<>();
        String sqlSelectAllWeather = "SELECT * FROM weather WHERE parkcode = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllWeather);
        while(results.next()) {
            allWeather.add(mapRowToWeather(results));
        }
        return allWeather;
    }

    private Weather mapRowToWeather(SqlRowSet row) {
        Weather weather = new Weather();
        weather.setParkCode(row.getString("parkCode"));
        weather.setFiveDayForecast(row.getInt("fivedayforecast"));
        weather.setLow(row.getInt("low"));
        weather.setHigh(row.getInt("high"));
        weather.setForecast(row.getString("forecast"));

        return weather;
    }


}
