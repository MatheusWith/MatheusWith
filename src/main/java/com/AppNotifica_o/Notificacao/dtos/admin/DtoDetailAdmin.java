package com.AppNotifica_o.Notificacao.dtos.admin;

import com.AppNotifica_o.Notificacao.models.Admin;

import java.util.UUID;

public record DtoDetailAdmin(
        UUID id,
        String login,
        String name,
        String email,
        Boolean active
) {
    public DtoDetailAdmin(Admin admin) {
        this(
                admin.getId(),
                admin.getLogin(),
                admin.getName(),
                admin.getEmail(),
                admin.getActive()
        );
    }
}