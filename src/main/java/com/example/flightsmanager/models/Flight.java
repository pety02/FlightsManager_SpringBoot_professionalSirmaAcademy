package com.example.flightsmanager.models;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Timestamp
    @Column(nullable = false)
    private LocalDateTime startDate;
    @Timestamp
    @Column(nullable = false)
    private LocalDateTime endDate;
    @ManyToOne
    private Location from;
    @ManyToOne
    private Location to;
    @ManyToMany
    private List<FlightRout> flightsRouts;
    @OneToMany
    @Column(nullable = false)
    private List<Ticket> tickets;
    @ManyToOne
    private Plane plane;
}