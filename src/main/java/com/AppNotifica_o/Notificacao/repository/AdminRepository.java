package com.AppNotifica_o.Notificacao.repository;

import com.AppNotifica_o.Notificacao.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
