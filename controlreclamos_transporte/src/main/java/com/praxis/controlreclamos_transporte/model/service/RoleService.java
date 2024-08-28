package com.praxis.controlreclamos_transporte.model.service;

import com.praxis.controlreclamos_transporte.model.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role findById(Integer id);
    boolean create(Role role);
    boolean update(Role role);
    boolean delete(Integer id);
}