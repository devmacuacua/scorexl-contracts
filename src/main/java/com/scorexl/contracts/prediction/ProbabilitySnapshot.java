package com.scorexl.contracts.prediction;

import java.math.BigDecimal;

public record ProbabilitySnapshot(
        BigDecimal homeWinProbability,
        BigDecimal drawProbability,
        BigDecimal awayWinProbability,
        BigDecimal confidenceScore,
        String modelVersion,
        BigDecimal expectedHomeGoals,
        BigDecimal expectedAwayGoals,
        BigDecimal expectedHomeCorners,
        BigDecimal expectedAwayCorners,
        BigDecimal expectedHomeCards,
        BigDecimal expectedAwayCards,
        BigDecimal expectedHomeShotsOnTarget,
        BigDecimal expectedAwayShotsOnTarget,
        BigDecimal expectedHomeFouls,
        BigDecimal expectedAwayFouls
) {
    /** Backwards-compatible constructor — engines that don't yet use Poisson lambdas get null values. */
    public ProbabilitySnapshot(
            BigDecimal homeWinProbability,
            BigDecimal drawProbability,
            BigDecimal awayWinProbability,
            BigDecimal confidenceScore,
            String modelVersion
    ) {
        this(homeWinProbability, drawProbability, awayWinProbability, confidenceScore, modelVersion,
                null, null, null, null, null, null, null, null, null, null);
    }

    /** Backwards-compatible constructor — engines built before corners/cards/shots-on-target/fouls existed. */
    public ProbabilitySnapshot(
            BigDecimal homeWinProbability,
            BigDecimal drawProbability,
            BigDecimal awayWinProbability,
            BigDecimal confidenceScore,
            String modelVersion,
            BigDecimal expectedHomeGoals,
            BigDecimal expectedAwayGoals
    ) {
        this(homeWinProbability, drawProbability, awayWinProbability, confidenceScore, modelVersion,
                expectedHomeGoals, expectedAwayGoals, null, null, null, null, null, null, null, null);
    }
}