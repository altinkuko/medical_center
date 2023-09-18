package com.example.medical_center.services;

import com.example.medical_center.dao.User;

import java.util.List;

public interface UserService {
    User create(User entity);

    User update(User entity);

    User findById(Long id);

    List<User> findAll();

    String delete(Long id);
}
