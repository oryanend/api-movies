package com.educandoweb.movies_api.repositories;

import com.educandoweb.movies_api.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
