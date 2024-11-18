package com.AppNotifica_o.Notificacao.service;

import com.AppNotifica_o.Notificacao.dtos.sala.DtoCreateSala;
import com.AppNotifica_o.Notificacao.dtos.sala.DtoDetailSala;
import com.AppNotifica_o.Notificacao.dtos.sala.DtoListSala;
import com.AppNotifica_o.Notificacao.dtos.sala.DtoUpdateSala;
import com.AppNotifica_o.Notificacao.models.Sala;
import com.AppNotifica_o.Notificacao.repository.SalaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SalaService {
    @Autowired
    private SalaRespository salaRespository;

    public DtoDetailSala createSala(DtoCreateSala data) {
        Sala sala = new Sala(data.sala());
        this.salaRespository.save(sala);
        return new DtoDetailSala(sala);
    }

    public DtoDetailSala updateSala(DtoUpdateSala data) {
        var sala = this.salaRespository.getReferenceById(data.id());
        if (data.sala() != null) {
            sala.setSala(data.sala());
        }
        this.salaRespository.save(sala);
        return new DtoDetailSala(sala);
    }

    public DtoDetailSala getSala(UUID id) {
        var sala = this.salaRespository.getReferenceById(id);
        return new DtoDetailSala(sala);
    }

    public Page<DtoListSala> getAllSala(Pageable pageable) {
        return this.salaRespository.findAll(pageable).map(DtoListSala::new);
    }

    public void delete(UUID id) {
        var sala = this.salaRespository.getReferenceById(id);

        this.salaRespository.delete(sala);
    }
}
