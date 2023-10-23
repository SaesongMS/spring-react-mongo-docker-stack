package com.tnbm.restapi.UnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tnbm.restapi.models.Genres;
import com.tnbm.restapi.models.movies.Movie;
import com.tnbm.restapi.models.movies.MovieGenres;
import com.tnbm.restapi.models.movies.MovieGenresItem;
import com.tnbm.restapi.models.movies.MovieTitleText;
import com.tnbm.restapi.repository.GenreRepository;
import com.tnbm.restapi.repository.MovieRepository;
import com.tnbm.restapi.services.MovieService;

public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private GenreRepository genreRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetTop250_Db() {
        // Arrange
        List<Genres> genres = new ArrayList<>();
        genres.add(new Genres("Action", 2));
        when(genreRepository.findAll()).thenReturn(genres);

        // Act
        List<Genres> result = movieService.GetTop250_Db();

        // Assert
        verify(genreRepository, times(1)).findAll();
        assertEquals(1, result.size());
        assertEquals("Action", result.get(0).getName());
        assertEquals(2, result.get(0).getValue());
    }

    @Test
    public void testGetMoviesByGenre() {
        // Arrange
        MovieTitleText titleText = new MovieTitleText();
        titleText.setText("Movie 1");
        MovieTitleText titleText2 = new MovieTitleText();
        titleText2.setText("Movie 2");
        MovieGenresItem genre = new MovieGenresItem();
        genre.setText("Action");
        genre.setId("Action");
        genre.set__typename("Genre");
        MovieGenres genres = new MovieGenres();
        genres.setGenres(Arrays.asList(genre));
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie();
        movie1.setTitleText(titleText);
        movie1.setGenres(genres);
        Movie movie2 = new Movie();
        movie2.setTitleText(titleText2);
        movie2.setGenres(genres);
        movies.add(movie1);
        movies.add(movie2);
        when(movieRepository.findAll()).thenReturn(movies);

        // Act
        List<Movie> result = movieService.GetMoviesByGenre("Action");

        // Assert
        verify(movieRepository, times(1)).findAll();
        assertEquals(2, result.size());
        assertEquals("Movie 1", result.get(0).getTitleText().getText());
    }

    @Test
    public void testGetTop3() {
        // Arrange
        MovieTitleText titleText = new MovieTitleText();
        titleText.setText("Movie 1");
        MovieTitleText titleText2 = new MovieTitleText();
        titleText2.setText("Movie 2");
        MovieTitleText titleText3 = new MovieTitleText();
        titleText3.setText("Movie 3");
        List<Movie> movies = new ArrayList<>();
        Movie movie1 = new Movie();
        movie1.setTitleText(titleText);
        movie1.setPosition(1);
        Movie movie2 = new Movie();
        movie2.setTitleText(titleText2);
        movie2.setPosition(2);
        Movie movie3 = new Movie();
        movie3.setTitleText(titleText3);
        movie3.setPosition(3);
        movies.add(movie2);
        movies.add(movie1);
        movies.add(movie3);
        when(movieRepository.findAll()).thenReturn(movies);

        // Act
        List<Movie> result = movieService.GetTop3();

        // Assert
        verify(movieRepository, times(1)).findAll();
        assertEquals(3, result.size());
        assertEquals("Movie 1", result.get(0).getTitleText().getText());
        assertEquals("Movie 2", result.get(1).getTitleText().getText());
        assertEquals("Movie 3", result.get(2).getTitleText().getText());
    }
}