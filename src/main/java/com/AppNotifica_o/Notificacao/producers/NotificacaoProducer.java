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

    @Value("${broker.queue.email.name}")
    private String routingKey;
    @Value("${meu.mail}")
    private String email;

    public void publisherMessageEmail(Notificacao notificacao) {
        var data = new DtoEmailNotificacao(notificacao,this.email);
        this.rabbitTemplate.convertAndSend("",this.routingKey,data);
        System.out.println(data);
    }

}
