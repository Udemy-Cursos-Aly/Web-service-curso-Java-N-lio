package com.udemynelio.course.services;

import com.udemynelio.course.entities.User;
import com.udemynelio.course.exceptions.resource.ResourceExceptionHandler;
import com.udemynelio.course.exceptions.service.ServiceException;
import com.udemynelio.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ServiceException("User not found with id: ", id));
    }

    @Transactional
    public User insert(User entity) {
        return repository.save(entity);
    }

    @Transactional
    public User update(Long id, User entity) {
        var user = repository.getReferenceById(id);
        updateData(entity, user);
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void updateData(User entity, User user) {
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setPhone(entity.getPhone());
    }
}
