package com.udemynelio.course.config;

import com.udemynelio.course.entities.User;
import com.udemynelio.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class ProfileTestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User userOne = new User(null, "Alyasaf", "aly@email.com.br", "(61)993021918", "*****");
        User userTwo = new User(null, "Thaina", "thai@email.com.br", "(61)991122970", "***");

        repository.saveAll(Arrays.asList(userOne, userTwo));
    }
}
