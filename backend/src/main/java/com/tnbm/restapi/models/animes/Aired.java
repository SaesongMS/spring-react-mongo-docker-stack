package com.tnbm.restapi.models.animes;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class Aired {
    private String from;
    private String to;
    private Prop prop;
}
