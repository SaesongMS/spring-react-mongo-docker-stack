package com.tnbm.restapi.IntegrationTests;

import com.tnbm.restapi.models.animes.Anime;
import com.tnbm.restapi.services.AnimeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AnimeTest {
   @Autowired
   private MockMvc mockMvc;

   @MockBean
   private AnimeService animeService;

   public AnimeTest() {
   }

   @Test
   @WithMockUser(
      username = "test",
      roles = {"USER"}
   )
   public void testGetTop3() throws Exception {
      List<Anime> animeList = animeService.getTop3();
      this.mockMvc.perform(MockMvcRequestBuilders.get("/api/anime/top3", new Object[0])).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(animeList.size())));
   }

   @Test
   public void testAddJSON() throws Exception {
      MockMultipartFile file = new MockMultipartFile("file", "test.json", "application/json", "{\"title\":\"Test Anime\",\"genre\":\"test\"}".getBytes());
      this.mockMvc.perform(MockMvcRequestBuilders.multipart("/api/anime/addJSON", new Object[0]).file(file).with(SecurityMockMvcRequestPostProcessors.user("admin").roles(new String[]{"ADMIN"}))).andExpect(MockMvcResultMatchers.status().isOk());
   }

   @Test
   public void testGetJSON() throws Exception {
      this.mockMvc.perform(MockMvcRequestBuilders.get("/api/anime/getJSON", new Object[0]).with(SecurityMockMvcRequestPostProcessors.user("admin").roles(new String[]{"ADMIN"}))).andExpect(MockMvcResultMatchers.status().isOk());
   }

   @Test
   public void testGetJSONAsUser() throws Exception {
      this.mockMvc.perform(MockMvcRequestBuilders.get("/api/anime/getJSON", new Object[0])
        .with(SecurityMockMvcRequestPostProcessors.user("user").roles(new String[]{"USER"})))
        .andExpect(MockMvcResultMatchers.status().isForbidden());
   }
}
