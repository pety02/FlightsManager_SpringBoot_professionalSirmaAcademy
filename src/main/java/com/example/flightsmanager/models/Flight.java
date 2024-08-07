package com.example.flightsmanager.models;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Timestamp
    @Column(nullable = false)
    private LocalDateTime startDate;
    @Timestamp
    @Column(nullable = false)
    private LocalDateTime endDate;
    @Column(nullable = false)
    private String fromPlaceName;
    @Column(nullable = false)
    private String toPlaceName;
    @Column(nullable = false)
    private int currentPassengersCount;
    @Column(nullable = false)
    private int maxPassengersCount;

    public Flight() {

    }
    public Flight(LocalDateTime startDate, LocalDateTime endDate,
                  String fromPlaceName, String toPlaceName,
                  int maxPassengersCount) {
        this.id = null;
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setFromPlaceName(fromPlaceName);
        this.setToPlaceName(toPlaceName);
        this.setCurrentPassengersCount(0);
        this.setMaxPassengersCount(maxPassengersCount);
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setFromPlaceName(String fromPlaceName) {
        this.fromPlaceName = fromPlaceName;
    }

    public void setToPlaceName(String toPlaceName) {
        this.toPlaceName = toPlaceName;
    }

    public void setCurrentPassengersCount(int currentPassengersCount) {
        this.currentPassengersCount = currentPassengersCount;
    }

    public void setMaxPassengersCount(int maxPassengersCount) {
        this.maxPassengersCount = maxPassengersCount;
    }

    @Override
    public String toString() {
        return "startDate = " + startDate +
                ", endDate = " + endDate +
                ", fromPlaceName = " + fromPlaceName +
                ", toPlaceName = " + toPlaceName +
                ", currentPassengersCount = " + currentPassengersCount +
                ", maxPassengersCount = " + maxPassengersCount;
    }
}