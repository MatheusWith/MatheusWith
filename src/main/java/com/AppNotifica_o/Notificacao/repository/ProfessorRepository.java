package com.AppNotifica_o.Notificacao.repository;

import com.AppNotifica_o.Notificacao.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
    Set<Professor> findEmailByCursoMinistradoIdIn(Set<UUID> ids);

}
