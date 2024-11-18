package com.AppNotifica_o.Notificacao.dtos.notificacao;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record DtoUpdateNotificacao(
        @NotNull
        UUID id,
        String titulo,
        String mensagem,
        Set<UUID> cursoMinistrado,
        Set<UUID> salasIds,
        Set<UUID> cursosIds,
        LocalDateTime dataEnvio
) {
}