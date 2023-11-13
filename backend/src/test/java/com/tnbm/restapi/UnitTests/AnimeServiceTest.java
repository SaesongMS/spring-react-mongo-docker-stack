package com.tnbm.restapi.UnitTests;

import com.tnbm.restapi.models.animes.Anime;
import com.tnbm.restapi.models.animes.Genre;
import com.tnbm.restapi.models.animes.Top_Genres_Anime;
import com.tnbm.restapi.repository.AnimeGenreRepository;
import com.tnbm.restapi.repository.AnimeRepository;
import com.tnbm.restapi.services.AnimeService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

@RunWith(MockitoJUnitRunner.class)
public class AnimeServiceTest {
   @Mock
   private AnimeRepository animeRepository;
   @Mock
   private AnimeGenreRepository genreRepository;
   @InjectMocks
   private AnimeService animeService;

   public AnimeServiceTest() {
   }

   @Test
   public void testGetTop100Anime_API() throws Exception {
        List<Top_Genres_Anime> genresList = this.animeService.getTop100Anime_API();
        Assert.assertTrue((long)genresList.size()>0);
        Assert.assertEquals("Action", ((Top_Genres_Anime)genresList.get(0)).getName());
        Assert.assertTrue(((Top_Genres_Anime)genresList.get(0)).getValue() > 0);
        ((AnimeRepository)Mockito.verify(this.animeRepository, Mockito.times(1))).deleteAll();
        ((AnimeRepository)Mockito.verify(this.animeRepository, Mockito.times(1))).insert(Mockito.anyList());
        ((AnimeGenreRepository)Mockito.verify(this.genreRepository, Mockito.times(1))).deleteAll();
        ((AnimeGenreRepository)Mockito.verify(this.genreRepository, Mockito.times(1))).insert(Mockito.anyList());
   }

   @Test
   public void testGetTop100Anime_DB() throws Exception {
      List<Top_Genres_Anime> genresList = new ArrayList();
      Top_Genres_Anime genre1 = new Top_Genres_Anime();
      genre1.setName("Action");
      genre1.setValue(10);
      Top_Genres_Anime genre2 = new Top_Genres_Anime();
      genre2.setName("Comedy");
      genre2.setValue(5);
      genresList.add(genre1);
      genresList.add(genre2);
      Mockito.when(this.genreRepository.findAll()).thenReturn(genresList);
      List<Top_Genres_Anime> result = this.animeService.getTop100Anime_DB();
      Assert.assertEquals(2L, (long)result.size());
      Assert.assertEquals("Action", ((Top_Genres_Anime)result.get(0)).getName());
      Assert.assertEquals(10L, (long)((Top_Genres_Anime)result.get(0)).getValue());
      Assert.assertEquals("Comedy", ((Top_Genres_Anime)result.get(1)).getName());
      Assert.assertEquals(5L, (long)((Top_Genres_Anime)result.get(1)).getValue());
      ((AnimeGenreRepository)Mockito.verify(this.genreRepository, Mockito.times(1))).findAll();
   }

   @Test
   public void testGetAnimesByGenre() throws Exception {
      List<Anime> animeList = new ArrayList();
      Anime anime1 = new Anime();
      anime1.setTitle("Anime 1");
      anime1.setGenres(Collections.singletonList(new Genre("Action")));
      Anime anime2 = new Anime();
      anime2.setTitle("Anime 2");
      anime2.setGenres(Collections.singletonList(new Genre("Comedy")));
      Anime anime3 = new Anime();
      anime3.setTitle("Anime 3");
      anime3.setGenres(Arrays.asList(new Genre("Action"), new Genre("Comedy")));
      animeList.add(anime1);
      animeList.add(anime2);
      animeList.add(anime3);
      Mockito.when(this.animeRepository.findByGenresName(Mockito.anyString())).thenReturn(animeList);
      List<Anime> result = this.animeService.getAnimesByGenre("Action");
      Assert.assertEquals(2L, (long)result.size());
      Assert.assertEquals("Anime 1", ((Anime)result.get(0)).getTitle());
      Assert.assertEquals("Anime 3", ((Anime)result.get(1)).getTitle());
      ((AnimeRepository)Mockito.verify(this.animeRepository, Mockito.times(1))).findByGenresName(Mockito.anyString());
   }

