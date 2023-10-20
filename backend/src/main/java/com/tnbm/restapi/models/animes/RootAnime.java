package com.tnbm.restapi.models.animes;

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
}
