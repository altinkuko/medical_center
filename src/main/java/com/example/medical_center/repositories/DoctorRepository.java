package com.example.medical_center.repositories;

import com.example.medical_center.dao.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
