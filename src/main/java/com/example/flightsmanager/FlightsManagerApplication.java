package com.example.flightsmanager;

import com.example.flightsmanager.controllers.FlightController;
import com.example.flightsmanager.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootApplication
public class FlightsManagerApplication implements ApplicationRunner {
    @Autowired
    private FlightController controller;
    public static void main(String[] args) {
        SpringApplication.run(FlightsManagerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Flights Manger is running...");
        controller.create(new Flight("India flight", LocalDateTime.now(), LocalDateTime.of(2024, Month.JULY, 30, 12, 30, 0), "Sofia, Bulgaria", "Delhi, India", 100));
        controller.create(new Flight("Canada flight", LocalDateTime.now(), LocalDateTime.of(2024, Month.AUGUST, 5, 12, 30, 0), "Sofia, Bulgaria", "Ontario, Canada", 200));

        controller.getAll().forEach(f -> System.out.println(f.toString()));
        controller.update(2, new Flight("Canada FLIGHT2", LocalDateTime.now(), LocalDateTime.of(2024, Month.AUGUST, 5, 12, 30, 0), "Sofia, Bulgaria", "Ontario, Canada", 200));
        controller.getById(2).ifPresent(System.out::println);
        if(controller.remove(1)) {
            System.out.printf("Successfully removed flight with id %d!%n", 1);
            controller.getAll().forEach(f -> System.out.println(f.toString()));
        } else {
            System.out.printf("Sorry, unsuccessfully removed flight with id %d!%n", 1);
        }
    }
}
