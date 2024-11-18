package com.AppNotifica_o.Notificacao.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Table(name = "cursos")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToMany(mappedBy = "curso",orphanRemoval = true)
    private Set<Aluno> alunos;
    private String curso;

    public Curso(String curso) {
        this.setCurso(curso);
    }
}
