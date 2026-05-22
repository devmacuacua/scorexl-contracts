package com.scorexl.contracts.engine;

import java.math.BigDecimal;

public record MarketOpportunity(
        Long fixtureId,
        MarketType marketType,
        String engine,
        String market,
        String label,
        BigDecimal odd,
        BigDecimal point,
        BigDecimal modelProbability,
        BigDecimal impliedProbability,
        BigDecimal valuePercentage,
        BigDecimal expectedValue,
        BigDecimal recommendedStake,
        String tier,
        String decision
) {}