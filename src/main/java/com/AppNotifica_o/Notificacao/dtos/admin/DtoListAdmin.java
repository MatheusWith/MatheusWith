package com.AppNotifica_o.Notificacao.dtos.admin;

import com.AppNotifica_o.Notificacao.models.Admin;

import java.util.UUID;

public record DtoListAdmin(
        UUID id,
        String login,
        String name,
        String email,
        Boolean active
) {
    public DtoListAdmin(Admin admin) {
        this(
                admin.getId(),
                admin.getLogin(),
                admin.getName(),
                admin.getEmail(),
                admin.getActive()
        );
    }
}
