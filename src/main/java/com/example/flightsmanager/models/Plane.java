package com.example.flightsmanager.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String name;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Seat> seats;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Flight> flights;
}