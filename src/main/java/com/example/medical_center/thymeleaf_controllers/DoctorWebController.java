package com.example.medical_center.thymeleaf_controllers;

import com.example.medical_center.dao.Doctor;
import com.example.medical_center.services.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/web/doctor")
public class DoctorWebController {
    private final DoctorService doctorService;

    @GetMapping("/all")
    public String getAll(Model model) {
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);
        return "/doctor/doctors";
    }

    @GetMapping("/create")
    public String cratePage(@ModelAttribute(name = "doctor") Doctor doctor) {
        return "/doctor/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(value = "doctor") @Valid Doctor doctor, BindingResult result) {
        if (result.hasFieldErrors()) {
            return "/doctor/create";
        } else {
            doctorService.create(doctor);
            return "redirect:/web/doctor/all";
        }
    }
    @GetMapping("/details")
    public String getById(@RequestParam Long id, Model model){
        model.addAttribute("doctor", doctorService.findById(id));
        return "/doctor/details";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute(value = "doctor") @Valid Doctor doctor, BindingResult result, Model model){
        if (result.hasFieldErrors()){
            model.addAttribute("doctor", doctor);
            return "/doctor/details";
        } else {
            doctorService.update(doctor);
            return "redirect:/web/doctor/all";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Long id, Model model){
        String message = doctorService.delete(id);
        model.addAttribute("message", message);
        return "/doctor/delete";
    }
}
