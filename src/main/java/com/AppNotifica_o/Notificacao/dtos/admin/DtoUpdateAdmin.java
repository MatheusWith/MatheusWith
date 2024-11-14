package com.AppNotifica_o.Notificacao.dtos.admin;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DtoUpdateAdmin(
        @NotNull
        UUID id,
        String login,
        String name,
        String password,
        @Email(message = "O presente campo deve estar no padrão do email")
        String email,
        Boolean active
) {
}
