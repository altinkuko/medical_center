package com.example.medical_center.repositories;

import com.example.medical_center.dao.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
