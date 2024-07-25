package com.example.flightsmanager.interfaces;

import java.util.List;
import java.util.Optional;

public interface Manageable<T> {
    List<T> getAll();
    Optional<T> getById(long id);
    boolean create(T entity);
    boolean update(long id, T entity);
    boolean remove(long id);
}