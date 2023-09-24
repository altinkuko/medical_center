package com.example.medical_center.services.impl;

import com.example.medical_center.dao.Appointment;
import com.example.medical_center.dao.Doctor;
import com.example.medical_center.exceptions.GenericExceptions;
import com.example.medical_center.repositories.AppointmentRepository;
import com.example.medical_center.repositories.DoctorRepository;
import com.example.medical_center.services.AppointmentService;
import com.example.medical_center.static_data.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public Appointment create(Appointment appointment, Long doctorId) {
        if (appointment.getAppointmentId() != null) {
            throw GenericExceptions.idNotNull();
        } else {
            Optional<Doctor> doctor = doctorRepository.findById(doctorId);
            if (doctor.isPresent()) {
                List<Appointment> appointments = doctor.get().getAppointments();
                if (!appointments.isEmpty()) {
                    appointments.forEach(app -> {
                        if (this.isTimeWrong(app, appointment.getBeginsAt(), appointment.getEndsAt())) {
                            throw GenericExceptions.timeIsWrong();
                        }
                    });
                }
                appointment.setDoctor(doctor.get());
                appointment.setStatus(Status.CREATED);
                appointmentRepository.save(appointment);
                return appointment;
            } else {
                throw GenericExceptions.notFound(doctorId);
            }
        }
    }

    @Override
    public Appointment update(Appointment appointment, Long doctorId) {
        if (appointment.getAppointmentId() == null) {
            throw GenericExceptions.idIsNull();
        } else {
            Optional<Appointment> existingAppointment = appointmentRepository.findById(appointment.getAppointmentId());
            if (existingAppointment.isPresent()) {
                Optional<Doctor> doctor = doctorRepository.findById(doctorId);
                if (doctor.isPresent()) {
                    List<Appointment> appointments = doctor.get().getAppointments();
                    if (!appointments.isEmpty()) {
                        appointments.forEach(app -> {
                            if (this.isTimeWrong(app, appointment.getBeginsAt(), appointment.getEndsAt())) {
                                throw GenericExceptions.timeIsWrong();
                            }
                        });
                    }
                    appointment.setDoctor(doctor.get());
                    appointmentRepository.save(appointment);
                    return appointment;
                } else {
                    throw GenericExceptions.notFound(doctorId);
                }
            } else {
                throw GenericExceptions.notFound(appointment.getAppointmentId());
            }
        }
    }

    @Override
    public Appointment findById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        return appointment.orElseThrow(() -> GenericExceptions.notFound(id));
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

    @Override
    public List<Appointment> getByDoctorAfter(Long doctorId) {
        return appointmentRepository.getByDoctorAndAfter(doctorId, LocalDateTime.now());
    }

    private Boolean isTimeWrong(Appointment appointment, LocalDateTime start, LocalDateTime end) {
        return ((start == null || end == null)
                || (start.isAfter(appointment.getBeginsAt()) && start.isBefore(appointment.getEndsAt()))
                || (end.isAfter(appointment.getBeginsAt()) && end.isBefore(appointment.getEndsAt()))
                || (start.isBefore(appointment.getBeginsAt()) && end.isAfter(appointment.getEndsAt()))
                || (start.isEqual(appointment.getBeginsAt()) || start.isEqual(appointment.getEndsAt()))
                || (end.isEqual(appointment.getBeginsAt()) || end.isEqual(appointment.getEndsAt()))
                || start.isAfter(end));
    }
}
