package com.example.medical_center.services.impl;

import com.example.medical_center.dao.Appointment;
import com.example.medical_center.exceptions.GenericExceptions;
import com.example.medical_center.repositories.AppointmentRepository;
import com.example.medical_center.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    @Override
    public Appointment create(Appointment appointment) {
        if (appointment.getAppointmentId() != null){
            throw GenericExceptions.idNotNull();
        } else {
            appointmentRepository.save(appointment);
            return appointment;
        }
    }

    @Override
    public Appointment update(Appointment appointment) {
        if (appointment.getAppointmentId() == null){
            throw GenericExceptions.idIsNull();
        } else {
            appointmentRepository.save(appointment);
            return appointment;
        }
    }

    @Override
    public Appointment findById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        return appointment.orElseThrow(()-> GenericExceptions.notFound(id));
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        appointmentRepository.deleteById(id);
        return String.format("Record with id %d deleted", id);
    }
}
