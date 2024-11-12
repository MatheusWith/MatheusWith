package com.AppNotifica_o.Notificacao.dtos.aluno;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DtoCreateAluno(
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
        String sala,
        @NotBlank
        String curso
) {
}
