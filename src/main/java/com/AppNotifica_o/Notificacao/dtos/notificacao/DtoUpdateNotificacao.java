package com.AppNotifica_o.Notificacao.dtos.notificacao;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record DtoUpdateNotificacao(
        @NotNull
        UUID id,
        String titulo,
        String mensagem,
        String cursoMinistrado,
        String sala,
        String curso,
        LocalDateTime dataEnvio
) {
}