package com.AppNotifica_o.Notificacao.dtos.curso;

import com.AppNotifica_o.Notificacao.models.Curso;

import java.util.UUID;

public record DtoListCurso(
        UUID id,
        String curso
) {
    public DtoListCurso(Curso curso) {
        this(curso.getId(),curso.getCurso());
    }
}
