package com.pjem.agora.record;

import com.pjem.agora.model.Direction;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


public record DirectorMemberRegistration(
        String assocaiteName,
        @Enumerated(EnumType.STRING) Direction direction
){}

