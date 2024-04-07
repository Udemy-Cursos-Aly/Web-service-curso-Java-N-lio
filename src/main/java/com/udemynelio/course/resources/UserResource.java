package com.udemynelio.course.resources;

import com.udemynelio.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ws-users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAllUsers() {
        User user = new User(1L, "Alyasaf", "curso@email.com", "(61)99302-1918", "******");
        return ResponseEntity.ok().body(user);
    }
}
