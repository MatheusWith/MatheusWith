package com.AppNotifica_o.Notificacao.dtos.sala;

import com.AppNotifica_o.Notificacao.models.Sala;

import java.util.UUID;

public record DtoListSala(
        UUID id,
        String sala
) {
    public DtoListSala(Sala sala) {
        this(sala.getId(),sala.getSala());
    }
}
