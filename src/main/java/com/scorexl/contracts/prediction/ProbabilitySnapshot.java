package com.scorexl.contracts.prediction;

import java.math.BigDecimal;

public record ProbabilitySnapshot(
        BigDecimal homeWinProbability,
        BigDecimal drawProbability,
        BigDecimal awayWinProbability,
        BigDecimal confidenceScore,
        String modelVersion,
        BigDecimal expectedHomeGoals,
        BigDecimal expectedAwayGoals
) {
    /** Backwards-compatible constructor — engines that don't yet use Poisson lambdas get null values. */
    public ProbabilitySnapshot(
            BigDecimal homeWinProbability,
            BigDecimal drawProbability,
            BigDecimal awayWinProbability,
            BigDecimal confidenceScore,
            String modelVersion
    ) {
        this(homeWinProbability, drawProbability, awayWinProbability, confidenceScore, modelVersion, null, null);
    }
}