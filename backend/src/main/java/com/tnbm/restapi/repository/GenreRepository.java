package com.tnbm.restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tnbm.restapi.models.Genres;

public interface GenreRepository extends MongoRepository<Genres, Integer> {

}
