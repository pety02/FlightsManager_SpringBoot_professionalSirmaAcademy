package com.example.flightsmanager.services;

import com.example.flightsmanager.adapters.UserAdapter;
import com.example.flightsmanager.adapters.UserLoginAdapter;
import com.example.flightsmanager.adapters.UserRegisterAdapter;
import com.example.flightsmanager.dtoes.LoginUserDTO;
import com.example.flightsmanager.dtoes.RegisterUserDTO;
import com.example.flightsmanager.dtoes.UserDTO;
import com.example.flightsmanager.models.User;
import com.example.flightsmanager.repositories.UserRepository;
import com.example.flightsmanager.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRegisterAdapter userRegisterAdapter;
    private final UserLoginAdapter userLoginAdapter;
    private final UserAdapter userAdapter;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRegisterAdapter userRegisterAdapter,
                           UserLoginAdapter userLoginAdapter,
                           UserAdapter userAdapter,
                           UserRepository userRepository) {
        this.userRegisterAdapter = userRegisterAdapter;
        this.userLoginAdapter = userLoginAdapter;
        this.userAdapter = userAdapter;
        this.userRepository = userRepository;
    }


    @Override
    public RegisterUserDTO register(RegisterUserDTO dto) {
        User user = userRegisterAdapter.toEntity(dto);
        return userRegisterAdapter.toDTO(userRepository.save(user));
    }

    @Override
    public LoginUserDTO login(LoginUserDTO dto) {
        User user = userLoginAdapter.toEntity(dto);
        return userLoginAdapter.toDTO(user);
    }

    @Override
    public UserDTO readUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userAdapter::toDTO).orElse(null);
    }

    @Override
    public List<UserDTO> readAllUsers() {
        return userRepository.findAll().stream().map(userAdapter::toDTO).toList();
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO dto) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent() && Objects.equals(dto.getId(), id)) {
            User currentUser = userAdapter.toEntity(dto);
            return userAdapter.toDTO(currentUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}