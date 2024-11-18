package com.AppNotifica_o.Notificacao.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Table(name = "cursos_ministrados")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class CursoMinistrado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToMany(mappedBy = "cursoMinistrado",orphanRemoval = true)
    private Set<Professor> professores;
    @Column(nullable = false)
    private String cursoMinistrado;

    public CursoMinistrado(String cursoMinistrado) {
        this.setCursoMinistrado(cursoMinistrado);
    }

}
