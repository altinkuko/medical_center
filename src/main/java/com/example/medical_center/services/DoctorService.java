package com.example.medical_center.services;

import com.example.medical_center.dao.Doctor;

import java.util.List;

public interface DoctorService{
    Doctor create(Doctor entity);
    Doctor update(Doctor entity);
    Doctor findById(Long id);
    List<Doctor> findAll();
    String delete(Long id);
}
