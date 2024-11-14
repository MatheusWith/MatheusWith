package com.AppNotifica_o.Notificacao.dtos.user;

import jakarta.validation.constraints.NotBlank;

public record UserAuthDto(
        @NotBlank(message = "O campo de login não pode estar vazio")
        String login,
        @NotBlank(message = "O campo de senha não pode está vazio")
        String password) {
}
