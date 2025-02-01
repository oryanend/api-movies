package com.educandoweb.movies_api.config;

import com.educandoweb.movies_api.entities.Actor;
import com.educandoweb.movies_api.entities.Category;
import com.educandoweb.movies_api.entities.Comment;
import com.educandoweb.movies_api.entities.Movie;
import com.educandoweb.movies_api.repositories.CategoryRepository;
import com.educandoweb.movies_api.repositories.CommentRepository;
import com.educandoweb.movies_api.repositories.MovieRepository;
import com.educandoweb.movies_api.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate realeaseDate = LocalDate.parse("20/12/2003",fmt);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category = new Category(null, "Terror");

        Movie movie = new Movie(null, "Test", "Descrição", realeaseDate, 12.4, category);

        Actor actor = new Actor(null, "Ryan", realeaseDate, "Brasileiro");

        Comment comment = new Comment(null, "ASADA", actor, Instant.now(), movie);

        categoryRepository.save(category);
        movieRepository.saveAll(Arrays.asList(movie));
        actorRepository.save(actor);
        commentRepository.save(comment);
    }
}
