package com.example.medical_center.repositories;

import com.example.medical_center.dao.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("select a from Appointment a where a.doctor.doctorId = :doctorId and a.beginsAt > :now or a.endsAt > :now")
    List<Appointment> getByDoctorAndAfter(@Param("doctorId") Long doctorId, @Param("now") LocalDateTime localDateTime);

}
