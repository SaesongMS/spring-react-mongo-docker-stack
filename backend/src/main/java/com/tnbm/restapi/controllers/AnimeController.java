package com.tnbm.restapi.controllers;

import java.util.Optional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.lang.Thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tnbm.restapi.models.Anime;
import com.tnbm.restapi.models.Genres;
import com.tnbm.restapi.models.RootAnime;
import com.tnbm.restapi.payload.response.MessageResponse;
import com.tnbm.restapi.repository.AnimeRepository;
import com.tnbm.restapi.repository.GenreRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/anime")
public class AnimeController {

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/read/all")
    public ResponseEntity<List<Anime>> getAllAnime() {
        return ResponseEntity.ok().body(animeRepository.findAll());
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Optional<Anime>> getOneAnime(@PathVariable String id) {
        return ResponseEntity.ok().body(animeRepository.findById(id));
    }

    @GetMapping("/top_api")
    public ResponseEntity<?> getTop100Anime_API() throws InterruptedException {
        String uri = "https://api.jikan.moe/v4/top/anime?page=";
        RestTemplate restTemplate = new RestTemplate();
        RootAnime items;
        ResponseEntity<RootAnime> response = null;
        Map<String, Integer> genres = new HashMap<>();
        List<Anime> animes = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            String url = uri + i;
            response = restTemplate.getForEntity(url, RootAnime.class);
            items = response.getBody();
            items.getData().forEach(item -> {
                if (item.getGenres().size() > 0) {
                    genres.merge(item.getGenres().get(0).getName(), 1, Integer::sum);
                }
                animes.add(item);
            });

            if (i == 3) {
                Thread.sleep(1000);
            }
        }

        List<Genres> genresList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : genres.entrySet()) {
            Genres genre = new Genres();
            genre.setName(entry.getKey());
            genre.setValue(entry.getValue());
            genresList.add(genre);
        }

        Collections.sort(animes, (a, b) -> {
            Integer rankA = (a.getRank() != null) ? a.getRank() : 0;
            Integer rankB = (b.getRank() != null) ? b.getRank() : 0;
            return rankA.compareTo(rankB);
        });

        animeRepository.deleteAll();
        animeRepository.insert(animes);

        genreRepository.deleteAll();
        genreRepository.insert(genresList);

        if (response != null)
            return response;
        else
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Cannot get top 100 anime from API"));
    }

}
