package com.pjem.agora.administrative.record;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.NonNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record AssociatesReadRecord(
        @NonNull String name,
        @CPF @NonNull String cpf,
        @NonNull @DateTimeFormat(pattern = "dd/MM/yyyy") Date dateOfBirth,
        @NonNull  String phone,
        @Email @NonNull String email,
        @NonNull String adress,
        @NonNull int number,
        String comlement,
        @NonNull @Pattern(regexp = "^\\d{5} - \\d{3}") String cep,
        @NonNull String city,
        @NonNull String state
){}


