package org.example.provider;

import org.example.service.TemperatureConverter;
import org.example.service.annotations.Converter;

@Converter(value = "fahrenheit")
public class ConvertToFahrenheit implements TemperatureConverter {
    @Override
    public double convertTemperature(double temperature) {
        return (temperature - 32) * 5 / 9;
    }
}
