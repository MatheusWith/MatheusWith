package com.AppNotifica_o.Notificacao.dtos.user;

import jakarta.validation.constraints.NotBlank;

public record UserAuthDto(
        @NotBlank
        String login,
        @NotBlank
        String password) {
}
