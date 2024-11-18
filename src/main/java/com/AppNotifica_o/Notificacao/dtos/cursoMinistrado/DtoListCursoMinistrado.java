package com.AppNotifica_o.Notificacao.dtos.cursoMinistrado;

import com.AppNotifica_o.Notificacao.models.CursoMinistrado;

import java.util.UUID;

public record DtoListCursoMinistrado(
        UUID id,
        String cursoMinistrado
) {
    public DtoListCursoMinistrado(CursoMinistrado cursoMinistrado) {
        this(cursoMinistrado.getId(),cursoMinistrado.getCursoMinistrado());
    }
}
