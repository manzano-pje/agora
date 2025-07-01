package com.pjem.agora.record;

import java.time.LocalDate;

public record BoardUpdateRequest(
        LocalDate managementStart,
        LocalDate managementEnd,
        boolean isActive
) {
}
