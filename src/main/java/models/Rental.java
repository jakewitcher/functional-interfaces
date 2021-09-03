package models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Rental {
    private final Movie movie;
    private final LocalDateTime checkOutDateTime;
    private final LateFeeRules lateFeeRules;
}
