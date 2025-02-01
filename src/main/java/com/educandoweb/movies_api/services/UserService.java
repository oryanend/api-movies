package com.educandoweb.movies_api.services;

import com.educandoweb.movies_api.entities.User;
import com.educandoweb.movies_api.repositories.UserRepository;
import com.educandoweb.movies_api.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    private void updateDate(User entity, User obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPassword(obj.getPassword());
    }

    public User update(Long id, User user){
        User entity = userRepository.getReferenceById(id);
        updateDate(entity, user);
        return userRepository.save(entity);
    }
}
