package com.praxis.controlreclamos_transporte.model.repository;

import com.praxis.controlreclamos_transporte.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}