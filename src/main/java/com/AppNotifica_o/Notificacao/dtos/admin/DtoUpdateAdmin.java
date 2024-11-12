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
        @Email
        String email,
        Boolean active
) {
}
