package com.AppNotifica_o.Notificacao.dtos.sala;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DtoUpdateSala(
        @NotNull
        UUID id,
        String sala
) {
}
