package com.pjem.agora.record;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.NonNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record AssociatesRegistrationRecord(
        @NonNull String name,
        @NonNull @Min(value = 8, message = "O RG precisa ter no mínimo 8 dígitos") String rg,
        @CPF @NonNull String cpf,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
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


