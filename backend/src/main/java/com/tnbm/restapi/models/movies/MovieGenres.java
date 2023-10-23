package com.tnbm.restapi.models.movies;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
  @Setter
  public class MovieGenres {
    private List<MovieGenresItem> genres;
    private String __typename;
  }