package com.AppNotifica_o.Notificacao.repository;

import com.AppNotifica_o.Notificacao.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CursoRepository extends JpaRepository<Curso, UUID> {
}
