package com.pjem.agora.model;

import com.pjem.agora.model.enums.BoardRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_Direction")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDirection;

    @Column(name = "role", length = 30)
    @Enumerated(EnumType.STRING)
    private BoardRole role;

    @OneToMany(mappedBy = "associates",cascade = CascadeType.ALL)
    @JoinColumn(name = "associates_id")
    private List<Members> associates = new ArrayList<>();
}

