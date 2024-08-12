package com.example.flightsmanager.adapters;

import com.example.flightsmanager.adapters.interfaces.Adapter;
import com.example.flightsmanager.dtoes.UserDTO;
import com.example.flightsmanager.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter implements Adapter<User, UserDTO> {
    @Override
    public User toEntity(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO toDTO(User user) {
        return null;
    }
}
