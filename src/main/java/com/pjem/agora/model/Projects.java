package com.pjem.agora.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_Projects")
public class Projects {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;
    private boolean isActive;

    /////////////// RELACIONAMENTOS ///////////////

    @OneToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    private List<membersProjects> associates = new ArrayList<>();
}
