package com.udemynelio.course.config;

import com.udemynelio.course.entities.Order;
import com.udemynelio.course.entities.User;
import com.udemynelio.course.entities.enums.OrderStatus;
import com.udemynelio.course.repositories.OrderRepository;
import com.udemynelio.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class ProfileTestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User userOne = new User(null, "Alyasaf", "aly@email.com.br", "(61)993021918", "*****");
        User userTwo = new User(null, "Thaina", "thai@email.com.br", "(61)991122970", "***");

        Order orderOne = new Order(null, Instant.parse("2024-06-05T19:53:07Z"), OrderStatus.WAITING_PAYMENT, userOne);
        Order orderTwo = new Order(null, Instant.parse("2024-05-20T03:42:10Z"), OrderStatus.SHIPPED, userTwo);
        Order orderThree = new Order(null, Instant.parse("2024-04-21T15:21:22Z"), OrderStatus.PAID, userOne);

        repository.saveAll(Arrays.asList(userOne, userTwo));
        orderRepository.saveAll(Arrays.asList(orderOne, orderTwo, orderThree));
    }
}
