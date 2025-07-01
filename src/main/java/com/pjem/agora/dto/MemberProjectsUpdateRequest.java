package com.pjem.agora.dto;

import com.pjem.agora.model.enums.MembersCategory;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberProjectsUpdateRequest {
    @NonNull
    private Long id;
    @NonNull
    private Long associateId;
    @NonNull
    private Long projectId;
    @NonNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate entryDate;
    @Enumerated
    private MembersCategory membersCategory;
}
