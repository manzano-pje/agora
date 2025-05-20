package com.pjem.agora.administrative.record;

import java.time.LocalDate;

public record AssociatedProjectsReadRecord(
        String associateName,
        String projectName,
        LocalDate entryDate,
        String role
) {
}
