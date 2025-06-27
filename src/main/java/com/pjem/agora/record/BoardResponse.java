package com.pjem.agora.record;

import com.pjem.agora.model.enums.BoardRole;

import java.time.LocalDate;

public record BoardResponse(
        String nameDirector,
        BoardRole role,
        LocalDate startDate,
        LocalDate finalDate,
        Boolean isActive
) {
}
