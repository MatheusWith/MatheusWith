package com.AppNotifica_o.Notificacao.producers;

import com.AppNotifica_o.Notificacao.dtos.notificacao.DtoEmailNotificacao;
import com.AppNotifica_o.Notificacao.models.Notificacao;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class NotificacaoProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.notificacao.queue}")
    private String routingKey;
    @Value("${broker.queue.notificacao.exchange}")
    private String exchange;
    @Value("${meu.email}")
    private String email;

    public void publisherMessageEmail(Notificacao notificacao) {
        var data = new DtoEmailNotificacao(notificacao,this.email);
        this.rabbitTemplate.convertAndSend(this.exchange,this.routingKey,data);
    }

}