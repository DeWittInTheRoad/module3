package com.techelevator.npgeek.model;

public class Weather {
    String parkCode;
    int fiveDayForecastValue;
    int low;
    int high;
    String forecast;

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public int getFiveDayForecastValue() {
        return fiveDayForecastValue;
    }

    public void setFiveDayForecastValue(int fiveDayForecastValue) {
        this.fiveDayForecastValue = fiveDayForecastValue;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }
}
