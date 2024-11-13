package com.AppNotifica_o.Notificacao.service;

import com.AppNotifica_o.Notificacao.models.Notificacao;
import com.AppNotifica_o.Notificacao.producers.NotificacaoProducer;
import com.AppNotifica_o.Notificacao.repository.NotificacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class NotificacaoPublisher {
    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private NotificacaoProducer notificacaoProducer;

    @Scheduled(fixedRateString= "${spring.task.scheduling.fixedrate}")
    @Transactional
    public void notificacaoPublisher(){
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        Set<Notificacao> notificacoes = this.notificacaoRepository.findBydataEnvioAndCanceladaFalseAndEnviadoFalse(now.truncatedTo(ChronoUnit.MINUTES));

        if(notificacoes.isEmpty()) return;

        List<Notificacao> notificacaoesEnviadas = new ArrayList<>();

        for (Notificacao notificacao: notificacoes) {
            this.notificacaoProducer.publisherMessageEmail(notificacao);

            notificacao.setEnviado(true);
            notificacaoesEnviadas.add(notificacao);
        }

        this.notificacaoRepository.saveAll(notificacaoesEnviadas);
    }
}
