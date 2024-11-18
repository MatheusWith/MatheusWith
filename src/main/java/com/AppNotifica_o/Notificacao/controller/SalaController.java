package com.AppNotifica_o.Notificacao.controller;

import com.AppNotifica_o.Notificacao.dtos.sala.DtoCreateSala;
import com.AppNotifica_o.Notificacao.dtos.sala.DtoListSala;
import com.AppNotifica_o.Notificacao.dtos.sala.DtoUpdateSala;
import com.AppNotifica_o.Notificacao.service.SalaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.hibernate.event.spi.ResolveNaturalIdEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aluno/sala")
public class SalaController {
    @Autowired
    private SalaService salaService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DtoCreateSala data){
        var sala = this.salaService.createSala(data);
        return ResponseEntity.ok(sala);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable UUID id) {
        var sala = this.salaService.getSala(id);
        return ResponseEntity.ok(sala);
    }

    @GetMapping
    public ResponseEntity<Page<DtoListSala>> list(@PageableDefault Pageable pageable) {
        var page = this.salaService.getAllSala(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DtoUpdateSala data) {
        var sala = this.salaService.updateSala(data);
        return ResponseEntity.ok(sala);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable UUID id) {
        this.salaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
