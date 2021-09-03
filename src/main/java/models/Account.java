package models;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Account {
    private final UUID id;
    private final Customer customer;
    private final List<Movie> checkedOut;
}
