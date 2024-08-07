package com.example.flightsmanager.controllers;

import com.example.flightsmanager.models.Flight;
import com.example.flightsmanager.services.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FlightController {
    private final FlightService service;

    @Autowired
    public FlightController(FlightService service) {
        this.service = service;
    }

    @GetMapping("/flights")
    public String getFlight(Model model) {
        List<Flight> allFlights = service.getAll();
        model.addAttribute("allFlights", allFlights);
        return "flights";
    }

    @GetMapping("/flights/{id}")
    public String getFlight(@PathVariable("id") Long id, Model model) {
        Flight currentFlight = service.getById(id).orElse(new Flight());
        model.addAttribute("currentFlight", currentFlight);
        return "current_flight";
    }

    @GetMapping("/flights/add")
    public String getNewFlightPage() {
        return "new_flight";
    }
    @PostMapping("/flights/add")
    public String addFlight(@ModelAttribute Flight flight, Model model) {
        Flight createdFlight = service.create(flight);
        model.addAttribute("createdFlight", createdFlight);
        return "flights";
    }

    @PutMapping("/flights/{id}/update")
    public String updateFlight(@PathVariable Long id,
                               @ModelAttribute Flight flight,
                               Model model) {
        Flight updatedFlight = service.update(id, flight);
        model.addAttribute("updatedFlight", updatedFlight);
        return "flights";
    }

    @GetMapping("/flights/{id}/delete")
    public String deleteFlight(@PathVariable("id") Long id) {
        service.remove(id);
        return "flights";
    }
}