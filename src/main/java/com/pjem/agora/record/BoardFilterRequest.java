package com.pjem.agora.record;

import java.time.LocalDate;

public record BoardFilterRequest(
        LocalDate managementStart,
        LocalDate managementEnd
) {
}
