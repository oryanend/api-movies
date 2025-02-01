package com.educandoweb.movies_api.resources;

import com.educandoweb.movies_api.entities.Actor;
import com.educandoweb.movies_api.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Actor> insert(@RequestBody Actor actor){
        actor = actorService.insert(actor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(actor.getId()).toUri();
        return ResponseEntity.created(uri).body(actor);
    }

    public ResponseEntity<Void> delete(@PathVariable Long id){
        actorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
