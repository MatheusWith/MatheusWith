package com.AppNotifica_o.Notificacao.dtos.notificacao;

import com.AppNotifica_o.Notificacao.models.Notificacao;

import java.util.UUID;

public record DtoEmailNotificacao(
        UUID id,
        UUID remetenteId,
        String emailTo,
        String subject,
        String message
) {
    public DtoEmailNotificacao(Notificacao notificacao, String emailTo) {
        this(
                notificacao.getId(),
                notificacao.getRemetente().getId(),
                emailTo,
                notificacao.getTitulo(),
                notificacao.getMensagem()
        );
    }

}
