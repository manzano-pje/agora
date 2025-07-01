package com.pjem.agora.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ProjectUpdateRequest {

    @NonNull
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Schema(type = "LocalDate", pattern = "dd/MM/yyyy", example = "01/01/1900")
    @NonNull @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Schema(type = "LocalDate", pattern = "dd/MM/yyyy", example = "01/01/1900")
    @NonNull @DateTimeFormat(pattern = "dd/MM/yyyy")
    LocalDate endDate;
}
