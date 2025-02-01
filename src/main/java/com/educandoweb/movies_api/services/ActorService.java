package com.educandoweb.movies_api.services;

import com.educandoweb.movies_api.entities.Actor;
import com.educandoweb.movies_api.repositories.ActorRepository;
import com.educandoweb.movies_api.services.exceptions.DatabaseException;
import com.educandoweb.movies_api.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return actor.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Actor insert(Actor actor){
        return actorRepository.save(actor);
    }

    public void delete(Long id){
        try {
            actorRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    private void updateDate(Actor entity, Actor obj){
        entity.setName(obj.getName());
        entity.setBirthday(obj.getBirthday());
        entity.setNacionality(obj.getNacionality());
    }

    public Actor update(Long id,Actor actor){
        Actor entity = actorRepository.getReferenceById(id);
        updateDate(entity, actor);
        return actorRepository.save(entity);
    }
}
