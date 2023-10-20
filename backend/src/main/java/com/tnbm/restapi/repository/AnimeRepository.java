package com.tnbm.restapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tnbm.restapi.models.animes.Anime;

public interface AnimeRepository extends MongoRepository<Anime, String> {
    List<Anime> findByGenresName(String genre);
}
