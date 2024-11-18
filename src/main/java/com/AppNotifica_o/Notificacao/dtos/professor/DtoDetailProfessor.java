package com.AppNotifica_o.Notificacao.dtos.professor;

import com.AppNotifica_o.Notificacao.models.Professor;

import java.util.UUID;

public record DtoDetailProfessor(
        UUID id,
        String login,
        String name,
        String email,
        String cursoMinistrado,
        Boolean active
) {
    public DtoDetailProfessor(Professor professor) {
        this(
                professor.getId(),
                professor.getLogin(),
                professor.getName(),
                professor.getEmail(),
                professor.getCursoMinistrado().getCursoMinistrado(),
                professor.getActive()
        );
    }
}
