package com.example.medical_center.controllers;

import com.example.medical_center.dao.Report;
import com.example.medical_center.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/all")
    public List<Report> getAll() {
        return reportService.findAll();
    }

    @GetMapping("/{id}")
    public Report getById(@PathVariable Long id) {
        return reportService.findById(id);
    }

    @PostMapping("/create")
    public Report create(@RequestBody Report report) {
        return reportService.create(report);
    }

    @PutMapping("/update")
    public Report update(@RequestBody Report report) {
        return reportService.update(report);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam Long id) {
        return reportService.delete(id);
    }
}
