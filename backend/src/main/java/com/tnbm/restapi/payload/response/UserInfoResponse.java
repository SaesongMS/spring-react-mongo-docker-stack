package com.tnbm.restapi.payload.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoResponse {
  private String id;
  private String username;
  private String email;
  private List<String> roles;
}
