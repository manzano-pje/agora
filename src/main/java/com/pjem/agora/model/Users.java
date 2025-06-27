package com.pjem.agora.model;

import com.pjem.agora.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @Enumerated
    private UserRole userRole;

    /////////////// RELACIONAMENTOS ///////////////

//    @OneToOne(mappedBy = "users")
//    private Members members;
}
