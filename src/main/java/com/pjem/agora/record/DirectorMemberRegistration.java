package com.pjem.agora.record;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pjem.agora.model.enums.DirectionEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record DirectorMemberRegistration(
        String associateName,

        DirectionEnum directionEnum,

        @NotNull
        LocalDate startDate

){}
