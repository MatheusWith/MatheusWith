package com.AppNotifica_o.Notificacao.dtos.aluno;

import com.AppNotifica_o.Notificacao.models.Aluno;
import com.AppNotifica_o.Notificacao.models.Sala;

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
                aluno.getSala().getSala(),
                aluno.getCurso().getCurso(),
                aluno.getActive()
        );
    }
}
