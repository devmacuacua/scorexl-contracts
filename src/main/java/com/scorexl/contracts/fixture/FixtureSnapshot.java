package com.scorexl.contracts.fixture;

import java.time.LocalDateTime;

public record FixtureSnapshot(
        Long fixtureId,
        LocalDateTime startsAt,
        TeamSnapshot homeTeam,
        TeamSnapshot awayTeam,
        Boolean finished,
        String finalResult,
        Integer homeScore,
        Integer awayScore
) {}