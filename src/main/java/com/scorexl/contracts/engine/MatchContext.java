package com.scorexl.contracts.engine;

import java.math.BigDecimal;
import java.util.List;

/**
 * Contextual match data enriching the engine request.
 *
 * Computed by scorexl-api (gateway) before calling each market engine.
 * Each engine uses the fields relevant to its market:
 *
 *   match-winner → form, motivation, h2h
 *   over-under   → avgGoalsScored, avgGoalsConceded
 *   btts         → avgGoalsScored, avgGoalsConceded per team
 *   handicap     → form, goalDiff, relative strength
 */
public record MatchContext(

        // ── Home team context ─────────────────────────────────────────────
        int    homeFormPoints,          // 0-15 (last 5 games, 3pts/win)
        int    homeFormGames,
        List<String> homeFormRecord,    // ["W","D","L","W","W"] most recent first
        BigDecimal homeAvgGoalsScored,
        BigDecimal homeAvgGoalsConceded,
        int    homePosition,            // league position (1 = top), 0 if unknown
        String homeMotivation,          // TITLE_RACE | CHAMPIONS_CHASE | EUROPEAN_CHASE | MID_TABLE | SURVIVAL | RELEGATION_BATTLE

        // ── Away team context ─────────────────────────────────────────────
        int    awayFormPoints,
        int    awayFormGames,
        List<String> awayFormRecord,
        BigDecimal awayAvgGoalsScored,
        BigDecimal awayAvgGoalsConceded,
        int    awayPosition,
        String awayMotivation,

        // ── Head-to-head ──────────────────────────────────────────────────
        int    h2hTotalGames,
        int    h2hHomeWins,
        int    h2hDraws,
        int    h2hAwayWins,

        // ── Match context ─────────────────────────────────────────────────
        boolean isNeutralVenue         // false = home advantage applies
) {
    /** Empty context when no data is available */
    public static MatchContext empty() {
        return new MatchContext(
                0, 0, List.of(), BigDecimal.ZERO, BigDecimal.ZERO, 0, "MID_TABLE",
                0, 0, List.of(), BigDecimal.ZERO, BigDecimal.ZERO, 0, "MID_TABLE",
                0, 0, 0, 0, false
        );
    }

    /** Convenience: relative form advantage for home team (-1 to +1) */
    public double relativeFormAdvantage() {
        if (homeFormGames == 0 || awayFormGames == 0) return 0;
        double h = homeFormPoints / (double)(homeFormGames * 3);
        double a = awayFormPoints / (double)(awayFormGames * 3);
        return h - a;
    }

    /** Expected total goals proxy (home + away averages) */
    public BigDecimal expectedTotalGoals() {
        return homeAvgGoalsScored.add(awayAvgGoalsScored);
    }
}
