package com.AppNotifica_o.Notificacao.dtos.notificacao;

import com.AppNotifica_o.Notificacao.enums.NotificacaoStatus;
import com.AppNotifica_o.Notificacao.models.Notificacao;

import java.time.LocalDateTime;
import java.util.UUID;

public record DtoListNotificacao(
        UUID id,
        String titulo,
        String mensagem,
        NotificacaoStatus status,
        LocalDateTime dataEnvio

) {
    public DtoListNotificacao(Notificacao notificacao) {
        this(
                notificacao.getId(),
                notificacao.getTitulo(),
                notificacao.getMensagem(),
                notificacao.getStatus(),
                notificacao.getDataEnvio()
        );
    }

}