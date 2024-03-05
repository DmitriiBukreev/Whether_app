package main;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherData {
    private String temperature;
    private String wind;
    private String pressure;
    private String humidity;
    private String date;
}
