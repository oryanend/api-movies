package com.educandoweb.movies_api.config;

import com.educandoweb.movies_api.entities.Category;
import com.educandoweb.movies_api.entities.Movie;
import com.educandoweb.movies_api.repositories.CategoryRepository;
import com.educandoweb.movies_api.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate realeaseDate = LocalDate.parse("20/12/2003",fmt);
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category category = new Category(null, "Terror");
        Movie movie = new Movie(null, "Test", "Descrição", realeaseDate, 12.4, category);


        categoryRepository.save(category);
        movieRepository.save(movie);
    }
}
