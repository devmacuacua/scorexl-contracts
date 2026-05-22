package com.scorexl.contracts.odds;

import java.math.BigDecimal;

public record OddSnapshot(
        Long bookmakerId,
        String bookmaker,
        String market,
        String label,
        BigDecimal point,
        BigDecimal odd
) {}