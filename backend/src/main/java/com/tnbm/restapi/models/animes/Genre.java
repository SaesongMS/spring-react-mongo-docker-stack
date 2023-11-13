package com.tnbm.restapi.models.animes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Genre {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;

    public Genre(String name) {
        this.name = name;
    }
}
