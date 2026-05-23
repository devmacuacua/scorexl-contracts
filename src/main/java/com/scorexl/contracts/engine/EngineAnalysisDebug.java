package com.scorexl.contracts.engine;

import java.util.List;

public record EngineAnalysisDebug(
        List<OpportunityDebug> qualified,
        List<RejectionDebug> rejected
) {
}