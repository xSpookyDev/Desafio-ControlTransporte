package com.praxis.controlreclamos_transporte.model.service;

import com.praxis.controlreclamos_transporte.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    boolean create(User user);
    boolean update(User user);
    boolean delete(Integer id);
}