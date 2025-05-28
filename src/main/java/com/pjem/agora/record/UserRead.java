package com.pjem.agora.record;

import com.pjem.agora.model.enums.Profile;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRead(
        @NotBlank String name,
        @NotBlank @Email String email,
        @Enumerated Profile profile
) {
}
