package com.AppNotifica_o.Notificacao.service;

import com.AppNotifica_o.Notificacao.dtos.curso.DtoCreateCurso;
import com.AppNotifica_o.Notificacao.dtos.curso.DtoDetailCurso;
import com.AppNotifica_o.Notificacao.dtos.curso.DtoListCurso;
import com.AppNotifica_o.Notificacao.dtos.curso.DtoUpdateCurso;
import com.AppNotifica_o.Notificacao.models.Curso;
import com.AppNotifica_o.Notificacao.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public DtoDetailCurso createCurso(DtoCreateCurso data) {
        Curso curso = new Curso(data.curso());
        this.cursoRepository.save(curso);
        return new DtoDetailCurso(curso);
    }

    public DtoDetailCurso updateCurso(DtoUpdateCurso data) {
        var curso = this.cursoRepository.getReferenceById(data.id());
        if (data.curso() != null) {
            curso.setCurso(data.curso());
        }
        this.cursoRepository.save(curso);
        return new DtoDetailCurso(curso);
    }

    public DtoDetailCurso getCurso(UUID id) {
        var curso = this.cursoRepository.getReferenceById(id);
        return new DtoDetailCurso(curso);
    }

    public Page<DtoListCurso> getAllCurso(Pageable pageable) {
        return this.cursoRepository.findAll(pageable).map(DtoListCurso::new);
    }

    public void delete(UUID id) {
        var curso = this.cursoRepository.getReferenceById(id);
        this.cursoRepository.delete(curso);
    }


}
