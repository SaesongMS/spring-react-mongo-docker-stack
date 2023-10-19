package com.tnbm.restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tnbm.restapi.models.Anime;

public interface AnimeRepository extends MongoRepository<Anime, String> {
}
