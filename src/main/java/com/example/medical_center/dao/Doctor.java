package com.example.medical_center.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    @Column(unique = true)
    @NotEmpty(message = "Please enter a username")
    private String username;
    @NotEmpty(message = "Please enter a name")
    private String name;
    @NotEmpty(message = "Please enter a specialization")
    private String specialization;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}
