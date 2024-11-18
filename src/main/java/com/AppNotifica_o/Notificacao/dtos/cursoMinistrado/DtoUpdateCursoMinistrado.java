package com.AppNotifica_o.Notificacao.dtos.cursoMinistrado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DtoUpdateCursoMinistrado(
        @NotNull
        UUID id,
        String cursoMinistrado
) {
}
