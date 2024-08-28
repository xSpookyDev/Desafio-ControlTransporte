package com.praxis.controlreclamos_transporte.model.repository;

import com.praxis.controlreclamos_transporte.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}