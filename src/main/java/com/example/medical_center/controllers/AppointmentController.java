package com.example.medical_center.controllers;

import com.example.medical_center.dao.Appointment;
import com.example.medical_center.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/all")
    public List<Appointment> getAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public Appointment getById(@PathVariable Long id) {
        return appointmentService.findById(id);
    }

    @PostMapping("/create")
    public Appointment create(@RequestBody Appointment appointment, @RequestParam Long doctorId) {
        return appointmentService.create(appointment, doctorId);
    }

    @PutMapping("/update")
    public Appointment update(@RequestBody Appointment appointment, Long doctorId) {
        return appointmentService.update(appointment, doctorId);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam Long id) {
        return appointmentService.delete(id);
    }

    @GetMapping("/byDoctor")
    public List<Appointment> getByDoctorAfter(@RequestParam Long doctorId){
        return appointmentService.getByDoctorAfter(doctorId);
    }
}













