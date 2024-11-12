package com.AppNotifica_o.Notificacao.dtos.admin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DtoCreateAdmin(
        @NotBlank
        String login,
        @NotBlank
        String name,
        @NotBlank
        String password,
        @NotBlank
        @Email
        String email
) {
}