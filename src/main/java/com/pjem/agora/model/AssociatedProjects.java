package com.pjem.agora.model;

import com.pjem.agora.model.enums.ProjectEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;



/**
 *  associated projects
 *  Esta tabela é uma tabela de relacionamento
 *  entre as tabelas de associados e projetos
 *  onde se incluem os campos entryDate e ProjectEnum
 *  para indicar a data de entrada e o papel do
 *  assiociado no projeto
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_AssiciatedProjects")
public class AssociatedProjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate entryDate;
    private ProjectEnum projectEnum;


    /////////////// RELACIONAMENTOS ///////////////

    @ManyToOne
    @JoinColumn(name = "associated_id")
    private Associates associates;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projects projects;

}
