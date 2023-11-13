package com.tnbm.restapi.UnitTests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tnbm.restapi.controllers.MovieController;
import com.tnbm.restapi.services.MovieService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(MovieController.class)
@WithMockUser(username = "user", password = "password", roles = "USER")
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    @WithMockUser(roles = "ADMIN")
    void testGetTop250_Api() throws Exception {
        when(movieService.GetTop250_Api()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/api/movies/top_api"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    @WithMockUser()
    void testGetTop250_Db() throws Exception {
        when(movieService.GetTop250_Db()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/api/movies/top_db"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void testGetMoviesByGenre() throws Exception {
        when(movieService.GetMoviesByGenre("Action")).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/api/movies/movies-by-genre")
                .param("genre", "Action"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void testGetTop3() throws Exception {
        when(movieService.GetTop3()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/api/movies/top3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
