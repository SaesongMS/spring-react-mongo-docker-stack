package com.tnbm.restapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "top_genres")
public class Genres {
  @Id
  private String id;
  private String name;
  private int value;

  public Genres(String name, int value) {
    this.name = name;
    this.value = value;
  }

  public Genres(String name) {
    this.name = name;
  }
}
