package com.example.flightsmanager.controllers;

import com.example.flightsmanager.models.Flight;
import com.example.flightsmanager.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class FlightController {
    @Autowired
    private FlightService service;
    public List<Flight> getAll() {
        return service.getAll();
    }

    public Optional<Flight> getById(long id) {
        return service.getById(id);
    }

    public Flight create(Flight entity) {
        return service.create(entity);
    }

    public Flight update(long id, Flight entity) {
        return service.update(id, entity);
    }

    public void remove(long id) {
        service.remove(id);
    }
}
