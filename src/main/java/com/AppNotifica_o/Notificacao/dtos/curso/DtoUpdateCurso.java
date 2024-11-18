package com.AppNotifica_o.Notificacao.dtos.curso;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DtoUpdateCurso(
        @NotNull
        UUID id,
        String curso
) {
}
