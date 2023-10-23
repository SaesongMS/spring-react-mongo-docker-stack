package com.tnbm.restapi.models.movies;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
  @Setter
  public class MovieRoot {
    private int page;
    private String next;
    private int entries;
    private List<Movie> results;
  }