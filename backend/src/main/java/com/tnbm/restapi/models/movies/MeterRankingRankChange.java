package com.tnbm.restapi.models.movies;

import lombok.Getter;
import lombok.Setter;

@Getter
  @Setter
  public class MeterRankingRankChange {
    private String changeDirection;
    private int difference;
    private String __typename;
  }