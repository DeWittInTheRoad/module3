package com.techelevator.npgeek.dao;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

import java.util.List;

public interface WeatherDao {
    public List<Weather> getWeatherByParkCode(String parkCode);
//public Weather getWeatherByParkCode(String parkCode);

}
