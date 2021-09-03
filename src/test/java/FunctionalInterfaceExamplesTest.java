import examples.FunctionalInterfaceExamples;
import models.MediaType;
import models.Movie;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static examples.FunctionalInterfaceExamples.*;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalInterfaceExamplesTest {
    @Test
    public void itShouldPrintMovieTitlesWithLeftPadding() {
        var expected = asList(
                "             Aquaman",
                "  Batman v. Superman",
                "        Wonder Woman"
        );

        var actual = formatMovieTitlesPadLeft(getMovies());

        assertEquals(expected, actual);
    }

    @Test
    public void itShouldPrintMovieDetailsWithFormatter() {
        var expected = asList(
                "xX|Aquaman             |DVD       |15        |Xx",
                "xX|Batman v. Superman  |DVD       |25        |Xx",
                "xX|Wonder Woman        |DVD       |35        |Xx"
        );

        Function<Movie, String> formatter = movieDetails().andThen(extreme());

        var actual = formatMovieDetails(getMovies(), formatter);

        assertEquals(expected, actual);
    }

    private static List<Movie> getMovies() {
        return asList(
                new Movie("Aquaman", MediaType.DVD, 15),
                new Movie("Batman v. Superman", MediaType.DVD,  25),
                new Movie("Wonder Woman", MediaType.DVD, 35)
        );
    }
}
