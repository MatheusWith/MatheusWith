package com.AppNotifica_o.Notificacao.dtos.notificacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record DtoCreateNotificacao(
        @NotBlank(message = "Esta faltando o titulo")
        String titulo,
        @NotBlank(message = "A mensagem e essencial")
        String mensagem,
        Set<UUID> cursosIds,
        Set<UUID> cursosMinistradosIds,
        Set<UUID> salasIds,
        @NotNull(message = "Data de envio e obrigatorio")
        LocalDateTime dataEnvio,
        @NotNull(message = "Falta o remetente")
        UUID remetente_id
) {
}
