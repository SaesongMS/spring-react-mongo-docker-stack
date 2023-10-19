package com.tnbm.restapi.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "anime")
public class Anime {
  @Id
  private Integer id;
  private Integer mal_id = null;
  private String url = new String();
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

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Aired {
    private String from;
    private String to;
    private Prop prop;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Broadcast {
    private String day;
    private String time;
    private String timezone;
    private String string;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Demographic {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class ExplicitGenre {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class From {
    private Integer day;
    private Integer month;
    private Integer year;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Genre {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Images {
    private Jpg jpg;
    private Webp webp;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Jpg {
    private String image_url = new String();
    private String small_image_url = new String();
    private String large_image_url = new String();
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Licensor {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Producer {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Prop {
    private From from;
    private To to;
    private String string;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Studio {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Theme {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Title {
    private String type;
    private String title;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class To {
    private Integer day;
    private Integer month;
    private Integer year;
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Trailer {
    private String youtube_id = new String();
    private String url = new String();
    private String embed_url = new String();
  }

  @Getter
  @Setter
  @AllArgsConstructor
  @NoArgsConstructor
  public static class Webp {
    private String image_url = new String();
    private String small_image_url = new String();
    private String large_image_url = new String();
  }

}
