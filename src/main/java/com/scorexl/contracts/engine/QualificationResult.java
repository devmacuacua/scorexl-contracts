package com.scorexl.contracts.engine;

import java.math.BigDecimal;

public record QualificationResult(
        boolean qualified,
        String reason,
        BigDecimal minimumValuePercentage,
        BigDecimal minimumExpectedValue
) {
}