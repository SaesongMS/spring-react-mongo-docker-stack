package com.tnbm.restapi.models.movies;

import lombok.Getter;
import lombok.Setter;

@Getter
  @Setter
  public class MovieReleaseDate {
    private Integer day;
    private Integer month;
    private int year;
    private String __typename;
  }