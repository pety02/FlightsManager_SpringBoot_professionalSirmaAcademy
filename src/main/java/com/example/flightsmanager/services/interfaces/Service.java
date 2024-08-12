package com.example.flightsmanager.services.interfaces;

import java.util.List;

public interface Service<DTO> {
    DTO create(DTO dto);
    DTO read(Long id);
    List<DTO> readAll();
    DTO update(DTO update);
    void delete(Long id);
}