package com.AppNotifica_o.Notificacao.enums;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("Admin"),
    PROFESSOR("Professor"),
    ALUNO("Aluno");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

}
