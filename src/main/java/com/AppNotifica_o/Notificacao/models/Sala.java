package com.AppNotifica_o.Notificacao.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "salas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToMany(mappedBy = "sala",orphanRemoval = true)
    private Set<Aluno> alunos;
    private String sala;

    public Sala(String sala) {
        this.setSala(sala);
    }
}
