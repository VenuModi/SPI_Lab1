import org.example.provider.ConvertToCelsius;
import org.example.provider.ConvertToFahrenheit;
import org.example.service.TemperatureConverter;

module org.example.provider {
    requires org.example.service;
    exports org.example.provider;
    provides TemperatureConverter with ConvertToCelsius, ConvertToFahrenheit;
}