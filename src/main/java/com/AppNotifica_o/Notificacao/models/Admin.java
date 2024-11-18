package com.AppNotifica_o.Notificacao.models;

import com.AppNotifica_o.Notificacao.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Table(name = "admins")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Admin extends User {

    @OneToMany(mappedBy = "remetente")
    private Set<Notificacao> notificacoes;

    public Admin(String login, String password, String name,String email) {
        this.setActive(true);
        this.setRole(UserRole.ADMIN);
        this.setLogin(login);
        this.setPassword(password);
        this.setName(name);
        this.setEmail(email);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

}
