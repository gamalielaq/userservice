package com.getarrays.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getarrays.userservice.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
        
    Role findByname(String name);
}
