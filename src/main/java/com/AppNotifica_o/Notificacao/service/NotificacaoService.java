package com.AppNotifica_o.Notificacao.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class NotificacaoService {

    public DtoDetailNotificacao createNotificacao(DtoCreateNotificacao data) {
        var admin = this.adminRespository.getReferenceById(data.remetente_id());
        Set<Professor> destinatariosProfessor = new HashSet<>(this.professorRepository.findByCursoMinistradoAndActiveTrue(data.cursoMinistrado()));
        Set<Aluno> destinatariosAluno = new HashSet<>(this.alunoRespository.findBySalaOrCursoAndActiveTrue(data.sala(), data.curso()));
        Set<User> destinariosUser = new HashSet<>();

        destinariosUser.addAll(destinatariosProfessor);
        destinariosUser.addAll(destinatariosAluno);


        Notificacao notificacao = new Notificacao(
                data.titulo(),
                data.mensagem(),
                data.cursoMinistrado(),
                data.sala(),
                data.curso(),
                data.dataEnvio(),
                admin,
                destinariosUser
        );
        this.notificacaoRepository.save(notificacao);
        return new DtoDetailNotificacao(notificacao);
    }
}
