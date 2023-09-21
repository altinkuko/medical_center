package com.example.medical_center.services.impl;

import com.example.medical_center.dao.User;
import com.example.medical_center.exceptions.GenericExceptions;
import com.example.medical_center.repositories.UserRepository;
import com.example.medical_center.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
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
        if (entity.getUserId() == null) {
            throw GenericExceptions.idIsNull();
        } else {
            userRepository.save(entity);
            return entity;
        }
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(()-> GenericExceptions.notFound(id));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public String delete(Long id) {
        userRepository.deleteById(id);
        return String.format("Record with id %d deleted", id);
    }
}
