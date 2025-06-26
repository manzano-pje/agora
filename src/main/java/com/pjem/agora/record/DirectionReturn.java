package com.pjem.agora.record;

import com.pjem.agora.model.Associates;
import com.pjem.agora.model.enums.DirectionEnum;

import java.time.LocalDate;

public record DirectionReturn(
        DirectionEnum role,
        Associates nameDirector,
        LocalDate startDate,
        LocalDate finalDate,
        Boolean isActive
) {
}
