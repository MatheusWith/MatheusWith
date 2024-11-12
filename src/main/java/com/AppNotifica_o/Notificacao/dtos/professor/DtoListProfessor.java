package com.AppNotifica_o.Notificacao.dtos.professor;

import com.AppNotifica_o.Notificacao.models.Professor;

import java.util.UUID;

public record DtoListProfessor(
        UUID id,
        String login,
        String name,
        String email,
        String cursoMinistrado,
        Boolean active
) {
    public DtoListProfessor(Professor professor) {
        this(
                professor.getId(),
                professor.getLogin(),
                professor.getName(),
                professor.getEmail(),
                professor.getCursoMinistrado(),
                professor.getActive()
        );
    }
}
