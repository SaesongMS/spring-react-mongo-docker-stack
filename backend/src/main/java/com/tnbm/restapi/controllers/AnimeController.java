package com.tnbm.restapi.controllers;

import java.util.Optional;
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
import com.tnbm.restapi.models.RootAnime;
import com.tnbm.restapi.payload.response.MessageResponse;
import com.tnbm.restapi.repository.AnimeRepository;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/anime")
public class AnimeController {

    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping("/read/all")
    public ResponseEntity<List<Anime>> getAllAnime() {
        return ResponseEntity.ok().body(animeRepository.findAll());
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Optional<Anime>> getOneAnime(@PathVariable Integer id) {
        return ResponseEntity.ok().body(animeRepository.findById(id));
    }

    @GetMapping("/top_api")
    public ResponseEntity<?> getTop100Anime_API() throws InterruptedException {
        String uri = "https://api.jikan.moe/v4/top/anime?page=";
        RestTemplate restTemplate = new RestTemplate();
        RootAnime items;
        ResponseEntity<RootAnime> response = null;
        Map<String, Integer> genres = new HashMap<>();
        for (int i = 1; i < 5; i++) {
            String url = uri + i;
            response = restTemplate.getForEntity(url, RootAnime.class);
            // response.getBody().getData().forEach(anime -> {
            // animeRepository.save(anime);
            // });
            System.out.println(response.getBody().getData());
            if (i == 3) {
                Thread.sleep(1000);
            }
        }
        if (response != null)
            return response;
        else
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Cannot get top 100 anime from API"));
    }

}
