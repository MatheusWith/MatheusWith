package com.AppNotifica_o.Notificacao.service;

import com.AppNotifica_o.Notificacao.dtos.professor.DtoCreateProfessor;
import com.AppNotifica_o.Notificacao.dtos.professor.DtoDetailProfessor;
import com.AppNotifica_o.Notificacao.dtos.professor.DtoListProfessor;
import com.AppNotifica_o.Notificacao.dtos.professor.DtoUpdateProfessor;
import com.AppNotifica_o.Notificacao.models.CursoMinistrado;
import com.AppNotifica_o.Notificacao.models.Professor;
import com.AppNotifica_o.Notificacao.repository.CursoMinistradoRepository;
import com.AppNotifica_o.Notificacao.repository.ProfessorRepository;
import com.AppNotifica_o.Notificacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CursoMinistradoRepository cursoMinistradoRepository;

    public DtoDetailProfessor createProfessor(DtoCreateProfessor data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        CursoMinistrado cursoMinistrado = this.cursoMinistradoRepository.getReferenceById(data.cursoMinistradoId());

        Professor professor = new Professor(data.login(),encryptedPassword,data.name(),data.email(),cursoMinistrado);
        this.professorRepository.save(professor);
        return new DtoDetailProfessor(professor);
    }

    public DtoDetailProfessor updateProfessor(DtoUpdateProfessor data) {
        var professor = this.professorRepository.getReferenceById(data.id());
        if (data.login() != null) {
            if (this.userRepository.findByLogin(data.login()) == null) {
                professor.setLogin(data.login());
            }
        }
        if (data.name() != null) {
            professor.setName(data.name());
        }
        if (data.password() != null) {
            String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
            professor.setPassword(encryptedPassword);
        }
        if (data.email() != null) {
            professor.setEmail(data.email());
        }
        if (data.active() != null) {
            professor.setActive(data.active());
        }
        if (data.cursoMinistradoId() != null) {
            CursoMinistrado cursoMinistrado = this.cursoMinistradoRepository.getReferenceById(data.cursoMinistradoId());
            professor.setCursoMinistrado(cursoMinistrado);
        }

        return new DtoDetailProfessor(this.professorRepository.save(professor));
    }

    public DtoDetailProfessor getProfessor(UUID id) {
        var professor = this.professorRepository.getReferenceById(id);
        return new DtoDetailProfessor(professor);
    }

    public Page<DtoListProfessor> getAllProfessor(Pageable pageable) {
        return this.professorRepository.findAll(pageable).map(DtoListProfessor::new);
    }

    public void deactivate(UUID id) {
        var professor = this.professorRepository.getReferenceById(id);
        professor.deactivate();
    }
}
