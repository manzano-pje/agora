package com.pjem.agora.record;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pjem.agora.model.enums.DirectionEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record DirectorMemberRegistration(
        String associateName,

        DirectionEnum directionEnum

//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
//        @NotNull
//        @Schema(type = "string", pattern = "dd/MM/yyyy", example = "01/01/1900")
//        LocalDate startDate
){}
