package com.example.medical_center.dao;

import com.example.medical_center.static_data.Role;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    @NotNull(message = "Username must not be null")
    private String username;
    @Enumerated(EnumType.STRING)
    private Role role;

}
