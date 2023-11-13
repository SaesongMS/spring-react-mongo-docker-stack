package com.tnbm.restapi.models.movies;

import lombok.Getter;
import lombok.Setter;

@Getter
  @Setter
  public class MoviePlot {
    private MoviePlotText plotText;
    private MoviePlotLanguage language;
    private String __typename;
  }