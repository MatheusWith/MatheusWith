package com.AppNotifica_o.Notificacao.dtos.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DtoCreateProfessor(
        @NotBlank
        String login,
        @NotBlank
        String name,
        @NotBlank
        String password,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cursoMinistrado
) {
}