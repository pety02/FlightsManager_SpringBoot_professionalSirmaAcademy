package com.example.flightsmanager.services;

import com.example.flightsmanager.models.Flight;
import com.example.flightsmanager.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getById(long id) {
        return flightRepository.findById(id);
    }

    public Flight create(Flight entity) {
        return flightRepository.save(entity);
    }

    public Flight update(long id, Flight entity) {

        Optional<Flight> toBeUpdated = flightRepository.findById(id);
        if(toBeUpdated.isPresent()) {
            toBeUpdated.get().setStartDate(entity.getStartDate());
            toBeUpdated.get().setEndDate(entity.getEndDate());
            toBeUpdated.get().setFromPlaceName(entity.getFromPlaceName());
            toBeUpdated.get().setToPlaceName(entity.getToPlaceName());
            toBeUpdated.get().setCurrentPassengersCount(entity.getCurrentPassengersCount());
            toBeUpdated.get().setMaxPassengersCount(entity.getMaxPassengersCount());
            return flightRepository.save(toBeUpdated.get());
        }

        return null;
    }

    public void remove(long id) {
        Optional<Flight> toBeDeleted = flightRepository.findById(id);
        toBeDeleted.ifPresent(flightRepository::delete);
    }
}
