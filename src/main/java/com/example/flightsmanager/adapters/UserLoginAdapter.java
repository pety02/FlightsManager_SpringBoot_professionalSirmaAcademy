package com.example.flightsmanager.adapters;

import com.example.flightsmanager.adapters.interfaces.Adapter;
import com.example.flightsmanager.dtoes.LoginUserDTO;
import com.example.flightsmanager.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserLoginAdapter implements Adapter<User, LoginUserDTO> {
    @Override
    public User toEntity(LoginUserDTO loginUserDTO) {
        return null;
    }

    @Override
    public LoginUserDTO toDTO(User user) {
        return null;
    }
}
