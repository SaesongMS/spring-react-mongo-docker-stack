package com.tnbm.restapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Movie")
public class Movie {
  @Id
  private String id;
  private MovieRatingSummary ratingSummary;
  private Integer episodes;
  private MoviePrimaryImage primaryImage;
  private MovieTitleType titleType;
  private MovieGenres genres;
  private MovieTitleText titleText;
  private MovieTitleText originalTitleText;
  private MovieReleaseYear releaseYear;
  private MovieReleaseDate releaseDate;
  private MovieRuntime runtime;
  private String series;
  private MovieMeterRanking meterRanking;
  private MoviePlot plot;
  private Integer position;

  @Getter
  @Setter
  public class MovieRoot {
    private int page;
    private String next;
    private int entries;
    private List<Movie> results;
  }

  @Getter
  @Setter
  public class MovieRatingSummary {
    private double aggregateRating;
    private int voteCount;
    private String __typename;

  }

  @Getter
  @Setter
  public class MoviePrimaryImage {
    private String id;
    private int width;
    private int height;
    private String url;
    private MoviePrimaryImageCaption caption;
    private String __typename;
  }

  @Getter
  @Setter
  public class MoviePrimaryImageCaption {
    private String plainText;
    private String __typename;
  }

  @Getter
  @Setter
  public class MovieTitleType {
    private String text;
    private String id;
    private boolean isSeries;
    private boolean isEpisode;
    private String __typename;
  }

  @Getter
  @Setter
  public class MovieGenres {
    private List<MovieGenresItem> genres;
    private String __typename;
  }

  @Getter
  @Setter
  public class MovieGenresItem {
    private String text;
    private String id;
    private String __typename;
  }

  @Getter
  @Setter
  public class MovieTitleText {
    private String text;
    private String __typename;
  }

  @Getter
  @Setter
  public class MovieReleaseYear {
    private int year;
    private Integer endYear;
    private String __typename;
  }

  @Getter
  @Setter
  public class MovieReleaseDate {
    private Integer day;
    private Integer month;
    private int year;
    private String __typename;
  }

  @Getter
  @Setter
  public class MovieRuntime {
    private int seconds;
    private String __typename;
  }

  @Getter
  @Setter
  public class MovieMeterRanking {
    private int currentRank;
    private MeterRankingRankChange rankChange;
    private String __typename;
  }

  @Getter
  @Setter
  public class MeterRankingRankChange {
    private String changeDirection;
    private int difference;
    private String __typename;
  }

  @Getter
  @Setter
  public class MoviePlot {
    private MoviePlotText plotText;
    private MoviePlotLanguage language;
    private String __typename;
  }

  @Getter
  @Setter
  public class MoviePlotText {
    private String plainText;
    private String __typename;
  }

  @Getter
  @Setter
  public class MoviePlotLanguage {
    private String id;
    private String __typename;
  }
}