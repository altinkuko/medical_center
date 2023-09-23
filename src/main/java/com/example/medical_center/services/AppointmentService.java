package com.example.medical_center.services;

import com.example.medical_center.dao.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment create(Appointment appointment, Long doctorId);
    Appointment update(Appointment appointment, Long doctorId);
    Appointment findById(Long id);
    List<Appointment> findAll();
    String delete(Long id);
}
