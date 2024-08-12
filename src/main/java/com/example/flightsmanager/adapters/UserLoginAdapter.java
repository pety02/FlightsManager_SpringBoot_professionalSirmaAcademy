package com.example.flightsmanager.adapters;

import com.example.flightsmanager.adapters.interfaces.Adapter;
import com.example.flightsmanager.dtoes.LoginUserDTO;
import com.example.flightsmanager.models.Password;
import com.example.flightsmanager.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserLoginAdapter implements Adapter<User, LoginUserDTO> {
    @Override
    public User toEntity(LoginUserDTO loginUserDTO) {
        User user = new User();
        user.setId(loginUserDTO.getId());
        user.setUsername(loginUserDTO.getUsername());
        Password password = new Password();
        password.setHashedPassword(loginUserDTO.getPassword());
        password.setOwner(user);
        user.setPassword(password);

        return user;
    }

    @Override
    public LoginUserDTO toDTO(User user) {
        LoginUserDTO dto = new LoginUserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword().getHashedPassword());

        return dto;
    }
}