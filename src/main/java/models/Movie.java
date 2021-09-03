package models;

import lombok.Data;

@Data
public class Movie {
    private final String title;
    private final MediaType mediaType;
    private final int quantity;
}
