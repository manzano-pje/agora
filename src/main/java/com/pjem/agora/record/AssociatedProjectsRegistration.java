package com.pjem.agora.administrative.record;

import java.time.LocalDate;

public record AssociatedProjectsRegistration(
        Long associateId,
        Long projectId,
        LocalDate entryDate,
        String role

) {
}
