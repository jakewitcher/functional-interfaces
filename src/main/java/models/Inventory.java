package models;

import interfaces.functional.InventoryCounter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Inventory {
    private final List<Movie> movies;

    public int count(InventoryCounter counter) {
        return counter.apply(movies);
    }
}