   @Test
   public void testGetTop3() throws Exception {
      List<Anime> animeList = new ArrayList();
      Anime anime1 = new Anime();
      anime1.setTitle("Anime 1");
      anime1.setRank(4);
      Anime anime2 = new Anime();
      anime2.setTitle("Anime 2");
      anime2.setRank(3);
      Anime anime3 = new Anime();
      anime3.setTitle("Anime 3");
      anime3.setRank(2);
      Anime anime4 = new Anime();
      anime4.setTitle("Anime 4");
      anime4.setRank(1);
      animeList.add(anime1);
      animeList.add(anime2);
      animeList.add(anime3);
      animeList.add(anime4);
      Mockito.when(this.animeRepository.findAll()).thenReturn(animeList);
      List<Anime> result = this.animeService.getTop3();
      Assert.assertEquals(3L, (long)result.size());
      Assert.assertEquals("Anime 1", ((Anime)result.get(0)).getTitle());
      Assert.assertEquals("Anime 2", ((Anime)result.get(1)).getTitle());
      Assert.assertEquals("Anime 3", ((Anime)result.get(2)).getTitle());
      ((AnimeRepository)Mockito.verify(this.animeRepository, Mockito.times(1))).findAll();
   }

   @Test
   public void testAddJSON() throws Exception {
      MultipartFile file = (MultipartFile)Mockito.mock(MultipartFile.class);
      Mockito.when(file.isEmpty()).thenReturn(false);
      Mockito.when(file.getBytes()).thenReturn("[{\"id\":5114,\"title\":\"Fullmetal Alchemist: Brotherhood\",\"genres\":[{\"name\":\"Action\"},{\"name\":\"Adventure\"},{\"name\":\"Drama\"},{\"name\":\"Fantasy\"}],\"explicit_genres\":[],\"themes\":[{\"mal_id\":38,\"type\":\"anime\",\"name\":\"Military\",\"url\":\"https://myanimelist.net/anime/genre/38/Military\"}],\"demographics\":[{\"mal_id\":27,\"type\":\"anime\",\"name\":\"Shounen\",\"url\":\"https://myanimelist.net/anime/genre/27/Shounen\"}]}]".getBytes());
      String result = this.animeService.addJSON(file);
      Assert.assertEquals("Success", result);
      ArgumentCaptor<List<Anime>> captor = ArgumentCaptor.forClass(List.class);
      ((AnimeRepository)Mockito.verify(this.animeRepository, Mockito.times(1))).deleteAll();
      ((AnimeRepository)Mockito.verify(this.animeRepository, Mockito.times(1))).insert((Iterable)captor.capture());
      List<Anime> animeList = (List)captor.getValue();
      Assert.assertEquals(1L, (long)animeList.size());
      Assert.assertEquals("Fullmetal Alchemist: Brotherhood", ((Anime)animeList.get(0)).getTitle());
      Assert.assertEquals("Action", ((Genre)((Anime)animeList.get(0)).getGenres().get(0)).getName());
   }

   @Test
   public void testGetJSON() throws Exception {
      List<Anime> animeList = new ArrayList();
      Anime anime1 = new Anime();
      anime1.setTitle("Anime 1");
      Anime anime2 = new Anime();
      anime2.setTitle("Anime 2");
      animeList.add(anime1);
      animeList.add(anime2);
      Mockito.when(this.animeRepository.findAll()).thenReturn(animeList);
      List<Anime> result = this.animeService.getJSON();
      Assert.assertEquals(2L, (long)result.size());
      Assert.assertEquals("Anime 1", ((Anime)result.get(0)).getTitle());
      Assert.assertEquals("Anime 2", ((Anime)result.get(1)).getTitle());
      ((AnimeRepository)Mockito.verify(this.animeRepository, Mockito.times(1))).findAll();
   }
}
