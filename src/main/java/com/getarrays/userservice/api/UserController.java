package com.getarrays.userservice.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.getarrays.userservice.models.Role;
import com.getarrays.userservice.models.User;
import com.getarrays.userservice.services.UserService;

import lombok.Data;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(this.userService.getusers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toString());
        return ResponseEntity.created(uri).body(this.userService.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toString());
        return ResponseEntity.created(uri).body(this.userService.saveRole(role));
    }

    @PostMapping("/role/addToUser")
    public ResponseEntity<?> addRolTouser(@RequestBody RoleToUserForm form) {
        this.userService.addRoleToUser(form.getUsername(),form.getRolname());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleToUserForm {
    private String username;
    private String rolname;
}
