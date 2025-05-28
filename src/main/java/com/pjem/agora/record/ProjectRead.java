package com.pjem.agora.record;

import com.pjem.agora.model.Associates;
import com.pjem.agora.model.Projects;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record ProjectRead(
        @NonNull String name,
        @NonNull @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
        @NonNull @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate
) {
    public static ProjectRead from (Projects projects){
        return new ProjectRead(projects.getName(),
                        projects.getStartDate(),
                   projects.getEndDate());
    }
}
