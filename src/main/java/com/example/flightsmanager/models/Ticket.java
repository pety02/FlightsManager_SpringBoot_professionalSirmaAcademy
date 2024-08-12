package com.example.flightsmanager.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Flight flight;
    @OneToOne(fetch = FetchType.LAZY)
    private User owner;
    @Column(nullable = false)
    private Double price;
}