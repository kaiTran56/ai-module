package com.tranquyet.repository;


import com.tranquyet.dto.Comment;
import reactor.core.publisher.Flux;

public interface CommentRepository {

    Flux<Comment> findAll();

}
