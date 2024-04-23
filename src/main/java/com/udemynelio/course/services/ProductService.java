package com.udemynelio.course.services;

import com.udemynelio.course.entities.Product;
import com.udemynelio.course.exceptions.service.ServiceException;
import com.udemynelio.course.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não existe esse produto: " + id));
    }

    @Transactional
    public Product insert(Product entity) {
        return repository.save(entity);
    }

    @Transactional
    public Product update(Long id, Product entity) {
        try {
            var product = repository.getReferenceById(id);
            updateData(entity, product);
            return repository.save(product);
        } catch (EntityNotFoundException ex) {
            throw new ServiceException("Product not found: ", id);
        }
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private static void updateData(Product entity, Product product) {
        product.setName(entity.getName());
        product.setDescription(entity.getDescription());
        product.setPrice(entity.getPrice());
        product.setImageURL(entity.getImageURL());
    }
}
