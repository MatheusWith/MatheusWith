package com.AppNotifica_o.Notificacao.dtos.curso;

import jakarta.validation.constraints.NotBlank;

public record DtoCreateCurso(
        @NotBlank
        String curso
) {
}
