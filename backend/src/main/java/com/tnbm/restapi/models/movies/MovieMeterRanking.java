package com.tnbm.restapi.models.movies;

import lombok.Getter;
import lombok.Setter;

@Getter
  @Setter
  public class MovieMeterRanking {
    private int currentRank;
    private MeterRankingRankChange rankChange;
    private String __typename;
  }