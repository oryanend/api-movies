package com.educandoweb.movies_api.resources;

import com.educandoweb.movies_api.entities.Movie;
import com.educandoweb.movies_api.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll(){
        List<Movie> movies = movieService.findAll();
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Long id){
        Movie movie = movieService.findById(id);
        return ResponseEntity.ok().body(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> insert(@RequestBody Movie movie){
        movie = movieService.insert(movie);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movie.getId()).toUri();
        return ResponseEntity.created(uri).body(movie);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
