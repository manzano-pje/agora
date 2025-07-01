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
@Table(name="tb_Board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoard;
    private LocalDate mandateStart;
    private LocalDate mandateEnd;
    private boolean isActive;

    @OneToMany(mappedBy = "boardMembers", cascade = CascadeType.ALL)
    private List<BoardMembers> boardMembers  = new ArrayList<>();


}

