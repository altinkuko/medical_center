package com.example.medical_center.dao;

import com.example.medical_center.static_data.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private String patientName;
    private String note;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime beginsAt;
    private LocalDateTime endsAt;
    @ManyToOne
    @JoinColumn(name = "doctor")
    @JsonIgnore
    private Doctor doctor;
    @OneToOne(mappedBy = "appointment")
    private Report report;
}
