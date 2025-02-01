package com.educandoweb.movies_api.services;

import com.educandoweb.movies_api.entities.Category;
import com.educandoweb.movies_api.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }

    public Category insert(Category category){
        return categoryRepository.save(category);
    }
}
