package com.tnbm.restapi.models.movies;

import lombok.Getter;
import lombok.Setter;

@Getter
  @Setter
  public class MovieReleaseYear {
    private int year;
    private Integer endYear;
    private String __typename;
  }