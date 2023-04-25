package org.example.provider;

import org.example.service.TemperatureConverter;
import org.example.service.annotations.Converter;

@Converter(value = "celsius")
public class ConvertToCelsius implements TemperatureConverter {
    @Override
    public double convertTemperature(double temperature) {
        return (temperature * 9 / 5) + 32;
    }
}
