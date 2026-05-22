package com.scorexl.contracts.prediction;

import java.math.BigDecimal;

public record ProbabilitySnapshot(
        BigDecimal homeWinProbability,
        BigDecimal drawProbability,
        BigDecimal awayWinProbability,
        BigDecimal confidenceScore,
        String modelVersion
) {}