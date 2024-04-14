package com.udemynelio.course.config;

import com.udemynelio.course.entities.*;
import com.udemynelio.course.entities.enums.OrderStatus;
import com.udemynelio.course.repositories.*;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User userOne = new User(null, "Alyasaf", "aly@email.com.br", "(61)993021918", "*****");
        User userTwo = new User(null, "Thaina", "thai@email.com.br", "(61)991122970", "***");

        Order orderOne = new Order(null, Instant.parse("2024-06-05T19:53:07Z"), OrderStatus.WAITING_PAYMENT, userOne);
        Order orderTwo = new Order(null, Instant.parse("2024-05-20T03:42:10Z"), OrderStatus.SHIPPED, userTwo);
        Order orderThree = new Order(null, Instant.parse("2024-04-21T15:21:22Z"), OrderStatus.PAID, userOne);

        Category categoryOne = new Category(null, "Games");
        Category categoryTwo = new Category(null, "Eletrônicos");
        Category categoryThree = new Category(null, "Livros");

        Product productOne = new Product(null, "TV4K", "TV TCL 4K 50 polegadas", 2190.0, "");
        Product productTwo = new Product(null, "Iphone", "Iphone 14 PRO Max", 7295.0, "");
        Product productThree = new Product(null, "Air fryer", "Air fryer para frituras", 450.55, "");
        Product productFor = new Product(null, "Xbox", "Console Xbox Series S", 2590.0, "");
        Product productFive = new Product(null, "Harry Potter", "Ebook Harry Potter e o enigma do princípe", 120.90, "");

        OrderItem orderItemOne = new OrderItem(orderOne, productOne, 2, productOne.getPrice());
        OrderItem orderItemTwo = new OrderItem(orderOne, productThree, 1, productThree.getPrice());
        OrderItem orderItemThree = new OrderItem(orderTwo, productThree, 2, productThree.getPrice());
        OrderItem orderItemFor = new OrderItem(orderThree, productFive, 2, productFive.getPrice());

        repository.saveAll(Arrays.asList(userOne, userTwo));
        orderRepository.saveAll(Arrays.asList(orderOne, orderTwo, orderThree));
        categoryRepository.saveAll(Arrays.asList(categoryOne, categoryTwo, categoryThree));
        productRepository.saveAll(Arrays.asList(productOne, productTwo, productThree, productFor, productFive));

        productOne.getCategories().add(categoryTwo);
        productTwo.getCategories().add(categoryTwo);
        productThree.getCategories().add(categoryTwo);
        productFor.getCategories().add(categoryOne);
        productFive.getCategories().add(categoryThree);

        productRepository.saveAll(Arrays.asList(productOne, productTwo, productThree, productFor, productFive));
        orderItemRepository.saveAll(Arrays.asList(orderItemOne, orderItemTwo, orderItemThree, orderItemFor));
    }
}
