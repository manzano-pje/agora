package com.pjem.agora.administrative.record;

import com.pjem.agora.administrative.model.enums.Profile;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegistrationRecord(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank String password,
        @Enumerated Profile profile
) {
}
