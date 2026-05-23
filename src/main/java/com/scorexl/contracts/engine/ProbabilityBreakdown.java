package com.scorexl.contracts.engine;

import java.math.BigDecimal;

public record ProbabilityBreakdown(
        BigDecimal homeWinProbability,
        BigDecimal drawProbability,
        BigDecimal awayWinProbability,
        BigDecimal estimatedProbability,
        String methodology
) {
}