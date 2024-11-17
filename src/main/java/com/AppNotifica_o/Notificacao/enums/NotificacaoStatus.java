package com.AppNotifica_o.Notificacao.enums;

import lombok.Getter;

@Getter
public enum NotificacaoStatus {
    PENDENTE("Pendente"),
    PROCESSANDO("Processando"),
    CANCELADA("Cancelada"),
    ENVIADA("Enviada");

    private String status;

    NotificacaoStatus(String status) {
        this.status = status;
    }
}
