package com.pjem.agora.record;

import java.time.LocalDate;

public record BoardCreateRequest(
        LocalDate mandateStart,
        LocalDate mandateEnd
) {
}
