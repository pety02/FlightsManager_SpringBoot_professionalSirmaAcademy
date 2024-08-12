package com.example.flightsmanager.repositories;

import com.example.flightsmanager.models.FlightRout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRoutRepository extends JpaRepository<FlightRout, Long> {
}