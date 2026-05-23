package com.scorexl.contracts.engine;

import java.util.List;

public record EngineAnalysisResponse(
        Long fixtureId,
        String engine,
        List<MarketOpportunity> opportunities,
        EngineAnalysisDebug debug
) {}