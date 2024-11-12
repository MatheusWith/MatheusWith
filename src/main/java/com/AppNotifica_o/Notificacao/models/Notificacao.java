package com.AppNotifica_o.Notificacao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "notificacoes")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String mensagem;
    private Boolean enviado;
    @Column( name = "curso_ministrado")
    private String cursoMinistrado;
    private String sala;
    private String curso;
    @Column(nullable = false, name = "data_envio")
    private LocalDateTime dataEnvio;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Admin remetente;
    private Boolean cancelada;
}
