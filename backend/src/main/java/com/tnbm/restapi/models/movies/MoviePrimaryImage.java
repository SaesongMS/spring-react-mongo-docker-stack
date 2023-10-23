package com.tnbm.restapi.models.movies;

import lombok.Getter;
import lombok.Setter;

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