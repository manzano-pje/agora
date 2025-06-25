package com.pjem.agora.record;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.NonNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record AssociatesRegistration(
        @NotNull String name,
        @NotNull @Min(value = 8, message = "O RG precisa ter no mínimo 8 dígitos") String rg,
        @NotNull @CPF @NonNull String cpf,

        @NotNull Date dateOfBirth,
        @NotNull String phone,
        @NotNull@Email String email,
        @NotNull String adress,
        @NotNull int number,
        String comlement,
        @Pattern(regexp = "^\\d{5} - \\d{3}") String cep,
        @NotNull String city,
        @NotNull String state
){}


