package com.pjem.agora.administrative.record;

import java.time.LocalDate;

public record AssociatedProjectsRegistrationRecord(
        Long associateId,
        Long projectId,
        LocalDate entryDate,
        String role

) {
}
