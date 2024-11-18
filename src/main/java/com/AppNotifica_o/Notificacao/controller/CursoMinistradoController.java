package com.AppNotifica_o.Notificacao.controller;

import com.AppNotifica_o.Notificacao.dtos.cursoMinistrado.DtoCreateCursoMinistrado;
import com.AppNotifica_o.Notificacao.dtos.cursoMinistrado.DtoListCursoMinistrado;
import com.AppNotifica_o.Notificacao.dtos.cursoMinistrado.DtoUpdateCursoMinistrado;
import com.AppNotifica_o.Notificacao.service.CursoMinistradoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/professor/curso-ministrado")
public class CursoMinistradoController {
    @Autowired
    private CursoMinistradoService cursoMinistradoService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DtoCreateCursoMinistrado data) {
        var cursoMinistrado = this.cursoMinistradoService.createCursoMinistrado(data);
        return ResponseEntity.ok(cursoMinistrado);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable UUID id) {
        var cursoMinistrado = this.cursoMinistradoService.getCursMinistrado(id);
        return ResponseEntity.ok(cursoMinistrado);
    }

    @GetMapping
    public ResponseEntity<Page<DtoListCursoMinistrado>> list(@PageableDefault Pageable pageable) {
        var page = this.cursoMinistradoService.getAllCursoMinistrado(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DtoUpdateCursoMinistrado data) {
        var cursoMinistrado = this.cursoMinistradoService.updateCursoMinistrado(data);
        return ResponseEntity.ok(cursoMinistrado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable UUID id) {
        this.cursoMinistradoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
