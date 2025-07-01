package com.pjem.agora.record;

import com.pjem.agora.model.enums.BoardRole;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record BoardMemberCreateRequest(
        String member,
        BoardRole boardRole,

        @NotNull
        LocalDate startDate

){}
