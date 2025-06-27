package com.pjem.agora.dto;

import com.pjem.agora.model.enums.UserRole;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    private Long id;
    @Enumerated
    private UserRole profile;
}
