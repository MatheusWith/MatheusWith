package com.AppNotifica_o.Notificacao.service;

import com.AppNotifica_o.Notificacao.enums.NotificacaoStatus;
import com.AppNotifica_o.Notificacao.models.Notificacao;
import com.AppNotifica_o.Notificacao.producers.NotificacaoProducer;
import com.AppNotifica_o.Notificacao.repository.NotificacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private NotificacaoProducer notificacaoProducer;

    @Value(value = "${broker.queue.notificacao.queue}")
    private String routingKey;

    public record TesteDTO(String teste) {
    }

    @Scheduled(fixedRateString= "${spring.task.scheduling.fixedrate}")
    @Transactional
    public void notificacaoPublisher(){
        LocalDateTime now = LocalDateTime.now();
        Set<Notificacao> notificacoes = this.notificacaoRepository.findByStatusAndDataEnvioBetween(NotificacaoStatus.PENDENTE,now,now.plusMinutes(1));

        if(notificacoes.isEmpty()) return;

        for (Notificacao notificacao: notificacoes) {
            notificacao.setStatus(NotificacaoStatus.PROCESSANDO);
        }
        this.notificacaoRepository.saveAll(notificacoes);

        for (Notificacao notificacao: notificacoes) {
            this.notificacaoProducer.publisherMessageEmail(notificacao);

            notificacao.setStatus(NotificacaoStatus.ENVIADA);
        }

        this.notificacaoRepository.saveAll(notificacoes);
    }
}
