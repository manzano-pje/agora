package com.pjem.agora.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_Direction")
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDirection;
    private Long associateName;
    private LocalDate startDate;
    private LocalDate finalDate;
    private Boolean isActive;
    @Enumerated(EnumType.STRING)
    private com.pjem.agora.model.enums.Direction direction;

    @OneToMany (mappedBy = "direction", cascade = CascadeType.ALL)
    private List<Associates> associates = new ArrayList<>();
}

