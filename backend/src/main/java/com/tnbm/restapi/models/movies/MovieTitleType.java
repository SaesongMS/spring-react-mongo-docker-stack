package com.tnbm.restapi.models.movies;

import lombok.Getter;
import lombok.Setter;

@Getter
  @Setter
  public class MovieTitleType {
    private String text;
    private String id;
    private boolean isSeries;
    private boolean isEpisode;
    private String __typename;
  }