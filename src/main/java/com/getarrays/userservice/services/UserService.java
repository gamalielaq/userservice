package com.getarrays.userservice.services;

import java.util.List;

import com.getarrays.userservice.models.Role;
import com.getarrays.userservice.models.User;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolName);
    User getUser(String username);
    List<User>getusers();
}
