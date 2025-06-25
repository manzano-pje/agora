package com.pjem.agora.model;

import com.pjem.agora.model.enums.DirectionEnum;
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
    private LocalDate startDate;
    private LocalDate finalDate;

    @Column(name = "role", length = 20)
    @Enumerated(EnumType.STRING)
    private DirectionEnum role;
    private boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "associates_id")
    private Associates associates;

}

