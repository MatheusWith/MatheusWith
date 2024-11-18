package com.AppNotifica_o.Notificacao.repository;

import com.AppNotifica_o.Notificacao.models.Aluno;
import com.AppNotifica_o.Notificacao.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {
    Set<Aluno> findAlunosByCursoIdInOrSalaIdIn(Set<UUID> cursosIds,Set<UUID> salasIds);
}
