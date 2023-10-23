package com.tnbm.restapi.models.movies;

import lombok.Getter;
import lombok.Setter;

@Getter
  @Setter
  public class MovieRatingSummary {
    private double aggregateRating;
    private int voteCount;
    private String __typename;

  }