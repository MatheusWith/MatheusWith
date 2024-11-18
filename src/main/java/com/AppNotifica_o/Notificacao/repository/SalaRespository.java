package com.AppNotifica_o.Notificacao.repository;

import com.AppNotifica_o.Notificacao.models.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalaRespository extends JpaRepository<Sala, UUID> {
}
