package com.tnbm.restapi.payload.response;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreResponse {
    private String id;
    private String img;
    private String title;
    private String year;
    private String genre;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GenreResponse that = (GenreResponse) o;
        return Objects.equals(img, that.img) &&
                Objects.equals(title, that.title) &&
                Objects.equals(year, that.year) &&
                Objects.equals(genre, that.genre);
    }
}
