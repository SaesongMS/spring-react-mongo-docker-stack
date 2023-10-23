package com.tnbm.restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tnbm.restapi.models.movies.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {
    
}
