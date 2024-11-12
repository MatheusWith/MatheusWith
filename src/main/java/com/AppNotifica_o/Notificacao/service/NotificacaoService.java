package com.AppNotifica_o.Notificacao.service;

import com.AppNotifica_o.Notificacao.dtos.notificacao.DtoCreateNotificacao;
import com.AppNotifica_o.Notificacao.dtos.notificacao.DtoDetailNotificacao;
import com.AppNotifica_o.Notificacao.dtos.notificacao.DtoListNotificacao;
import com.AppNotifica_o.Notificacao.dtos.notificacao.DtoUpdateNotificacao;
import com.AppNotifica_o.Notificacao.models.Notificacao;
import com.AppNotifica_o.Notificacao.repository.AdminRepository;
import com.AppNotifica_o.Notificacao.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class NotificacaoService {
    @Autowired
    private NotificacaoRepository notificacaoRepository;
    @Autowired
    private AdminRepository adminRepository;

    public DtoDetailNotificacao createNotificacao(DtoCreateNotificacao data) {
        var admin = this.adminRepository.getReferenceById(data.remetente_id());
        Notificacao notificacao = new Notificacao(
                data.titulo(),
                data.mensagem(),
                data.cursoMinistrado(),
                data.sala(),
                data.curso(),
                data.dataEnvio(),
                admin
        );
        this.notificacaoRepository.save(notificacao);
        return new DtoDetailNotificacao(notificacao);
    }

    public DtoDetailNotificacao updateNotificacao(DtoUpdateNotificacao data) {
        var notificacao = this.notificacaoRepository.getReferenceById(data.id());
        if (!notificacao.getEnviado()){
            if (data.titulo() != null) {
                notificacao.setTitulo(data.titulo());
            }
            if (data.mensagem() != null) {
                notificacao.setMensagem(data.mensagem());
            }
            if (data.cursoMinistrado() != null) {
                notificacao.setCursoMinistrado(data.cursoMinistrado());
            }
            if (data.sala() != null) {
                notificacao.setSala(data.sala());
            }
            if (data.curso() != null) {
                notificacao.setCurso(data.curso());
            }
            if (data.dataEnvio() != null) {
                notificacao.setDataEnvio(data.dataEnvio());
            }
            this.notificacaoRepository.save(notificacao);
        }
        return new DtoDetailNotificacao(notificacao);
    }

    public DtoDetailNotificacao getNotificacao(UUID notificacaoId, UUID remetenteId) {
        var notificacao = this.notificacaoRepository.findByIdAndRemetenteId(notificacaoId,remetenteId);
        return new DtoDetailNotificacao(notificacao);
    }
    public Page<DtoListNotificacao> getAllNotificacao(UUID remetenteId, Pageable pageable) {
        return this.notificacaoRepository.findAllByRemetenteId(remetenteId,pageable).map(DtoListNotificacao::new);
    }

    public void cancelaEnvio(UUID id) {
        var notificacao = this.notificacaoRepository.getReferenceById(id);
        notificacao.cancelarEnvio();
    }
}
