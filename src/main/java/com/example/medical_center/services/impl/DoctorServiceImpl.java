package com.example.medical_center.services.impl;

import com.example.medical_center.dao.Doctor;
import com.example.medical_center.exceptions.GenericExceptions;
import com.example.medical_center.repositories.DoctorRepository;
import com.example.medical_center.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Override
    public Doctor create(Doctor doctor) {
        if (doctor.getDoctorId() != null){
            throw GenericExceptions.idNotNull();
        } else if(doctorRepository.existsByUsername(doctor.getUsername())) {
            throw GenericExceptions.usernameExists(doctor.getUsername());
        } else {
            doctorRepository.save(doctor);
            return doctor;
        }
    }

    @Override
    public Doctor update(Doctor doctor) {
        if (doctor.getDoctorId() == null){
            throw GenericExceptions.idIsNull();
        } else {
            Optional<Doctor> optionalDoctor = doctorRepository.findById(doctor.getDoctorId());
            if ((optionalDoctor.isPresent() && optionalDoctor.get().getUsername().equals(doctor.getUsername()))
                    || !doctorRepository.existsByUsername(doctor.getUsername())){
                doctorRepository.save(doctor);
                return doctor;
            } else if (doctorRepository.existsByUsername(doctor.getUsername())) {
                throw GenericExceptions.usernameExists(doctor.getUsername());
            } else {
                throw GenericExceptions.notFound(doctor.getDoctorId());
            }
        }
    }

    @Override
    public Doctor findById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.orElseThrow(()-> GenericExceptions.notFound(id));
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent() && doctor.get().getAppointments().isEmpty()) {
            doctorRepository.deleteById(id);
            return String.format("Record with id %d deleted", id);
        } else if (doctor.isPresent() && !doctor.get().getAppointments().isEmpty()){
            return "This record cannot be deleted";
        } else {
            throw GenericExceptions.notFound(id);
        }
    }
}
