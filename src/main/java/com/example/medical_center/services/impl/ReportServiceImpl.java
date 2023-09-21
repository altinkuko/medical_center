package com.example.medical_center.services.impl;

import com.example.medical_center.dao.Report;
import com.example.medical_center.exceptions.GenericExceptions;
import com.example.medical_center.repositories.ReportRepository;
import com.example.medical_center.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    @Override
    public Report create(Report entity) {
        if (entity.getReportId() != null){
            throw GenericExceptions.idNotNull();
        } else {
            reportRepository.save(entity);
            return entity;
        }
    }

    @Override
    public Report update(Report entity) {
        if (entity.getReportId() == null){
            throw GenericExceptions.idIsNull();
        } else {
            reportRepository.save(entity);
            return entity;
        }
    }

    @Override
    public Report findById(Long id) {
        Optional<Report> report = reportRepository.findById(id);
        return report.orElseThrow(()-> GenericExceptions.notFound(id));
    }

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        reportRepository.deleteById(id);
        return String.format("Record with id %d deleted", id);
    }
}
