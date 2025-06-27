package com.pjem.agora.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_Associates")
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String rg;
    private String cpf;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
    private String phone;
    private String email;
    private String adress;
    private int number;
    private String comlement;
    private String cep;
    private String city;
    private String state;
    private Boolean isActive;


    /////////////// RELACIONAMENTOS ///////////////

//    @OneToOne
//    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "associates_id", nullable = false)
    private Members members;

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL)
    private List<membersProjects> projects = new ArrayList<>();
}
