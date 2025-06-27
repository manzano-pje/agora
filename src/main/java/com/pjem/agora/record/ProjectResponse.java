package com.pjem.agora.record;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pjem.agora.model.Projects;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record ProjectResponse(
        @NonNull String name,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @NonNull @DateTimeFormat(pattern = "dd/MM/yyyy")
        @Schema(type = "string", pattern = "dd/MM/yyyy", example = "01/01/1900")
        LocalDate date,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        @Schema(type = "string", pattern = "dd/MM/yyyy", example = "01/01/1900")
        LocalDate endDate
        ) {
    public static ProjectResponse from (Projects projects){
        return new ProjectResponse(projects.getName(),
                   projects.getStartDate(),
                   projects.getEndDate());
    }

}
