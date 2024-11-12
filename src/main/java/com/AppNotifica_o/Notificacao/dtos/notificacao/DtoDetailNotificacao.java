package com.AppNotifica_o.Notificacao.dtos.notificacao;

import com.AppNotifica_o.Notificacao.models.Notificacao;

import java.time.LocalDateTime;
import java.util.UUID;

public record DtoDetailNotificacao(
        UUID id,
        String titulo,
        String mensagem,
        Boolean enviado,
        String cursoMinistrado,
        String sala,
        String curso,
        LocalDateTime dataEnvio,
        Boolean cancelada
) {
    public DtoDetailNotificacao(Notificacao notificacao) {
        this(
                notificacao.getId(),
                notificacao.getTitulo(),
                notificacao.getMensagem(),
                notificacao.getEnviado(),
                notificacao.getCursoMinistrado(),
                notificacao.getSala(),
                notificacao.getCurso(),
                notificacao.getDataEnvio(),
                notificacao.getCancelada()
        );
    }
}

