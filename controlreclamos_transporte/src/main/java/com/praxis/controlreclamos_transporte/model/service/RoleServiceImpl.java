package com.praxis.controlreclamos_transporte.model.service;

import com.praxis.controlreclamos_transporte.model.entity.Role;
import com.praxis.controlreclamos_transporte.model.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public boolean create(Role role) {
        roleRepository.save(role);
        return true;
    }

    @Override
    public boolean update(Role role) {
        if (roleRepository.existsById(role.getId())) {
            roleRepository.save(role);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        boolean exist = roleRepository.existsById(id);
        if (exist){
            roleRepository.deleteById(id);
        }
        return exist;
    }
}