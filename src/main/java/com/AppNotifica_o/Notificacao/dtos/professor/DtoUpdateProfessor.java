package com.AppNotifica_o.Notificacao.dtos.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DtoUpdateProfessor(
        @NotNull
        UUID id,
        String login,
        String name,
        String password,
        @Email
        String email,
        String cursoMinistrado,
        Boolean active
) {
}