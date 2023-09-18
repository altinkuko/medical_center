package com.example.medical_center.repositories;

import com.example.medical_center.dao.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
