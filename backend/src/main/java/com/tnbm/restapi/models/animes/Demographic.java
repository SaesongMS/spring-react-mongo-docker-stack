package com.tnbm.restapi.models.animes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Demographic {
    private Integer mal_id;
    private String type;
    private String name;
    private String url;
}