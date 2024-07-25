package com.example.flightsmanager.services;

import com.example.flightsmanager.interfaces.Manageable;
import com.example.flightsmanager.models.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService implements Manageable<Flight> {
    private final List<Flight> flights = new ArrayList<>();
    @Override
    public List<Flight> getAll() {
        return flights;
    }

    @Override
    public Optional<Flight> getById(long id) {
        for(Flight flight : flights) {
            if(flight.getId() == id) {
                return Optional.of(flight);
            }
        }

        return Optional.empty();
    }

    @Override
    public boolean create(Flight entity) {
        return flights.add(entity);
    }

    @Override
    public boolean update(long id, Flight entity) {
        for(Flight flight : flights) {
            if(flight.getId() == id) {
                flight.setName(entity.getName());
                flight.setStartDate(entity.getStartDate());
                flight.setEndDate(entity.getEndDate());
                flight.setFromPlaceName(entity.getFromPlaceName());
                flight.setToPlaceName(entity.getToPlaceName());
                flight.setMaxPassengersCount(entity.getMaxPassengersCount());
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean remove(long id) {
        for(Flight flight : flights) {
            if(flight.getId() == id) {
                return flights.remove(flight);
            }
        }

        return false;
    }
}
