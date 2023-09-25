package com.example.medical_center.controllers;

import com.example.medical_center.dao.Doctor;
import com.example.medical_center.services.DoctorService;
import com.example.medical_center.static_data.Message;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/all")
    public List<Doctor> getAll() {
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getById(@PathVariable Long id) {
        return doctorService.findById(id);
    }

    @PostMapping("/create")
    public Doctor create(@RequestBody Doctor doctor) {
        return doctorService.create(doctor);
    }

    @PutMapping("/update")
    public Doctor update(@RequestBody Doctor doctor) {
        return doctorService.update(doctor);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Message> deleteById(@RequestParam Long id) {
        return ResponseEntity.ok(new Message(doctorService.delete(id)));
    }
}
