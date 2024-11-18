package com.AppNotifica_o.Notificacao.models;

import com.AppNotifica_o.Notificacao.enums.UserRole;
import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "curso_ministrado_id", nullable = false)
    private CursoMinistrado cursoMinistrado;

    public Professor(String login,String password,String name,String email,CursoMinistrado cursoMinistrado) {
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
