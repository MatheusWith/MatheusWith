package com.AppNotifica_o.Notificacao.dtos.aluno;


import com.AppNotifica_o.Notificacao.models.Sala;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DtoUpdateAluno(
        @NotNull
        UUID id,
        String login,
        String name,
        String password,
        @Email(message = "O presente campo deve está no padrão do email")
        String email,
        UUID salaId,
        UUID cursoId,
        Boolean active
) {
}
