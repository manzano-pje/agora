package com.pjem.agora.record;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NonNull;

import java.time.LocalDate;

public record ProjectCreateRequest(
        @NonNull String name,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @NonNull
        @Schema(type = "string", pattern = "dd/MM/yyyy", example = "01/01/1900")
        LocalDate startDate
) {
}

