package com.tnbm.restapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tnbm.restapi.models.Genres;
import com.tnbm.restapi.models.movies.Movie;

import io.jsonwebtoken.io.IOException;

@Service
public class MovieService {
    


    public List<Genres> GetTop250_Api() throws IOException {
       return null;
    }

    public List<Genres> GetTop250_Db() {
        return null;
    }

    public List<Movie> GetMoviesByGenre(String genre) {
        return null;
    }

    public List<Movie> GetTop3() {
        return null;
    }

}
