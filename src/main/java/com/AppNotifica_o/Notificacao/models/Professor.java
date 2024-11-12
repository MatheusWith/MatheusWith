package com.AppNotifica_o.Notificacao.models;

import com.AppNotifica_o.Notificacao.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Table(name = "professores")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Professor extends User {
    @Column(nullable = false, name = "curso_ministrado")
    private String cursoMinistrado;

    public Professor(String login,String password,String name,String email,String cursoMinistrado) {
        this.setActive(true);
        this.setRole(UserRole.PROFESSOR);
        this.setLogin(login);
        this.setPassword(password);
        this.setEmail(email);
        this.setCursoMinistrado(cursoMinistrado);
        this.setName(name);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_PROFESSOR"));
    }


}
