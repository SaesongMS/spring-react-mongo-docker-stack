package com.tnbm.restapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "userlist")
public class UserList {
  @Id
  private String id;
  @DBRef
  private String userId;
  private List<GenreResponse> watched;
  private List<GenreResponse> planned;

  @Getter
  @Setter
  public class GenreResponse {
    private String id;
    private String url;
    private String tittle;
    private String year;
    private String genre;
  }
}
