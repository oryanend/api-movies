package com.educandoweb.movies_api.repositories;

import com.educandoweb.movies_api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
