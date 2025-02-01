package com.educandoweb.movies_api.services;

import com.educandoweb.movies_api.entities.Category;
import com.educandoweb.movies_api.repositories.CategoryRepository;
import com.educandoweb.movies_api.services.exceptions.DatabaseException;
import com.educandoweb.movies_api.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Category insert(Category category){
        return categoryRepository.save(category);
    }

    public void delete(Long id){
      try {
          categoryRepository.deleteById(id);
      } catch (EmptyResultDataAccessException e){
          throw new ResourceNotFoundException(id);
      } catch (DataIntegrityViolationException e){
          throw new DatabaseException(e.getMessage());
      }
    }

    private void updateDate(Category entity, Category obj){
        entity.setName(obj.getName());
    }

    public Category update(Long id,Category category){
        try{
            Category entity = categoryRepository.getReferenceById(id);
            updateDate(entity, category);
            return categoryRepository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }
}
