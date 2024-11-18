package com.AppNotifica_o.Notificacao.controller;

import com.AppNotifica_o.Notificacao.dtos.curso.DtoCreateCurso;
import com.AppNotifica_o.Notificacao.dtos.curso.DtoListCurso;
import com.AppNotifica_o.Notificacao.dtos.curso.DtoUpdateCurso;
import com.AppNotifica_o.Notificacao.repository.CursoRepository;
import com.AppNotifica_o.Notificacao.service.CursoService;
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
@RequestMapping("aluno/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid DtoCreateCurso data) {
        var curso = this.cursoService.createCurso(data);
        return ResponseEntity.ok(curso);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable UUID id) {
        var curso = this.cursoService.getCurso(id);
        return ResponseEntity.ok(curso);
    }

    @GetMapping
    public ResponseEntity<Page<DtoListCurso>> list(@PageableDefault Pageable pageable) {
        var page = this.cursoService.getAllCurso(pageable);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DtoUpdateCurso data) {
        var curso = this.cursoService.updateCurso(data);
        return ResponseEntity.ok(curso);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable UUID id) {
        this.cursoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
