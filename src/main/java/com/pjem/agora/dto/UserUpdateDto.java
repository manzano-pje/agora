package com.pjem.agora.dto;

import com.pjem.agora.model.enums.Profile;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
    private Long id;
    @Enumerated
    private Profile profile;
}
