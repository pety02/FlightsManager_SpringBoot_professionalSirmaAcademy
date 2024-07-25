package com.example.flightsmanager.controllers;

import com.example.flightsmanager.interfaces.Manageable;
import com.example.flightsmanager.models.Flight;
import com.example.flightsmanager.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class FlightController implements Manageable<Flight> {
    @Autowired
    private FlightService service;
    @Override
    public List<Flight> getAll() {
        return service.getAll();
    }

    @Override
    public Optional<Flight> getById(long id) {
        return service.getById(id);
    }

    @Override
    public boolean create(Flight entity) {
        return service.create(entity);
    }

    @Override
    public boolean update(long id, Flight entity) {
        return service.update(id, entity);
    }

    @Override
    public boolean remove(long id) {
        return service.remove(id);
    }
}
