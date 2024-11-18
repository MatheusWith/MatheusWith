package com.AppNotifica_o.Notificacao.service;

import com.AppNotifica_o.Notificacao.enums.NotificacaoStatus;
import com.AppNotifica_o.Notificacao.models.Aluno;
import com.AppNotifica_o.Notificacao.models.Notificacao;
import com.AppNotifica_o.Notificacao.models.Professor;
import com.AppNotifica_o.Notificacao.producers.NotificacaoProducer;
import com.AppNotifica_o.Notificacao.repository.AlunoRepository;
import com.AppNotifica_o.Notificacao.repository.NotificacaoRepository;
import com.AppNotifica_o.Notificacao.repository.ProfessorRepository;
import jakarta.transaction.Transactional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;

@Service
public class NotificacaoPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private NotificacaoProducer notificacaoProducer;

    @Value(value = "${broker.queue.notificacao.queue}")
    private String routingKey;

    @Scheduled(fixedRateString= "${spring.task.scheduling.fixedrate}")
    @Transactional
    public void notificacaoPublisher(){
//        Aqui começa o crime ao cleancode, cuidado com seu olhos
        LocalDateTime now = LocalDateTime.now();
        Set<Notificacao> notificacoes = this.notificacaoRepository.findByStatusAndDataEnvio(NotificacaoStatus.PENDENTE,now.truncatedTo(ChronoUnit.MINUTES));

        if(notificacoes.isEmpty()) return;

        for (Notificacao notificacao: notificacoes) {
            notificacao.setStatus(NotificacaoStatus.PROCESSANDO);
        }
        this.notificacaoRepository.saveAll(notificacoes);

        for (Notificacao notificacao: notificacoes) {
            Set<Professor> professores = this.professorRepository.findEmailByCursoMinistradoIdIn(notificacao.getCursosMinistradosIds());
            if (!professores.isEmpty()) {
                for (Professor professor : professores) {
                    this.notificacaoProducer.publisherMessageEmail(notificacao,professor.getEmail());
                }
            }

            Set<Aluno> alunos = this.alunoRepository.findAlunosByCursoIdInOrSalaIdIn(notificacao.getCursosIds(),notificacao.getSalasIds());
            if (!alunos.isEmpty()) {
                for (Aluno aluno : alunos) {
                    this.notificacaoProducer.publisherMessageEmail(notificacao,aluno.getEmail());
                }
            }

            notificacao.setStatus(NotificacaoStatus.ENVIADA);
        }

        this.notificacaoRepository.saveAll(notificacoes);
    }
}
