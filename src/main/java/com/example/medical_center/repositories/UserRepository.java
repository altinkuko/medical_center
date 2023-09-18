package com.example.medical_center.repositories;

import com.example.medical_center.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
