package org.example.consumer;

import org.example.service.TemperatureConverter;
import org.example.service.annotations.Converter;

import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;


public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            printMenu();
            switch (scanner.nextLine()){
                case "1" -> convertCelsiusToFahrenheit(scanner);
                case "2" -> convertFahrenheitToCelsius(scanner);
                case "3" -> System.exit(0);
            }
        }
    }
    private static void convertCelsiusToFahrenheit(Scanner scanner){
        System.out.println("Enter temperature in celsius: ");
        double celsius = scanner.nextDouble();
        for (var c: getConverters("celsius")) {
            double fahrenheit = c.convertTemperature(celsius);
            System.out.printf("%.2f degrees Celsius is %.2f degrees Fahrenheit\n", celsius, fahrenheit);
        }
    }

    private static void convertFahrenheitToCelsius(Scanner scanner){
        System.out.println("Enter temperature in fahrenheit:");
        double fahrenheit = scanner.nextDouble();
        for (var c: getConverters("fahrenheit")) {
            double celsius = c.convertTemperature(fahrenheit);
            System.out.printf("%.2f degrees Fahrenheit is %.2f degrees Celsius\n", fahrenheit, celsius);
        }
    }

    private static List<TemperatureConverter>getConverters(String containsString){
        ServiceLoader<TemperatureConverter> serviceLoader = ServiceLoader.load(TemperatureConverter.class);
        return serviceLoader.stream()
                .filter(c -> c.type().isAnnotationPresent(Converter.class)
                && c.type().getAnnotation(Converter.class)
                .value()
                .equals(containsString))
                .map(ServiceLoader.Provider::get)
                .toList();
    }

    private static void printMenu(){
        System.out.println("""
                Temperature Converter App
                1. Convert Celsius to Fahrenheit
                2. Convert Fahrenheit to Celsius
                3. Exit
                """);
    }
}
