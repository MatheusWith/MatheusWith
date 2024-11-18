package com.AppNotifica_o.Notificacao.dtos.notificacao;

import com.AppNotifica_o.Notificacao.enums.NotificacaoStatus;
import com.AppNotifica_o.Notificacao.models.Notificacao;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record DtoDetailNotificacao(
        UUID id,
        String titulo,
        String mensagem,
        NotificacaoStatus status,
        Set<UUID> getCursoMinistradosIds,
        Set<UUID> salasIds,
        Set<UUID> cursosIds,
        LocalDateTime dataEnvio
) {
    public DtoDetailNotificacao(Notificacao notificacao) {
        this(
                notificacao.getId(),
                notificacao.getTitulo(),
                notificacao.getMensagem(),
                notificacao.getStatus(),
                notificacao.getCursosMinistradosIds(),
                notificacao.getSalasIds(),
                notificacao.getCursosIds(),
                notificacao.getDataEnvio()
        );
    }
}

