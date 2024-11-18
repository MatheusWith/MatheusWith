package com.AppNotifica_o.Notificacao.service;

import com.AppNotifica_o.Notificacao.dtos.cursoMinistrado.DtoCreateCursoMinistrado;
import com.AppNotifica_o.Notificacao.dtos.cursoMinistrado.DtoDetailCursoMinistrado;
import com.AppNotifica_o.Notificacao.dtos.cursoMinistrado.DtoListCursoMinistrado;
import com.AppNotifica_o.Notificacao.dtos.cursoMinistrado.DtoUpdateCursoMinistrado;
import com.AppNotifica_o.Notificacao.models.CursoMinistrado;
import com.AppNotifica_o.Notificacao.repository.CursoMinistradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CursoMinistradoService {
    @Autowired
    private CursoMinistradoRepository cursoMinistradoRepository;

    public DtoDetailCursoMinistrado createCursoMinistrado(DtoCreateCursoMinistrado data) {
        CursoMinistrado cursoMinistrado = new CursoMinistrado(data.cursoMinistrado());
        this.cursoMinistradoRepository.save(cursoMinistrado);
        return new DtoDetailCursoMinistrado(cursoMinistrado);
    }

    public DtoDetailCursoMinistrado updateCursoMinistrado(DtoUpdateCursoMinistrado data) {
        var cursoMinistrado = this.cursoMinistradoRepository.getReferenceById(data.id());
        if (data.cursoMinistrado() != null) {
            cursoMinistrado.setCursoMinistrado(data.cursoMinistrado());
        }
        this.cursoMinistradoRepository.save(cursoMinistrado);
        return new DtoDetailCursoMinistrado(cursoMinistrado);
    }

    public DtoDetailCursoMinistrado getCursMinistrado(UUID id) {
        var cursoMinistrado = this.cursoMinistradoRepository.getReferenceById(id);
        return new DtoDetailCursoMinistrado(cursoMinistrado);
    }

    public Page<DtoListCursoMinistrado> getAllCursoMinistrado(Pageable pageable) {
        return this.cursoMinistradoRepository.findAll(pageable).map(DtoListCursoMinistrado::new);
    }
    public void delete(UUID id) {
        var cursoMinistrado = this.cursoMinistradoRepository.getReferenceById(id);
        this.cursoMinistradoRepository.delete(cursoMinistrado);
    }

}
