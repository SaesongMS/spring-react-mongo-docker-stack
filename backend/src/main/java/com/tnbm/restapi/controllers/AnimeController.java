package com.tnbm.restapi.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tnbm.restapi.models.animes.Anime;
import com.tnbm.restapi.services.AnimeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/anime")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping("top_api")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getTop100Anime_API() throws InterruptedException {
        return ResponseEntity.ok().body(animeService.getTop100Anime_API());
    }

    @GetMapping("top_db")
    public ResponseEntity<List<?>> getTop100Anime_DB() {
        return ResponseEntity.ok().body(animeService.getTop100Anime_DB());
    }

    @GetMapping("animes-by-genre")
    public ResponseEntity<List<?>> getAnimesByGenre(@RequestBody Map<String, String> requestBody) {
        return ResponseEntity.ok().body(animeService.getAnimesByGenre(requestBody.get("genre")));
    }

    @GetMapping("top3")
    public ResponseEntity<List<Anime>> getTop3() {
        return ResponseEntity.ok().body(animeService.getTop3());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("addJSON")
    public ResponseEntity<?> addJSON(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok().body(animeService.addJSON(file));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("getJSON")
    public ResponseEntity<?> getJSON() {
        return ResponseEntity.ok().body(animeService.getJSON());
    }

}
