package com.tnbm.restapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.tnbm.restapi.models.animes.Top_Genres_Anime;

public interface AnimeGenreRepository extends MongoRepository<Top_Genres_Anime, Integer> {

}
