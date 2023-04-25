

module org.example.consumer {
    requires org.example.service;
    uses org.example.service.TemperatureConverter;
    uses org.example.service.annotations.Converter;
}