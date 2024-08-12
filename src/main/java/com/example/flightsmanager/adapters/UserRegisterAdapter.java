package com.example.flightsmanager.adapters;

import com.example.flightsmanager.adapters.interfaces.Adapter;
import com.example.flightsmanager.dtoes.RegisterUserDTO;
import com.example.flightsmanager.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterAdapter implements Adapter<User, RegisterUserDTO> {
    @Override
    public User toEntity(RegisterUserDTO registerUserDTO) {
        return null;
    }

    @Override
    public RegisterUserDTO toDTO(User user) {
        return null;
    }
}
