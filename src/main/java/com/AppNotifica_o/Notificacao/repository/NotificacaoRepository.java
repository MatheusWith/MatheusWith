package com.AppNotifica_o.Notificacao.repository;
import com.AppNotifica_o.Notificacao.enums.NotificacaoStatus;
import com.AppNotifica_o.Notificacao.models.Notificacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

public interface NotificacaoRepository extends JpaRepository<Notificacao, UUID> {
    Page<Notificacao> findAllByRemetenteId(UUID adminId, Pageable pageable);
    Notificacao findByIdAndRemetenteId(UUID notificacaoId, UUID remetenteId);
    Set<Notificacao> findByStatusAndDataEnvioBetween(NotificacaoStatus status, LocalDateTime startDataEnvio,LocalDateTime endDataEnvio);
}