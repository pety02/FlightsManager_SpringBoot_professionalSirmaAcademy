package com.example.flightsmanager.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String address;
    @ManyToOne
    private SeatClass seatClass;
    @Column(nullable = false)
    private Boolean isAvailable;
}