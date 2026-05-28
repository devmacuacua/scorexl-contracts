package com.scorexl.contracts.engine;

import com.scorexl.contracts.fixture.FixtureSnapshot;
import com.scorexl.contracts.odds.OddSnapshot;
import com.scorexl.contracts.prediction.ProbabilitySnapshot;

import java.util.List;

public record EngineAnalysisRequest(
        FixtureSnapshot fixture,
        ProbabilitySnapshot probabilities,
        List<OddSnapshot> odds,
        MatchContext context
) {
    /** Backwards-compatible constructor — engines that don't yet use context get MatchContext.empty() */
    public EngineAnalysisRequest(
            FixtureSnapshot fixture,
            ProbabilitySnapshot probabilities,
            List<OddSnapshot> odds
    ) {
        this(fixture, probabilities, odds, MatchContext.empty());
    }
}