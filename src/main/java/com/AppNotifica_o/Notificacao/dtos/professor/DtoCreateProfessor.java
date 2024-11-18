package com.AppNotifica_o.Notificacao.dtos.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DtoCreateProfessor(
        @NotBlank(message = "O campo de login não pode estar vazio")
        String login,
        @NotBlank(message = "O campo de nome não pode estar vazio")
        String name,
        @NotBlank(message = "O campo de senha não pode estar vazio")
        String password,
        @NotBlank(message = "O campo de email não pode estar vazio")
        @Email(message = "O presente campo deve está no padrão do email")
        String email,
        @NotNull(message = "O campo curso ministrado não pode estar vazio")
        UUID cursoMinistradoId
) {
}