package com.tnbm.restapi.models;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Data
@Document(collection = "users")
public class User {
  @Id
  private String id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 20)
  private String normalizedUsername;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 50)
  @Email
  private String normalizedEmail;

  @NotBlank
  private boolean emailConfirmed = false;

  @NotBlank
  private String passwordHash;

  @Nullable
  private String securityStamp = new String();

  @Nullable
  private String concurrencyStamp = new String();

  @Nullable
  private String phoneNumber = new String();

  @NotBlank
  private boolean phoneNumberConfirmed = false;

  @NotBlank
  private boolean twoFactorEnabled = false;

  @Nullable
  private String lockoutEnd = new String();

  @NotBlank
  private boolean lockoutEnabled = false;

  @NotBlank
  private int accessFailedCount = 0;

  @NotBlank
  private int version = 1;

  @NotBlank
  private Instant createdOn;

  @Nullable
  private Set<String> claims;

  @DBRef
  private Set<Role> roles = new HashSet<>();

  @Nullable
  private Set<String> logins = new HashSet<>();

  @Nullable
  private Set<String> tokens = new HashSet<>();

  @NotBlank
  private String fullName;

  public User(String username, String email, String password, String fullName) {
    this.username = username;
    this.email = email;
    this.passwordHash = password;
    this.fullName = fullName;
    this.createdOn = Instant.now();
  }
}
