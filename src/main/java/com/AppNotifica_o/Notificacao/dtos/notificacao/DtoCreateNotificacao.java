package com.AppNotifica_o.Notificacao.dtos.notificacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DtoCreateNotificacao(
        @NotBlank(message = "Esta faltando o titulo")
        String titulo,
        @NotBlank(message = "A mensagem e essencial")
        String mensagem,
        String curso,
        String cursoMinistrado,
        String sala,
        @NotNull(message = "Data de envio e obrigatorio")
        LocalDateTime dataEnvio,
        @NotNull(message = "Falta o remetente")
        Long remetente_id
) {
}
