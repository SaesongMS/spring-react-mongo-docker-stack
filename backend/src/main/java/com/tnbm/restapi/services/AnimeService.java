package com.tnbm.restapi.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.lang.Thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tnbm.restapi.models.animes.Anime;

import com.tnbm.restapi.models.animes.RootAnime;
import com.tnbm.restapi.models.animes.Top_Genres_Anime;
import com.tnbm.restapi.repository.AnimeGenreRepository;
import com.tnbm.restapi.repository.AnimeRepository;

@Service
public class AnimeService {
    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private AnimeGenreRepository genreRepository;

    public List<Top_Genres_Anime> getTop100Anime_API() throws InterruptedException {
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

        List<Top_Genres_Anime> genresList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : genres.entrySet()) {
            Top_Genres_Anime genre = new Top_Genres_Anime();
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

        return genresList;
    }

    public List<Top_Genres_Anime> getTop100Anime_DB() {
        return genreRepository.findAll();
    }

    public List<Anime> getAnimesByGenre(String genre) {
        List<Anime> allAnimes = animeRepository.findByGenresName(genre);
        List<Anime> animes = new ArrayList<>();

        for (Anime anime : allAnimes) {
            if (anime.getGenres().get(0).getName().equals(genre)) {
                animes.add(anime);
            }
        }

        return animes;
    }

    public List<Anime> getTop3() {
        List<Anime> allAnime = animeRepository.findAll();
        Collections.sort(allAnime, (a, b) -> {
            Integer rankA = (a.getRank() != null) ? a.getRank() : 0;
            Integer rankB = (b.getRank() != null) ? b.getRank() : 0;
            return rankB.compareTo(rankA);
        });
        return allAnime.subList(0, 3);
    }

    public String addJSON(MultipartFile file) {
        if (!file.isEmpty()) {
            List<Anime> animes = new ArrayList<>();
            try {
                String json = new String(file.getBytes());
                animes = new ObjectMapper().readValue(json, new TypeReference<List<Anime>>() {
                });
                animeRepository.deleteAll();
                animeRepository.insert(animes);
                return "Success";
            } catch (IOException e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }
        return "File is empty";
    }

    public List<Anime> getJSON() {
        return animeRepository.findAll();
    }

}
