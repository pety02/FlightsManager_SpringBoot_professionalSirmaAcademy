package com.example.flightsmanager.services.interfaces;

import com.example.flightsmanager.dtoes.LoginUserDTO;
import com.example.flightsmanager.dtoes.RegisterUserDTO;
import com.example.flightsmanager.dtoes.UserDTO;
import java.util.List;

public interface UserService {
    RegisterUserDTO register(RegisterUserDTO dto);
    LoginUserDTO login(LoginUserDTO dto);
    UserDTO readUser(Long id);
    List<UserDTO> readAllUsers();
    UserDTO updateUser(Long id, UserDTO dto);
    void deleteUser(Long id);
}