package com.example.medical_center.services.impl;

import com.example.medical_center.dao.User;
import com.example.medical_center.exceptions.GenericExceptions;
import com.example.medical_center.repositories.UserRepository;
import com.example.medical_center.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User entity) {
        if (entity.getUserId() != null){
            throw GenericExceptions.idNotNull();
        } else {
            userRepository.save(entity);
            return entity;
        }
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
