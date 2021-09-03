import interfaces.functional.InventoryCounter;
import models.Inventory;
import models.MediaType;
import models.Movie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryCounterTest {
    private static Inventory inventory;

    @BeforeAll
    public static void setup() {
        inventory = new Inventory(getMovies());
    }

    private static List<Movie> getMovies() {
        return asList(
                new Movie("Aquaman", MediaType.DVD, 15),
                new Movie("Aquaman", MediaType.VHS, 5),
                new Movie("Batman v. Superman", MediaType.DVD,  25),
                new Movie("Batman v. Superman", MediaType.VHS,  10),
                new Movie("Justice League", MediaType.DVD, 30),
                new Movie("Justice League", MediaType.VHS, 12),
                new Movie("Man of Steel", MediaType.DVD, 12),
                new Movie("Man of Steel", MediaType.VHS, 3),
                new Movie("Wonder Woman", MediaType.DVD, 35),
                new Movie("Wonder Woman", MediaType.VHS, 10)
        );
    }

    @Test
    public void itShouldCountAllMoviesInInventory() {
        var inventoryCount = inventory.count(this::countMovieInventory);
        assertEquals(157, inventoryCount);
    }

    private int countMovieInventory(List<Movie> movies) {
        return movies.stream().mapToInt(Movie::getQuantity).sum();
    }

    @Test
    public void itShouldCountAllVhsMoviesInInventory() {
        var vhsInventoryCount = inventory.count(this::countVhsMovieInventory);
        assertEquals(40, vhsInventoryCount);
    }

    private int countVhsMovieInventory(List<Movie> movies) {
        return movies.stream()
                .filter(movie -> Objects.equals(movie.getMediaType(), MediaType.VHS))
                .mapToInt(Movie::getQuantity).sum();
    }

    @Test
    public void itShouldCountAllMoviesInInventoryWithSpecifiedTitle() {
        var aquamanInventoryCount = inventory.count(countMovieInventoryWithTitle("Aquaman"));
        var wonderWomanInventoryCount = inventory.count(countMovieInventoryWithTitle("Wonder Woman"));

        assertEquals(20, aquamanInventoryCount);
        assertEquals(45, wonderWomanInventoryCount);
    }

    private InventoryCounter countMovieInventoryWithTitle(String title) {
        return movies -> movies.stream()
                .filter(movie -> Objects.equals(movie.getTitle(), title))
                .mapToInt(Movie::getQuantity).sum();
    }
}
