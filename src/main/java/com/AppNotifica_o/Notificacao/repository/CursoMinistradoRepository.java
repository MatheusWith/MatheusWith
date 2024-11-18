package com.AppNotifica_o.Notificacao.repository;

import com.AppNotifica_o.Notificacao.models.CursoMinistrado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CursoMinistradoRepository extends JpaRepository<CursoMinistrado, UUID> {
}
