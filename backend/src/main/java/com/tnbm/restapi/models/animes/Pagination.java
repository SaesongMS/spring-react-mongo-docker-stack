package com.tnbm.restapi.models.animes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {
    private int last_visible_page;
    private boolean has_next_page;
    private Items items;
}
