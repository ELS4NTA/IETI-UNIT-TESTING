package org.adaschool.weather.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.adaschool.weather.data.WeatherApiResponse;
import org.adaschool.weather.data.WeatherReport;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class WeatherReportServiceTest {

    String API_KEY = "82c65689932767824e83835180547308";
    String API_URL = "https://api.openweathermap.org/data/2.5/weather";

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    WeatherReportService weatherReportService;

    @Test
    void testGetWeatherReport() {
        double latitude = 37.8267;
        double longitude = -122.4233;
        String url = API_URL + "?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_KEY;
        WeatherApiResponse weatherApiResponse = new WeatherApiResponse();
        WeatherApiResponse.Main main = new WeatherApiResponse.Main();
        main.setHumidity(79);
        main.setTemperature(0);
        weatherApiResponse.setMain(main);

        WeatherReport report = new WeatherReport();
        report.setTemperature(main.getTemperature());
        report.setHumidity(main.getHumidity());

        when(restTemplate.getForObject(url, WeatherApiResponse.class)).thenReturn(weatherApiResponse);
        WeatherReport weatherReport = weatherReportService.getWeatherReport(latitude, longitude);
        assertEquals(report.getTemperature(), weatherReport.getTemperature());
        assertEquals(report.getHumidity(), weatherReport.getHumidity());
    }
}
