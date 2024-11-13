package com.AppNotifica_o.Notificacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NotificacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificacaoApplication.class, args);
	}

}
