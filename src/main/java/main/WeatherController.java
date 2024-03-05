package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
//TODO proper error handling
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherData getWeather() {
        try {
            return weatherService.getWeather();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}