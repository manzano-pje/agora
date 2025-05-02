package com.pjem.agora.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_Projects")
public class Projects {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;

    /////////////// RELACIONAMENTOS ///////////////

    @OneToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    private List<AssociatedProjects> associates = new ArrayList<>();

}
