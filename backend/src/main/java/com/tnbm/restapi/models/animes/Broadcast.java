package com.tnbm.restapi.models.animes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Broadcast {
    private String day;
    private String time;
    private String timezone;
    private String string;
}
