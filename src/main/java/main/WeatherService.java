package main;

import main.WeatherData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URL;

@Service
public class WeatherService {

    private static Document getPage() throws IOException {
        String url = "https://meteofor.com/";
        return Jsoup.parse(new URL(url), 3000);
    }

    public WeatherData getWeather() throws IOException {
        Document page = getPage();
        WeatherData data = new WeatherData();

        Element tableWth = page.select("main[class=content wrap]").first();
        if (tableWth != null) {
            data.setTemperature(tableWth.select("div.temperature").text());
            String wind = tableWth.select("div.weather-item:contains(Wind) div.item-value").text();
            data.setWind(wind.substring(0, wind.indexOf(' ')));
            data.setPressure(tableWth.select("div.weather-item:contains(Pressure) div.item-value").text());
            data.setHumidity(tableWth.select("div.weather-item:contains(Humidity) div.item-value").text());
            data.setDate(tableWth.select("div.city-info").text());
        }
        return data;
    }
}
