package com.pjem.agora.record;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public record ProjectRegistration(
        @NonNull String name,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @NonNull @DateTimeFormat(pattern = "dd/MM/yyyy")
        @Schema(type = "string", pattern = "dd/MM/yyyy", example = "01/01/1900")
        LocalDate startDate
) {
}

