package interfaces.functional;

import models.Movie;

import java.util.List;

@FunctionalInterface
public interface InventoryCounter {
    int apply(List<Movie> inventory);
}
