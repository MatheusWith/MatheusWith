package com.AppNotifica_o.Notificacao.models;


import com.AppNotifica_o.Notificacao.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Table(name = "alunos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Aluno extends User {
    @ManyToOne
    @JoinColumn(name = "sala_id",nullable = false)
    private Sala sala;
    @Column(nullable = false)
    private String curso;

    public Aluno(String login, String password, String name,String email,Sala sala,String curso) {
        this.setActive(true);
        this.setRole(UserRole.ALUNO);
        this.setLogin(login);
        this.setPassword(password);
        this.setEmail(email);
        this.setName(name);
        this.setSala(sala);
        this.setCurso(curso);
        this.setActive(true);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_ALUNO"));
    }
}
