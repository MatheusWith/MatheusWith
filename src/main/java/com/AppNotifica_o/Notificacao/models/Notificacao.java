package com.AppNotifica_o.Notificacao.models;

import com.AppNotifica_o.Notificacao.enums.NotificacaoStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Table(name = "notificacoes")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false, length = 500)
    private String mensagem;
    private NotificacaoStatus status;
    @Column( name = "curso_ministrados_ids")
    private Set<UUID> cursosMinistradosIds;
    @Column( name = "salas_ids")
    private Set<UUID> salasIds;
    @Column( name = "cursos_ids")
    private Set<UUID> cursosIds;
    @Column(nullable = false, name = "data_envio")
    private LocalDateTime dataEnvio;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Admin remetente;

    public Notificacao(String titulo, String mensagem, Set<UUID> cursosMinistradosIds, Set<UUID> salasIds, Set<UUID> cursosIds, LocalDateTime dataEnvio, Admin remetente) {
        this.setTitulo(titulo);
        this.setMensagem(mensagem);
        if(cursosMinistradosIds != null) {
            this.setCursosMinistradosIds(cursosMinistradosIds);
        }
        if (salasIds != null) {
            this.setSalasIds(salasIds);
        }
        if (cursosIds != null) {
            this.setCursosIds(cursosIds);
        }
        this.setDataEnvio(dataEnvio);
        this.setRemetente(remetente);
        this.setStatus(NotificacaoStatus.PENDENTE);

    }

    public void cancelarEnvio() {
        if (this.getStatus() != NotificacaoStatus.ENVIADA) {
            this.setStatus(NotificacaoStatus.CANCELADA);
        }
    }
}
