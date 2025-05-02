package com.pjem.agora.administrative.record;

import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record ProjectRegistrationRecord(
        @NonNull String name,
        @NonNull @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
        @NonNull @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate
) {
}
