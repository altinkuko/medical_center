package com.example.medical_center.dao;

import jakarta.persistence.*;
import lombok.*;

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
    private String username;
    private String name;
    private String specialization;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}
