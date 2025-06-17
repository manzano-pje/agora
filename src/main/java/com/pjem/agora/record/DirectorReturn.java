package com.pjem.agora.record;

import com.pjem.agora.model.enums.DirectionEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record DirectorReturn(

        @NonNull
        Long associateName,

        @NonNull @DateTimeFormat(pattern = "dd/MM/yyyy")
        @Schema(type = "string", pattern = "dd/MM/yyyy", example = "01/01/1900")
        LocalDate startDate,

        @DateTimeFormat(pattern = "dd/MM/yyyy")
        @Schema(type = "string", pattern = "dd/MM/yyyy", example = "01/01/1900")
        LocalDate finalDate,

        @Enumerated(EnumType.STRING)
        DirectionEnum role,

        boolean isActive

) {
}
