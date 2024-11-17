package com.AppNotifica_o.Notificacao.dtos.notificacao;

import com.AppNotifica_o.Notificacao.enums.NotificacaoStatus;
import com.AppNotifica_o.Notificacao.models.Notificacao;

import java.time.LocalDateTime;
import java.util.UUID;

public record DtoDetailNotificacao(
        UUID id,
        String titulo,
        String mensagem,
        NotificacaoStatus status,
        String cursoMinistrado,
        String sala,
        String curso,
        LocalDateTime dataEnvio
) {
    public DtoDetailNotificacao(Notificacao notificacao) {
        this(
                notificacao.getId(),
                notificacao.getTitulo(),
                notificacao.getMensagem(),
                notificacao.getStatus(),
                notificacao.getCursoMinistrado(),
                notificacao.getSala(),
                notificacao.getCurso(),
                notificacao.getDataEnvio()
        );
    }
}

