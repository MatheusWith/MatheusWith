package com.AppNotifica_o.Notificacao.dtos.sala;

import jakarta.validation.constraints.NotBlank;

public record DtoCreateSala(
        @NotBlank
        String sala
) {
}
