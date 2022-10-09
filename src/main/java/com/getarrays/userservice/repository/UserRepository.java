package com.getarrays.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.getarrays.userservice.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    

}
