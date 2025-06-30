package com.pjem.agora.record;

import java.time.LocalDate;

public record BoardCreateRequest(
        LocalDate startDate,
        LocalDate finalDate
) {
}
