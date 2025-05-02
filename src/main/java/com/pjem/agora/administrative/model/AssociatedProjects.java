package com.pjem.agora.administrative.model;

import com.pjem.agora.administrative.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



/**
 *  associated projects
 *  Esta tabela é uma tabela de relacionamento
 *  entre as tabelas de associados e projetos
 *  onde se incluem os campos entryDate e Role
 *  para indicar a data de entrada e o papel do
 *  assiociado no projeto
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_AssiciatedProjects")
public class AssociatedProjects {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate entryDate;
    private Role role;


    /////////////// RELACIONAMENTOS ///////////////

    @ManyToOne
    @JoinColumn(name = "associated_id")
    private Associates associates;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projects projects;

}
