package com.tnbm.restapi.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RootAnime {
    private List<Anime> data;
    private Pagination pagination;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Pagination {
        private int last_visible_page;
        private boolean has_next_page;
        private Items items;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Items {
        private Integer count;
        private Integer total;
        private Integer per_page;
    }
}
