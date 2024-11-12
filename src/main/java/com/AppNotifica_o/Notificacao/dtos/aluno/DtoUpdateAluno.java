package com.AppNotifica_o.Notificacao.dtos.aluno;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DtoUpdateAluno(
        @NotNull
        UUID id,
        String login,
        String name,
        String password,
        @Email
        String email,
        String sala,
        String curso,
        Boolean active
) {
}
