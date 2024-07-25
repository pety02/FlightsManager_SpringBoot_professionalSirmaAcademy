package com.example.flightsmanager.models;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class Flight {
    private final static AtomicLong count = new AtomicLong();
    private final long id;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String fromPlaceName;
    private String toPlaceName;
    private int maxPassengersCount;

    public Flight() {
        this.id = count.incrementAndGet();
    }

    public Flight(String name, LocalDateTime startDate, LocalDateTime endDate,
                  String fromPlaceName, String toPlaceName, int maxPassengersCount) {
        this.id = count.incrementAndGet();
        this.setName(name);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setFromPlaceName(fromPlaceName);
        this.setToPlaceName(toPlaceName);
        this.setMaxPassengersCount(maxPassengersCount);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getFromPlaceName() {
        return fromPlaceName;
    }

    public void setFromPlaceName(String fromPlaceName) {
        this.fromPlaceName = fromPlaceName;
    }

    public String getToPlaceName() {
        return toPlaceName;
    }

    public void setToPlaceName(String toPlaceName) {
        this.toPlaceName = toPlaceName;
    }

    public int getMaxPassengersCount() {
        return maxPassengersCount;
    }

    public void setMaxPassengersCount(int maxPassengersCount) {
        this.maxPassengersCount = maxPassengersCount;
    }

    @Override
    public String toString() {
        return "name = " + name +
                ", startDate = " + startDate +
                ", endDate = " + endDate +
                ", fromPlaceName = " + fromPlaceName +
                ", toPlaceName = " + toPlaceName +
                ", maxPassengersCount = " + maxPassengersCount;
    }
}