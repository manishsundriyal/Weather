package com.example.sundriyal.whether;

import java.util.ArrayList;

/**
 * Created by sundriyal on 3/2/18.
 */

public class Model2 {

    private String LocalObservationDateTime;
    private int EpochTime;
    private String WeatherText;

    public String getLocalObservationDateTime() {
        return LocalObservationDateTime;
    }

    public void setLocalObservationDateTime(String localObservationDateTime) {
        LocalObservationDateTime = localObservationDateTime;
    }

    public int getEpochTime() {
        return EpochTime;
    }

    public void setEpochTime(int epochTime) {
        EpochTime = epochTime;
    }

    public String getWeatherText() {
        return WeatherText;
    }

    public void setWeatherText(String weatherText) {
        WeatherText = weatherText;
    }
}
