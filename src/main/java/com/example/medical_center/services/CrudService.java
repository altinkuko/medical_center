package com.example.medical_center.services;

import java.util.List;

public interface CrudService<T, I, S> {
    T create(T entity);
    T update(T entity);
    T findById(I id);
    List<T> findAll();
    S delete(I id);
}
