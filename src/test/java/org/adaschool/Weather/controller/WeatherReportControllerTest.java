package org.adaschool.weather.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.adaschool.weather.data.WeatherReport;
import org.adaschool.weather.service.WeatherReportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WeatherReportControllerTest {

    @Mock
    WeatherReportService weatherReportService;

    @InjectMocks
    WeatherReportController weatherReportController;

    @Test
    void testGetWeatherReport() {
        double latitude = 37.8267;
        double longitude = -122.4233;
        WeatherReport mockReport = new WeatherReport();
        when(weatherReportService.getWeatherReport(latitude, longitude)).thenReturn(mockReport);

        WeatherReport result = weatherReportController.getWeatherReport(latitude, longitude);
        assertEquals(mockReport, result);
    }
}
