package com.tnbm.restapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tnbm.restapi.payload.response.GenreResponse;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "list")
public class UserList {
  @Id
  private String id;
  private List<GenreResponse> watched = new ArrayList<>();
  private List<GenreResponse> planned = new ArrayList<>();
}
