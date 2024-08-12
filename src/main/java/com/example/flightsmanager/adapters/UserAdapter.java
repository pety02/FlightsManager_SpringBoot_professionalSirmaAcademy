package com.example.flightsmanager.adapters;

import com.example.flightsmanager.adapters.interfaces.Adapter;
import com.example.flightsmanager.dtoes.UserDTO;
import com.example.flightsmanager.models.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserAdapter implements Adapter<User, UserDTO> {
    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setFamily(userDTO.getFamily());
        user.setGender(userDTO.getGender());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        Password password = new Password();
        password.setHashedPassword(userDTO.getPassword());
        password.setOwner(user);
        user.setPassword(password);
        Role role = new Role();
        role.setName(userDTO.getRole());
        user.setRole(role);
        user.setTickets(new ArrayList<>());

        return user;
    }

    @Override
    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setFamily(dto.getFamily());
        dto.setGender(user.getGender());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword().getHashedPassword());
        dto.setRole(user.getRole().getName());
        dto.setTicketsIds(user.getTickets().stream().map(Ticket::getId).toList());

        return dto;
    }
}