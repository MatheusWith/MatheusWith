package com.AppNotifica_o.Notificacao.repository;

import com.AppNotifica_o.Notificacao.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {
}
