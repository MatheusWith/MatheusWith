package com.AppNotifica_o.Notificacao.service;

import com.AppNotifica_o.Notificacao.dtos.aluno.DtoCreateAluno;
import com.AppNotifica_o.Notificacao.dtos.aluno.DtoDetailAluno;
import com.AppNotifica_o.Notificacao.dtos.aluno.DtoListAluno;
import com.AppNotifica_o.Notificacao.dtos.aluno.DtoUpdateAluno;
import com.AppNotifica_o.Notificacao.models.Aluno;
import com.AppNotifica_o.Notificacao.repository.AlunoRepository;
import com.AppNotifica_o.Notificacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AlunoService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AlunoRepository alunoRespository;

    public DtoDetailAluno createAluno(DtoCreateAluno data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Aluno aluno = new Aluno(data.login(),encryptedPassword,data.name(), data.email(), data.sala(), data.curso());
        this.alunoRespository.save(aluno);
        return new DtoDetailAluno(aluno);
    }

    public DtoDetailAluno updateAluno(DtoUpdateAluno data) {
        var aluno = this.alunoRespository.getReferenceById(data.id());
        if (data.login() != null) {
            if (this.userRepository.findByLogin(data.login()) == null) {
                aluno.setLogin(data.login());
            }
        }
        if (data.name() != null) {
            aluno.setName(data.name());
        }
        if (data.password() != null) {
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            aluno.setPassword(encryptedPassword);
        }
        if (data.email() != null) {
            aluno.setEmail(data.email());
        }
        if (data.active() != aluno.getActive()) {
            aluno.setActive(data.active());
        }
        if (data.sala() != null) {
            aluno.setSala(data.sala());
        }
        this.alunoRespository.save(aluno);
        return new DtoDetailAluno(aluno);
    }

    public DtoDetailAluno getAluno(UUID id) {
        var aluno = this.alunoRespository.getReferenceById(id);
        return new DtoDetailAluno(aluno);
    }

    public Page<DtoListAluno> getAllAluno(Pageable pageable) {
        return this.alunoRespository.findAll(pageable).map(DtoListAluno::new);
    }

    public void deactivate(UUID id) {
        var aluno = this.userRepository.getReferenceById(id);
        aluno.deactivate();
    }

}
