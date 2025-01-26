package com.educandoweb.movies_api.services;

import com.educandoweb.movies_api.entities.Movie;
import com.educandoweb.movies_api.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public Movie findById(Long id){
        Optional<Movie> obj = movieRepository.findById(id);
        return obj.get();
    }
}
