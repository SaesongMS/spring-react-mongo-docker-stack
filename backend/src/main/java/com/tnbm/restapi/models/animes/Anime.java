package com.tnbm.restapi.models.animes;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "anime")
public class Anime {
  @Id
  private String _id;
  private Integer mal_id;
  private String url;
  private Images images;
  private Trailer trailer;
  private boolean approved;
  private List<Title> titles;
  private String title;
  private String title_english;
  private String title_japanese;
  private List<String> title_synonyms;
  private String type;
  private String source;
  private Integer episodes;
  private String status;
  private boolean airing;
  private Aired aired;
  private String duration;
  private String rating;
  private double score;
  private Integer scored_by;
  private Integer rank;
  private Integer popularity;
  private Integer members;
  private Integer favorites;
  private String synopsis;
  private String background;
  private String season;
  private Integer year;
  private Broadcast broadcast;
  private List<Producer> producers;
  private List<Licensor> licensors;
  private List<Studio> studios;
  private List<Genre> genres;
  private List<ExplicitGenre> explicit_genres;
  private List<Theme> themes;
  private List<Demographic> demographics;
}
