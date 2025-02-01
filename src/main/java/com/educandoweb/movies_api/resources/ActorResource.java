package com.educandoweb.movies_api.resources;

import com.educandoweb.movies_api.entities.Actor;
import com.educandoweb.movies_api.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/actors")
public class ActorResource {
    @Autowired
    private ActorService actorService;

    @GetMapping
    public ResponseEntity<List<Actor>> findAll(){
        List<Actor> actors = actorService.findAll();
        return ResponseEntity.ok().body(actors);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Actor> findById(@PathVariable Long id){
        Actor actor = actorService.findById(id);
        return ResponseEntity.ok().body(actor);
    }


}
