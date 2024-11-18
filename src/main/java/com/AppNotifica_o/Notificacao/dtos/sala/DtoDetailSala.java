package com.AppNotifica_o.Notificacao.dtos.sala;

import com.AppNotifica_o.Notificacao.models.Sala;

import java.util.UUID;

public record DtoDetailSala(
        UUID id,
        String sala
) {
    public DtoDetailSala(Sala sala) {
        this(sala.getId(),sala.getSala());
    }
}
