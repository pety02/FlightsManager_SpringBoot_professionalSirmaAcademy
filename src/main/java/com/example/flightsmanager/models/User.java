package com.example.flightsmanager.models;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 150)
    private String family;
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false, unique = true, length = 300)
    private String email;
    @Column(nullable = false, length = 150)
    private String username;
    @OneToOne(fetch = FetchType.EAGER)
    private Password password;
    @ManyToOne
    private Role role;
    @OneToMany
    private List<Ticket> tickets;

    public User(User other) {
        this.setId(other.getId());
        this.setName(other.getName());
        this.setFamily(other.getFamily());
        this.setGender(other.getGender());
        this.setEmail(other.getEmail());
        this.setUsername(other.getUsername());
        this.setPassword(other.getPassword());
        this.setRole(other.getRole());
        this.setTickets(other.getTickets());
    }
}