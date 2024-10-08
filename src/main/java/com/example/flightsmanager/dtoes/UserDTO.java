package com.example.flightsmanager.dtoes;

import com.example.flightsmanager.models.Gender;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    // TODO: to add validation with annotations
    private Long id;
    private String name;
    private String family;
    private Gender gender;
    private String email;
    private String username;
    private String password;
    private String role;
    private List<Long> ticketsIds;
}