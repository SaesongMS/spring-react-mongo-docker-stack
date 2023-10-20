package com.tnbm.restapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tnbm.restapi.payload.response.GenreResponse;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "list")
public class UserList {
  @Id
  private String _id;
  private List<GenreResponse> watched;
  private List<GenreResponse> planned;

}
