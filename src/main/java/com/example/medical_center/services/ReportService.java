package com.example.medical_center.services;

import com.example.medical_center.dao.Report;

import java.util.List;

public interface ReportService{
    Report create(Report entity);
    Report update(Report entity);
    Report findById(Long id);
    List<Report> findAll();
    String delete(Long id);
}
