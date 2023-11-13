package com.tnbm.restapi.payload.request;

import com.tnbm.restapi.payload.response.GenreResponse;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListRequest {
    @NotBlank
    String id;
    @NotBlank
    GenreResponse subject;
}
