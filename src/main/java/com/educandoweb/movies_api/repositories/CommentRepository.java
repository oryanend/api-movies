package com.educandoweb.movies_api.repositories;

import com.educandoweb.movies_api.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
