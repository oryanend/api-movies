package com.educandoweb.movies_api.repositories;

import com.educandoweb.movies_api.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {

}
