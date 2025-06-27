package com.pjem.agora.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.aot.hint.MemberCategory;

import java.time.LocalDate;



/**
 *  associated projects
 *  Esta tabela é uma tabela de relacionamento
 *  entre as tabelas de associados e projetos
 *  onde se incluem os campos entryDate e MembersCategory
 *  para indicar a data de entrada e o papel do
 *  assiociado no projeto
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_AssiciatedProjects")
public class membersProjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate entryDate;
//    private MemberCategory memberCategory;


    /////////////// RELACIONAMENTOS ///////////////

    @ManyToOne
    @JoinColumn(name = "associated_id")
    private Members members;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projects projects;

}
