package com.tnbm.restapi.models.movies;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "movies")
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
}