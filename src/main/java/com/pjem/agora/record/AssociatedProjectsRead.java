package com.pjem.agora.administrative.record;

import java.time.LocalDate;

public record AssociatedProjectsRead(
        String associateName,
        String projectName,
        LocalDate entryDate,
        String role
) {
}
