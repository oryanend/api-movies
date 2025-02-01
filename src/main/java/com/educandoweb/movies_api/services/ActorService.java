package com.educandoweb.movies_api.services;

import com.educandoweb.movies_api.entities.Actor;
import com.educandoweb.movies_api.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> findAll(){
        return actorRepository.findAll();
    }

    public Actor findById(Long id){
        Optional<Actor> actor = actorRepository.findById(id);
        return actor.orElse(null);
    }

    public Actor insert(Actor actor){
        return actorRepository.save(actor);
    }
}
