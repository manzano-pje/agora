package com.pjem.agora.record;

import com.pjem.agora.model.enums.UserRole;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserResponse(
        @NotBlank String name,
        @NotBlank @Email String email,
        @Enumerated UserRole userRole
) {
}
