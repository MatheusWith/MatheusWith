package com.AppNotifica_o.Notificacao.dtos.aluno;

import com.AppNotifica_o.Notificacao.models.Aluno;

import java.util.UUID;

public record DtoListAluno(
        UUID id,
        String login,
        String name,
        String email,
        String sala,
        String curso,
        Boolean active
) {
    public DtoListAluno(Aluno aluno) {
        this(
                aluno.getId(),
                aluno.getLogin(),
                aluno.getName(),
                aluno.getEmail(),
                aluno.getSala(),
                aluno.getCurso(),
                aluno.getActive()
        );
    }
}
