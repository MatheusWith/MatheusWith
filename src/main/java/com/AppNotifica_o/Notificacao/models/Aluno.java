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

@Table(name = "alunos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Aluno extends User {
    @Column(nullable = false)
    private String sala;
    @Column(nullable = false)
    private String curso;

    public Aluno(String login, String password, String name,String email,String sala,String curso) {
        this.setActive(true);
        this.setRole(UserRole.ALUNO);
        this.setLogin(login);
        this.setPassword(password);
        this.setEmail(email);
        this.setName(name);
        this.setSala(sala);
        this.setCurso(curso);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_ALUNO"));
    }
}
