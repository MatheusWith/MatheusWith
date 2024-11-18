package com.AppNotifica_o.Notificacao.dtos.cursoMinistrado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DtoCreateCursoMinistrado(
        @NotNull
        String cursoMinistrado
) {
}
