package com.tnbm.restapi.controllers;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tnbm.restapi.models.Genres;
import com.tnbm.restapi.models.movies.Movie;
import com.tnbm.restapi.services.MovieService;

// @CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/top_api")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> GetTop250_Api() throws IOException {
        return ResponseEntity.ok().body(movieService.GetTop250_Api());
    }

    @GetMapping("/top_db")
    public ResponseEntity<List<Genres>> GetTop250_Db() {
        return ResponseEntity.ok().body(movieService.GetTop250_Db());
    }

    @GetMapping("/movies-by-genre")
    public ResponseEntity<List<Movie>> GetMoviesByGenre(String genre) {
        return ResponseEntity.ok().body(movieService.GetMoviesByGenre(genre));
    }

    @GetMapping("top3")
    public ResponseEntity<List<Movie>> GetTop3() {
        return ResponseEntity.ok().body(movieService.GetTop3());
    }


}
