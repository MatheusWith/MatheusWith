package com.AppNotifica_o.Notificacao.models;

import com.AppNotifica_o.Notificacao.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;


@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    private Boolean active;
    private UserRole role;

    public void deactivate() {
        if(this.getActive()) {
            this.setActive(false);
        }
    }

    public void activate() {
        if (!this.getActive()) {
            this.setActive(true);
        }
    }




}
