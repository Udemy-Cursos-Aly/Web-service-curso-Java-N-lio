package com.udemynelio.course.resources;

import com.udemynelio.course.entities.Category;
import com.udemynelio.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/ws-categories")
public class CategoryResource {
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategories() {
        List<Category> categories = service.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findByIdCategory(@PathVariable Long id) {
        var category = service.findById(id);
        return ResponseEntity.ok().body(category);
    }
}
