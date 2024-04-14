package com.udemynelio.course.resources;

import com.udemynelio.course.entities.User;
import com.udemynelio.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/ws-users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findByIdUser(@PathVariable Long id) {
        var user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/save")
    public ResponseEntity<User> insertUser(@RequestBody User entity) {
        var user = service.insert(entity);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).body(user);
    }
}
