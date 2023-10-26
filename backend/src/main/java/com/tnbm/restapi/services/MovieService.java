package com.tnbm.restapi.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tnbm.restapi.models.Genres;
import com.tnbm.restapi.models.movies.Movie;
import com.tnbm.restapi.models.movies.MovieRoot;
import com.tnbm.restapi.repository.GenreRepository;
import com.tnbm.restapi.repository.MovieRepository;


@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GenreRepository genreRepository;

    @Value("${movie.api.uri}")
    private String uri;

    @Value("${movie.api.key}")
    private String key;

    @Value("${movie.api.host}")
    private String host;

    public List<Genres> GetTop250_Api() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidApi-Key", key);
        headers.set("X-RapidApi-Host", host);
        RestTemplate restTemplate = new RestTemplate();
        MovieRoot items;
        Map<String, Integer> genres = new HashMap<>();
        List<Movie> movies = new ArrayList<>();
        int i = 1;
        do {
            String url = uri + i;
            ResponseEntity<MovieRoot> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), MovieRoot.class);
            items = response.getBody();
            for (Movie item : items.getResults()) {
                String genre = item.getGenres().getGenres().get(0).getText();
                genres.put(genre, genres.getOrDefault(genre, 0) + 1);
                movies.add(item);
            }
            i++;
        } while (items.getNext() != null);

        List<Genres> genresList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : genres.entrySet()) {
            genresList.add(new Genres(entry.getKey(), entry.getValue()));
        }
        movies.sort(Comparator.comparingInt(x -> x.getPosition().intValue()));

        movieRepository.deleteAll();
        movieRepository.saveAll(movies);

        genreRepository.deleteAll();
        genreRepository.saveAll(genresList);

        return genresList;
    }

    public List<Genres> GetTop250_Db() {
        return genreRepository.findAll();
    }

    public List<Movie> GetMoviesByGenre(String genre) {
        List<Movie> movies = movieRepository.findAll();
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getGenres().getGenres().get(0).getText().equals(genre)) {
                result.add(movie);
            }
        }
        return result;
    }

    public List<Movie> GetTop3() {
        List<Movie> movies = movieRepository.findAll();
        movies.sort(Comparator.comparingInt(x -> x.getPosition().intValue()));
        return movies.subList(0, 3);
    }

}
