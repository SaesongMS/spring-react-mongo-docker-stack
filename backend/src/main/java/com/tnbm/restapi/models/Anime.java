package com.tnbm.restapi.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "anime")
public class Anime {
  @Id
  private String id;
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

  @Getter
  @Setter
  public class Aired {
    private String from;
    private String to;
    private Prop prop;
  }

  @Getter
  @Setter
  public class Broadcast {
    private String day;
    private String time;
    private String timezone;
    private String string;
  }

  @Getter
  @Setter
  public class Demographic {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  public class ExplicitGenre {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  public class From {
    private Integer day;
    private Integer month;
    private Integer year;
  }

  @Getter
  @Setter
  public class Genre {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  public class Images {
    private Jpg jpg;
    private Webp webp;
  }

  @Getter
  @Setter
  public class Items {
    private Integer count;
    private Integer total;
    private Integer per_page;
  }

  @Getter
  @Setter
  public class Jpg {
    private String image_url;
    private String small_image_url;
    private String large_image_url;
  }

  @Getter
  @Setter
  public class Licensor {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  public class Pagination {
    private int last_visible_page;
    private boolean has_next_page;
    private Items items;
  }

  @Getter
  @Setter
  public class Producer {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  public class Prop {
    private From from;
    private To to;
    private String string;
  }

  @Getter
  @Setter
  public class RootAnime {
    private List<Anime> data;
    private Pagination pagination;
  }

  @Getter
  @Setter
  public class Studio {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  public class Theme {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
  }

  @Getter
  @Setter
  public class Title {
    private String type;
    private String title;
  }

  @Getter
  @Setter
  public class To {
    private Integer day;
    private Integer month;
    private Integer year;
  }

  @Getter
  @Setter
  public class Trailer {
    private String youtube_id;
    private String url;
    private String embed_url;
  }

  @Getter
  @Setter
  public class Webp {
    private String image_url;
    private String small_image_url;
    private String large_image_url;
  }
}
