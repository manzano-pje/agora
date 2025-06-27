package com.pjem.agora.dto;

import com.pjem.agora.model.Members;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MemberUpdateRequest {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String rg;
    @CPF
    @NonNull
    private String cpf;
    @NonNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
    @NonNull
    private String phone;
    @Email
    @NonNull
    private String email;
    @NonNull
    private String adress;
    @NonNull
    private int number;
    private String comlement;
    @NonNull
    @Pattern(regexp = "^\\d{5} - \\d{3}")
    private String cep;
    @NonNull
    private String city;
    @NonNull
    private String state;

    public MemberUpdateRequest(Members members) {
    }
}

