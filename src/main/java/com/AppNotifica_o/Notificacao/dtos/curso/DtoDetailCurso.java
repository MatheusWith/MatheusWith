package com.AppNotifica_o.Notificacao.dtos.curso;

import com.AppNotifica_o.Notificacao.models.Curso;

import java.util.UUID;

public record DtoDetailCurso(
        UUID id,
        String curso
) {
    public DtoDetailCurso(Curso curso) {
        this(
                curso.getId(),
                curso.getCurso()
        );
    }
}
