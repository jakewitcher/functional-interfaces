package models;

import lombok.Data;

import java.time.Duration;

@Data
public class LateFeeRules {
    private final double amount;
    private final Duration duration;
}
