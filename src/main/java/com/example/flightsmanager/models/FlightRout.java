package com.example.flightsmanager.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightRout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Flight> flights;
}