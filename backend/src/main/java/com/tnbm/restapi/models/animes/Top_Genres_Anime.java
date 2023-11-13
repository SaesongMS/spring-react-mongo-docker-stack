package com.tnbm.restapi.models.animes;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "top_genres_anime")
public class Top_Genres_Anime {
    @Id
    private String id;
    private String name;
    private int value;
}
