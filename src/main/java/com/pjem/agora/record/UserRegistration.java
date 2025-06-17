package com.pjem.agora.record;

import com.pjem.agora.model.enums.ProfileEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegistration(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String password,
        @Enumerated ProfileEnum profileEnum
) {
}
