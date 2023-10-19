package com.tnbm.restapi.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAnimeRequest {
    @NotBlank
    private String url;
}
