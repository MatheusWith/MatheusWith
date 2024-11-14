package com.AppNotifica_o.Notificacao.dtos.aluno;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DtoCreateAluno(
        @NotBlank(message = "O campo de login não pode estar vazio")
        String login,
        @NotBlank(message = "O campo de nome não pode estar vazio")
        String name,
        @NotBlank(message = "O campo de senha não pode estar vazio")
        String password,
        @NotBlank(message = "O campo de email não pode estar vazio")
        @Email(message = "O presente campo deve está no padrão do email")
        String email,
        @NotBlank(message = "O campo sala não pode estar vazio")
        String sala,
        @NotBlank(message = "O campo curso não pode estar vazio")
        String curso
) {
}
