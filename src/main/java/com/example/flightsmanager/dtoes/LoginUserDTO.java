package com.example.flightsmanager.dtoes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDTO {
    // TODO: to add validation with annotations
    private Long id;
    private String username;
    private String password;
}