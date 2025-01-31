package com.educandoweb.movies_api.repositories;

import com.educandoweb.movies_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
