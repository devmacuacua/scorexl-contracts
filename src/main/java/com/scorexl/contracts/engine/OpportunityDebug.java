package com.scorexl.contracts.engine;

import java.math.BigDecimal;

public record OpportunityDebug(
        String definitionLabel,
        String rawMarket,
        String rawLabel,
        BigDecimal rawPoint,

        BigDecimal homeProbability,
        BigDecimal drawProbability,
        BigDecimal awayProbability,

        BigDecimal estimatedProbability,
        BigDecimal impliedProbability,

        BigDecimal valuePercentage,
        BigDecimal expectedValue,

        BigDecimal minimumValuePercentage,
        BigDecimal minimumExpectedValue,

        String decisionReason
) {
}