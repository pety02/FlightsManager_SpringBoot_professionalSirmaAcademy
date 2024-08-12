package com.example.flightsmanager.adapters.interfaces;

public interface Adapter<Entity, DTO> {
    Entity toEntity(DTO dto);
    DTO toDTO(Entity entity);
}